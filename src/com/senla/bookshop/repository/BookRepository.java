package com.senla.bookshop.repository;

import com.senla.bookshop.model.Book;

import java.util.ArrayList;
import java.util.Optional;

public class BookRepository {
    private ArrayList<Book> books = new ArrayList<>();

    public boolean add(Book book) {
        return books.add(book);
    }

    public Optional<Book> get(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return Optional.of(book);
            }
        }

        return Optional.empty();
    }

    public boolean remove(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return books.remove(book);
            }
        }

        return false;
    }

    public boolean remove(Book book) {
        return books.remove(book);
    }

    public boolean update(Book book) {
        remove(book.getId());
        return books.add(book);
    }

    public int getNexId() {
        return books.size();
    }

}
// TODO дописать сервис