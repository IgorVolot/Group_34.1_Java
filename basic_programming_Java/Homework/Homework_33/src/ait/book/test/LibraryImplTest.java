package ait.book.test;

/*
 * Copyright (c) 2023.
 *  Igor Volotovskyi
 */

import ait.book.dao.Library;
import ait.book.dao.LibraryImpl;
import ait.book.model.Book;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LibraryImplTest {
    private Library library;
    private Book[] books;

    @BeforeEach
    void setUp() {
        library = new LibraryImpl(7);
        books = new Book[6];
        books[0] = new Book(10001l, "Book1", "Author1", 1901);
        books[1] = new Book(10002l, "Book2", "Author1", 1902);
        books[2] = new Book(10003l, "Book3", "Author3", 1974);
        books[3] = new Book(10004l, "Book4", "Author4", 1974);
        books[4] = new Book(10005l, "Book5", "Author5", 2021);
        books[5] = new Book(10006l, "Book5", "Author6", 2020);
        for (int i = 0; i < books.length; i++) {
            library.addBook(books[i]);
        }
    }

    @Test
    void addBook() {
        assertFalse(library.addBook(null));
        assertFalse(library.addBook(books[2]));
        Book book = new Book(10012l, "Book7", "Author7", 1982);
        assertTrue(library.addBook(book));
        assertEquals(7, library.quantity());
        book = new Book(10112l, "Book8", "Author8", 1992);
        assertFalse(library.addBook(book));
    }

    @Test
    void quantity() {
        assertEquals(6, library.quantity());
    }

    @Test
    void findBook() {
        Book book = library.findBook(10004l);
        assertEquals(books[3], library.findBook(10004l));
        assertNull(library.findBook(200111101l));
    }

    @Test
    void removeBook() {
        Book book = library.removeBook(10005l);
        assertEquals(books[4], book);
        assertEquals(5, library.quantity());
        assertNull(library.removeBook(10005l));

    }

    @Test
    void findBookByName() {
        Book[] actual = library.findBookByName("Book5");
        Book[] expected = {books[4], books[5]};
        assertArrayEquals(expected, actual);
    }

    @Test
    void findBookByAuthor() {
        Book[] actual = library.findBookByAuthor("Author1");
        Book[] expected = {books[0], books[1]};
        assertArrayEquals(expected, actual);
    }

    @Test
    void findBookByYear() {
        Book[] actual = library.findBookByYear(1974);
        Book[] expected = {books[2], books[3]};
        assertArrayEquals(expected,actual);
    }
}