package ait.book.dao;

/*
 * Copyright (c) 2023.
 *  Igor Volotovskyi
 */

import ait.book.model.Book;

import java.util.function.Predicate;

public class LibraryImpl implements Library {
    private Book[] books;
    private int size;

    public LibraryImpl(int capacity) {
        books = new Book[capacity];
    }

    @Override
    public boolean addBook(Book book) {
        if (book == null || findBook(book.getIsbn()) != null || size == books.length) {
            return false;
        }
        books[size++] = book;
        return true;
    }

    @Override
    public int quantity() {
        return size;
    }

    @Override
    public Book findBook(long isbn) {
        for (int i = 0; i < size; i++) {
            if (books[i].getIsbn() == isbn) {
                return books[i];
            }
        }
        return null;
    }

    @Override
    public Book removeBook(long isbn) {
        for (int i = 0; i < size; i++) {
            if (books[i].getIsbn() == isbn){
                Book removedBook = books[i];
                books[i] = books[--size];
                books[size] = null;
                return removedBook;
            }
        }
        return null;
    }

    @Override
    public Book[] findBookByName(String name) {
        return findByPredicate(book -> book.getName().equals(name));
    }

    @Override
    public Book[] findBookByAuthor(String author) {
        return findByPredicate(book -> book.getAuthor().equals(author));
    }

    @Override
    public Book[] findBookByYear(int year) {
        return findByPredicate(book -> book.getYearOfIssue() == year);
    }

    private Book[] findByPredicate(Predicate<Book> predicate) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (predicate.test(books[i])) {
                count++;
            }
        }
        Book[] result = new Book[count];
        for (int i = 0, j = 0; j < result.length; i++) {
            if (predicate.test(books[i])) {
                result[j++] = books[i];
            }
        }
        return result;
    }
}
