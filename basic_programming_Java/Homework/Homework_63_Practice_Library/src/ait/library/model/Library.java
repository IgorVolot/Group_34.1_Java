package ait.library.model;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Reader> readers;
    private List<Review> reviews;

    public Library() {
        init();
    }

    private void init() {
        books = new ArrayList<>();
        // добавляем книги
        books.add(new Book("J.K. Rowling", "Harry Potter and the Sorcerer's Stone", 1997)); // 0
        books.add(new Book("J.R.R. Tolkien", "The Lord of the Rings", 1954)); // 1
        books.add(new Book("George Orwell", "1984", 1949)); // 2
        books.add(new Book("Harper Lee", "To Kill a Mockingbird", 1960)); // 3
        books.add(new Book("F. Scott Fitzgerald", "The Great Gatsby", 1925)); // 4
        books.add(new Book("Leo Tolstoy", "War and Peace", 1869)); // 5

        readers = new ArrayList<>();
        // добавляем читателей
        readers.add(new Reader("Ivanov I. I.", "ivanov.i@mail.ru",true));
        readers.add(new Reader("John Smith", "john.smith@google.com", true));
        readers.add(new Reader("Peter Jackson", "pit.jackson@org.de", true));

        // журнал выдачи книг
        readers.get(0).getBooks().add(books.get(0)); // Иванов взял "Гарри Поттера"
        readers.get(1).getBooks().add(books.get(0)); // Smith тоже взял "Гарри Поттера"
        readers.get(2).getBooks().add(books.get(2));
        readers.get(2).getBooks().add(books.get(4));
        readers.get(2).getBooks().add(books.get(0));
        readers.get(1).getBooks().add(books.get(1));

        // отзывы читателей и лайки на отзывы
        reviews = new ArrayList<>();
        reviews.add(new Review(readers.get(0),books.get(0), 3, "Very good!"));
        reviews.add(new Review(readers.get(0),books.get(0), 5, ""));
        reviews.add(new Review(readers.get(0),books.get(0), 4, "Bad!"));
        reviews.add(new Review(readers.get(0),books.get(0), 2, "Awful!"));
        reviews.add(new Review(readers.get(0),books.get(0), 5, "Brilliant!"));
        reviews.add(new Review(readers.get(0),books.get(0), 4, "Good!"));
        reviews.add(new Review(readers.get(0),books.get(0), 4, "Good!"));
        reviews.add(new Review(readers.get(1),books.get(1), 3, "Excellent!"));
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Reader> getReaders() {
        return readers;
    }

    public List<Review> getReviews(){
        return reviews;
    }

}
