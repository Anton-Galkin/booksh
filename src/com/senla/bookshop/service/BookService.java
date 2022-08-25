package com.senla.bookshop.service;

import com.senla.bookshop.repository.BookRepository;
public class BookService {
    private BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public void addBookStorage() { // TODO add a book to the storage

    }
}


