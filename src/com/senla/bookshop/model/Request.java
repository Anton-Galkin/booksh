package com.senla.bookshop.model;

import java.time.LocalDate;

public class Request {

	private int id;
	private LocalDate requestDate;
	private Book book;
	private boolean completed = false;

	private Request(int id) {
		this.id = id;
	}

	private Request(int id, LocalDate requestDate, Book book) {
		this(id);
		this.requestDate = requestDate;
		this.book = book;
	}

	public int getId() {
		return 0; // TODO completing
	}

	public boolean getRequestCompleted() {
		return completed;
	}

	public boolean setRequestCompleted() {
		return this.completed = true;
	}
}
