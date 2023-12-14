package ait.library.model;

import java.time.LocalDate;

public class Review {
    private Reader reader;
    private String comment;
    private Book book;
    private long id;
    private int rating;
    private int likes;
    private LocalDate date;

    public Review(Reader reader, Book book, int rating,  String comment ) {
        this.reader = reader;
        this.book = book;
        this.rating = rating;
        this.comment = comment;
    }

    public long getId() {
        return id;
    }

    public int getRating() {
        return rating;
    }

    public Reader getReader() {
        return reader;
    }

    public String getComment() {
        return comment;
    }

    public Book getBook() {
        return book;
    }

    public int getLikes() {
        return likes;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Review{");
        sb.append(", id=").append(id);
        sb.append(", book=").append(book);
        sb.append(", rating=").append(rating);
        sb.append("reader=").append(reader);
        sb.append(", comment='").append(comment).append('\'');
        sb.append(", likes=").append(likes);
        sb.append('}');
        return sb.toString();
    }
}
