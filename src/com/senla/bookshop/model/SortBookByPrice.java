package com.senla.bookshop.model;

import java.util.Comparator;

public class SortBookByPrice implements Comparator<Book> {
    @Override
    public int compare(Book book1, Book book2) {
        return book1.getPrice().compareTo(book2.getPrice());
    }
}
