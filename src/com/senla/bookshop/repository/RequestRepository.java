package com.senla.bookshop.repository;

import com.senla.bookshop.model.Book;
import com.senla.bookshop.model.Request;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RequestRepository {
    private ArrayList<Request> requests = new ArrayList<>();

    public int add(Request request) {
        request.setId(getNextId());
        requests.add(request);
        return request.getId();
    }

    private int getNextId() {
        return requests.size();
    }

    public Optional<Request> get(int id) {
        for (Request request : requests) {
            if (request.getId() == id) {
                return Optional.of(request);
            }
        }

        return Optional.empty();
    }


    public void remove(Request request) {
        requests.remove(request);
    }

    public void remove(int id) {
        for (Request request : requests) {
            if (request.getId() == id) {
                requests.remove(request);
                return;  //TODO why return?
            }
        }
    }

    public void update(Request request) {
        remove(request.getId());
        requests.add(request);
    }

    public int getNexId() {
        return requests.size();
    }

    public List<Request> getAll() {
        return requests;
    }

    public boolean contains(Request request) {
        return requests.contains(request);
    }
}
