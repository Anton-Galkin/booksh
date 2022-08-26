package com.senla.bookshop.service;

import java.util.List;
import java.util.Optional;

import com.senla.bookshop.model.Book;
import com.senla.bookshop.repository.BookRepository;

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
}
