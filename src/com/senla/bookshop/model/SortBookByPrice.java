package com.senla.bookshop.model;

import java.util.Comparator;

public class SortBookByPrice implements Comparator<Book> {
    @Override
    public int compare(Book book1, Book book2) {
        return book2.getPrice().compareTo(book1.getPrice());
    }
}
