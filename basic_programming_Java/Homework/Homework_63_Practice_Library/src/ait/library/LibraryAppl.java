package ait.library;

import ait.library.model.Book;
import ait.library.model.Library;
import ait.library.model.Reader;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LibraryAppl {
    public static void main(String[] args) {
        Library library = new Library();
        System.out.println("--------- List of books Unsorted -----------");
        library.getBooks().forEach(System.out::println);
        System.out.println();

        System.out.println("--------- List of books sorted by rating -----------");
        List<Book> booksSortedByRating = library.getBooks().stream()
                .sorted(Comparator.comparingInt(Book::getRating))
                .collect(Collectors.toList());
        booksSortedByRating.forEach(System.out::println);
        System.out.println();

        System.out.println("--------- List of books sorted by number of reviews -----------");
        List<Book> booksSortedByReviews = library.getBooks().stream()
                .sorted(Comparator.comparingInt(Book::getReview))
                .collect(Collectors.toList());
        booksSortedByReviews.forEach(System.out::println);
        System.out.println();

        System.out.println("------ List of readers sorted by number of likes for the reviews ---------");
        List<Reader> readersSortedByLikes = library.getReaders().stream()
                .sorted(Comparator.comparing(Reader::getLike))
                .collect(Collectors.toList());
        readersSortedByLikes.forEach(System.out::println);

    }
}
