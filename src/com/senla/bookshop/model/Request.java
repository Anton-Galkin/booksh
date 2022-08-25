package com.senla.bookshop.model;

import java.time.LocalDate;

public class Request {

    private int id;
    private LocalDate requestDate;
    private boolean completed = false;

    private Request(LocalDate requestDate) {
        this.requestDate = requestDate;
    }
    public int getId() {
        return 0; //TODO completing
    }

    public boolean getRequestCompleted() {
        return completed;
    }

    public boolean setRequestCompleted() {
        return this.completed = true;
    }
}
