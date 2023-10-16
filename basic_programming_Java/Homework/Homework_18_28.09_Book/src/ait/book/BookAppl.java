package ait.book;
/*
         Create a Book class in the ait.book.model package. In this class, define the fields: private long isbn;
         private String title; private String author; private int yearOfPublishing; Create constructors to initialize
         all fields, and a constructor to initialize the field when absence of the author. The rest of the designers
         are at your discretion. Create getters and setters, based on logic and necessity. Create a public void display()
         method to print book information to the console.

         Create a class BookAppl in the package ait.book with the main method. In the main method, create several
         instances of Book and print the result for each of them display method works.
 */

import ait.book.model.Book;

public class BookAppl {
    public static void main(String[] args) {
        Book book1 = new Book(123456781, "Book1", "Author1", 1967);
        Book book2 = new Book("Bible",  1274);
        Book book3 = new Book(123456783, "Book3",  1984);
        Book book4 = new Book(123456784, 1991);
        Book book5 = new Book(123456785, "Book5", 2003);

        book1.display();
        book2.display();
        book3.display();
        book4.display();
        book5.display();

    }
}
