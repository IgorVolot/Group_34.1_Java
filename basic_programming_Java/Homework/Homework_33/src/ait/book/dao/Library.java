package ait.book.dao;

/*
 * Copyright (c) 2023.
 *  Igor Volotovskyi
 */

import ait.book.model.Book;

public interface Library {
    boolean addBook(Book book);
    int quantity();
    Book findBook(long isbn);
    Book removeBook(long isbn);
    Book[] findBookByName(String name);
    Book[] findBookByAuthor(String author);
    Book[] findBookByYear(int year);
}
