package com.senla.bookshop.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.senla.bookshop.model.*;
import com.senla.bookshop.repository.BookRepository;

import static java.util.Collections.*;

public class BookService {
	private BookRepository repository;
	private RequestService requestService;

	public BookService(BookRepository repository) {
		this.repository = repository;
	}

	public BookService(BookRepository repository, RequestService requestService) {
		this(repository);
		this.requestService = requestService;
	}

	public int addBook(Book book) {
		book.setAvailable(true);

		if (!repository.contains(book)) {
			return repository.add(book);
		}

		requestService.closeRequests(book);
		repository.update(book);

		return book.getId();
	}

	public void discardBook(Book book) {
		book.setAvailable(false);
		repository.update(book);
	}

	public List<Book> getAll() {
		return repository.getAll();
	}
	
	public Book getBook(int id) {
		Optional<Book> optional = repository.get(id);
		return optional.get();
	}
	
	public void setRequestService(RequestService requestService) {
		this.requestService = requestService;
	}

	public List<Book> getAllSortByAlphabet() {
		List<Book> list = new ArrayList<>();
		list.addAll(repository.getAll());
		list.sort(new SortBookByAlphabet());
		return list;
	}

	public List<Book> getAllSortByPrice() {
		List<Book> list = new ArrayList<>();
		list.addAll(repository.getAll());
		list.sort(new SortBookByPrice());
		return list;
	}

	public List<Book> getAllSortByPublYear() {
		List<Book> list = new ArrayList<>();
		list.addAll(repository.getAll());
		list.sort(new SortBookByPublYear());
		return list;
	}

	public List<Book> getAllSortByAvailabel() {
		List<Book> list = new ArrayList<>();
		list.addAll(repository.getAll());
		list.sort(new SortBookByAvailable());
		return list;
	}
}
