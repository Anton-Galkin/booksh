package com.senla.bookshop.service;

import java.time.LocalDate;
import java.util.List;

import com.senla.bookshop.model.Book;
import com.senla.bookshop.model.Request;
import com.senla.bookshop.repository.RequestRepository;

public class RequestService {
	private BookService bookService;

	private RequestRepository repository;

	public RequestService(RequestRepository repository) {
		this.repository = repository;
	}

	public int addRequest(Book book) {

		if (!book.isAvailable()) {
			Request request = new Request();
			request.setBook(book);
			request.setRequestDate(LocalDate.now());
			return repository.add(request);
		}
		return -1;
	}

	public void closeRequests(Book book) {
		for (Request request : repository.getAll()) {
			if (request.getBook().equals(book)) {
				request.setCompleted(true);
				repository.update(request);
			}
		}
	}

	public List<Request> getAllSortByQuantity() {
		return repository.getAllSortByQuantity();
	}

	public Request getRequest(int id) {
		return repository.get(id).get();
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
}