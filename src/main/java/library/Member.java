package library;

import java.util.ArrayList;

public class Member {

    private String id;
    private String name;
    private ArrayList<String> borrowedBooks;

    public Member(String id, String name) {
        this.id = id;
        this.name = name;
        borrowedBooks = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(String isbn) {
        borrowedBooks.add(isbn);
    }

    public void returnBook(String isbn) {
        borrowedBooks.remove(isbn);
    }

    @Override
    public String toString() {
        return "ID: " + id +
                " | Name: " + name +
                " | Borrowed Books: " + borrowedBooks.size();
    }
}