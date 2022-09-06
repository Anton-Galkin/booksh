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
		return repository.getAllSortByAlphabet();
	}

	public List<Book> getAllSortByPrice() {
		return repository.getAllSortByPrice();
	}

	public List<Book> getAllSortByPublYear() {
		return repository.getAllSortByYearPubl();
	}

	public List<Book> getAllSortByAvailabel() {
		return repository.getAllSortByAvailable();
	}
}
