package ait.library.model;

import java.util.Objects;

public class Book implements Comparable<Book> {
    private String author;
    private String name;
    private Integer issueYear;
    private int rating;
    private int review;

    public Book(String author, String name, Integer issueYear, int rating, int review) {
        this.author = author;
        this.name = name;
        this.issueYear = issueYear;
        this.rating = rating;
        this.review = review;
    }

    public int getRating() {
        return rating;
    }

    public int getReview() {
        return review;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public Integer getIssueYear() {
        return issueYear;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setReview(int review) {
        this.review = review;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (!Objects.equals(author, book.author)) return false;
        if (!Objects.equals(name, book.name)) return false;
        return Objects.equals(issueYear, book.issueYear);
    }

    @Override
    public int hashCode() {
        int result = author != null ? author.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (issueYear != null ? issueYear.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("author='").append(author).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", issueYear=").append(issueYear);
        sb.append(", rating=").append(rating);
        sb.append(", review=").append(review);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(Book o) {
        return author.compareTo(o.getAuthor());
    }
}
