package com.senla.bookshop.repository;

import com.senla.bookshop.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookRepository {
	private ArrayList<Book> books = new ArrayList<>();

	public int add(Book book) {
		book.setId(getNexId());
		books.add(book);
		return book.getId();
	}

	public boolean contains(Book book) {
		return books.contains(book);
	}

	public Optional<Book> get(int id) {
		for (Book book : books) {
			if (book.getId() == id) {
				return Optional.of(book);
			}
		}

		return Optional.empty();
	}

	public List<Book> getAll() {
		return books;
	}

	public void remove(Book book) {
		books.remove(book);
	}

	public void remove(int id) {
		for (Book book : books) {
			if (book.getId() == id) {
				books.remove(book);
				return;
			}
		}
	}

	public void update(Book book) {
		remove(book.getId());
		books.add(book);
	}

	private int getNexId() {
		return books.size();
	}

}
