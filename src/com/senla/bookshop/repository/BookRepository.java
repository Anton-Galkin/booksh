package com.senla.bookshop.repository;

import com.senla.bookshop.model.Book;

import java.util.ArrayList;
import java.util.Comparator;
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
	
	public List<Book> getAllSortByAlphabet() {
		List<Book> list = new ArrayList<>();
		list.addAll(books);
		
		list.sort(new Comparator<Book>() {

			@Override
			public int compare(Book book1, Book book2) {
		        return book1.getTitle().compareTo(book2.getTitle());
			}
		});
		
		return list;
	}

	public List<Book> getAllSortByPrice() {
		List<Book> list = new ArrayList<>();
		list.addAll(books);

		list.sort(new Comparator<Book>() {

			@Override
			public int compare(Book book1, Book book2) {
				return book1.getPrice().compareTo(book2.getPrice());
			}
		});

		return list;
	}

	public List<Book> getAllSortByYearPubl() {
		List<Book> list = new ArrayList<>();
		list.addAll(books);

		list.sort(new Comparator<Book>() {

			@Override
			public int compare(Book book1, Book book2) {
				return book1.getYearPubl().compareTo(book2.getYearPubl());
			}
		});

		return list;
	}

	public List<Book> getAllSortByAvailable() {
		List<Book> list = new ArrayList<>();
		list.addAll(books);

		list.sort(new Comparator<Book>() {

			@Override
			public int compare(Book book1, Book book2) {
				if (book1.isAvailable() && book2.isAvailable() || !book1.isAvailable() && !book2.isAvailable()) {
					return 0;
				}
				if (book1.isAvailable() && !book2.isAvailable())
					return 1;
				return -1;
			}
		});

		return list;
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
