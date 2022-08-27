package com.senla.bookshop.model;

import java.time.LocalDate;

public class Request {

	private Integer id;
	private LocalDate requestDate;
	private Book book;
	private boolean completed = false;

	public Request() {

	}

	public Request(int id) {
		this.id = id;
	}

	public Request(int id, LocalDate requestDate, Book book) {
		this(id);
		this.requestDate = requestDate;
		this.book = book;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public LocalDate getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(LocalDate requestDate) {
		this.requestDate = requestDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getRequestCompleted() {
		return completed;
	}

	public boolean setRequestCompleted() {
		return this.completed = true;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
}
