package com.senla.bookshop.model;

import java.time.LocalDate;

public class Book {

    private int id;
    private String title;
    private String author;
    private LocalDate yearPubl;

    private Book(String title, String author, LocalDate yearPubl) {
        this.title = title;
        this.author = author;
        this.yearPubl = yearPubl;
    }


    public int getId() {
        return 0;  //TODO completing
    }
}
