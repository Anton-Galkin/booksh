package com.senla.bookshop.model;

import java.util.Comparator;

public class SortBookByPublYear implements Comparator<Book> {
    @Override
    public int compare(Book book1, Book book2) {
        return book1.getYearPubl().compareTo(book2.getYearPubl());
    }
}
