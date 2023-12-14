package ait.library.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Book implements Comparable<Book> {
    private String author;
    private String name;
    private Integer issueYear;
    private List<Review> reviewList;

    public Book(String author, String name, Integer issueYear) {
        this.author = author;
        this.name = name;
        this.issueYear = issueYear;
        this.reviewList = new ArrayList<>();
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
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(Book o) {
        return author.compareTo(o.getAuthor());
    }
}
