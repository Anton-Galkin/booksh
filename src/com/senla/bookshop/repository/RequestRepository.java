package com.senla.bookshop.repository;

import com.senla.bookshop.model.Book;
import com.senla.bookshop.model.Request;

import java.util.ArrayList;
import java.util.Optional;

public class RequestRepository {
    private ArrayList<Request> requests = new ArrayList<>();

    public boolean add(Request request) {
        return requests.add(request);
    }

    public Optional<Request> get(int id) {
        for (Request request : requests) {
            if (request.getId() == id) {
                return Optional.of(request);
            }
        }

        return Optional.empty();
    }

    public boolean remove(int id) {
        for (Request request : requests) {
            if (request.getId() == id) {
                return requests.remove(request);
            }
        }

        return false;
    }

    public boolean remove(Request request) {
        return requests.remove(request);
    }

    public boolean update(Request request) {
        remove(request.getId());
        return requests.add(request);
    }

    public int getNexId() {
        return requests.size();
    }

}
