package ait.library.model;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Reader> readers;
    private List<Book> reviews;

    public Library() {
        init();
    }

    private void init() {
        books = new ArrayList<>();
        // добавляем книги
        books.add(new Book("J.K. Rowling", "Harry Potter and the Sorcerer's Stone", 1997, 4, 12)); // 0
        books.add(new Book("J.R.R. Tolkien", "The Lord of the Rings", 1954, 3, 23)); // 1
        books.add(new Book("George Orwell", "1984", 1949, 5, 19)); // 2
        books.add(new Book("Harper Lee", "To Kill a Mockingbird", 1960, 4, 36)); // 3
        books.add(new Book("F. Scott Fitzgerald", "The Great Gatsby", 1925, 2, 16)); // 4
        books.add(new Book("Leo Tolstoy", "War and Peace", 1869, 4, 27)); // 5

        readers = new ArrayList<>();
        // добавляем читателей
        readers.add(new Reader("Ivanov I. I."));
        readers.add(new Reader("John Smith"));
        readers.add(new Reader("Peter Jackson"));

        // журнал выдачи книг
        readers.get(0).getBooks().add(books.get(0)); // Иванов взял "Гарри Поттера"
        readers.get(1).getBooks().add(books.get(0)); // Smith тоже взял "Гарри Поттера"
        readers.get(2).getBooks().add(books.get(2));
        readers.get(2).getBooks().add(books.get(4));
        readers.get(2).getBooks().add(books.get(0));
        readers.get(1).getBooks().add(books.get(1));

        // добавляем лайки на отзывы на книги
        readers.get(0).setLike(10);
        readers.get(1).setLike(16);
        readers.get(2).setLike(7);
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Reader> getReaders() {
        return readers;
    }

}
