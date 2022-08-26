package com.senla.bookshop.model;

import java.time.LocalDate;
import java.util.Objects;

public class Book {

	private int id;
	private String title;
	private String author;
	private LocalDate yearPubl;
	private boolean available = true;

	public Book() {

	}

	public Book(int id, String title, String author, LocalDate yearPubl) {
		this(title, author, yearPubl);
		this.id = id;
	}

	public Book(String title, String author, LocalDate yearPubl) {
		this.title = title;
		this.author = author;
		this.yearPubl = yearPubl;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && id == other.id && Objects.equals(title, other.title)
				&& Objects.equals(yearPubl, other.yearPubl);
	}

	public String getAuthor() {
		return author;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public LocalDate getYearPubl() {
		return yearPubl;
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, id, title, yearPubl);
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setYearPubl(LocalDate yearPubl) {
		this.yearPubl = yearPubl;
	}

}
