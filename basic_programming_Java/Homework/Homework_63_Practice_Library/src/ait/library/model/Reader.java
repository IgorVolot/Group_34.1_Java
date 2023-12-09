package ait.library.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Reader {
    private String fio;
    private List<Book> books;
    private int like;

    public Reader(String fio) {
        this.fio = fio;
        this.books = new ArrayList<>();
    }

    public String getFio() {
        return fio;
    }

    public List<Book> getBooks() {
        return books;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reader reader = (Reader) o;

        return Objects.equals(fio, reader.fio);
    }

    @Override
    public int hashCode() {
        return fio != null ? fio.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Reader{");
        sb.append("fio='").append(fio).append('\'');
        sb.append(", books=").append(books);
        sb.append(", like=").append(like);
        sb.append('}');
        return sb.toString();
    }
}
