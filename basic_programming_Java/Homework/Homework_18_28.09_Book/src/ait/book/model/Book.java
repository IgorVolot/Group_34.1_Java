package ait.book.model;

public class Book {
    private long isbn;
    private String title;
    private String author;
    private int yearOfPublishing;

    public Book(long isbn, String title, String author, int yearOfPublishing) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.yearOfPublishing = yearOfPublishing;
    }

    public Book(long isbn, String title, int yearOfPublishing) {
        this.isbn = isbn;
        this.title = title;
        this.yearOfPublishing = yearOfPublishing;
        author = "Unknown";
    }

    public Book(long isbn, int yearOfPublishing) {
        this.isbn = isbn;
        this.yearOfPublishing = yearOfPublishing;
        title = "Storybook";
        author = "Unknown";
    }

    public Book(String title, int yearOfPublishing) {
        this.title = title;
        this.yearOfPublishing = yearOfPublishing;
        author = "Unknown";
    }

    public long getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    public void display() {
        System.out.println("Isbn: " + isbn + ", title " + title + ", author: " + author + ", year of publishing: " + yearOfPublishing);
    }
}
