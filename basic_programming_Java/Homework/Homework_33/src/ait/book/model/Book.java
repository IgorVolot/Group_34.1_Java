package ait.book.model;

/*
 * Copyright (c) 2023.
 *  Igor Volotovskyi
 */

public class Book {
    private long isbn;
    private String name;
    private String author;
    private int yearOfIssue;

    public Book(long isbn, String name, String author, int yearOfIssue) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.yearOfIssue = yearOfIssue;
    }

    public long getIsbn() {
        return isbn;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfIssue() {
        return yearOfIssue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYearOfIssue(int yearOfIssue) {
        this.yearOfIssue = yearOfIssue;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Book book = (Book) object;

        return isbn == book.isbn;
    }

    @Override
    public int hashCode() {
        return (int) (isbn ^ (isbn >>> 32));
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book ");
        sb.append("isbn- ").append(isbn);
        sb.append(", name= ").append(name).append('\'');
        sb.append(", author ").append(author).append('\'');
        sb.append(", yearOfIssue- ").append(yearOfIssue);
        return sb.toString();
    }
}
