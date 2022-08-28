package com.senla.bookshop.service;

import com.senla.bookshop.model.Book;
import com.senla.bookshop.repository.RequestRepository;

public class RequestService {
    private RequestRepository repository;

    public RequestService(RequestRepository repository) {
        this.repository = repository;
    }

    public void leaveRequestBook() { //TODO leave a request for a book
        //if there are no books, leave a request for it
    }

    public void closeRequests(Book book) {
    }
}
// TODO дописать