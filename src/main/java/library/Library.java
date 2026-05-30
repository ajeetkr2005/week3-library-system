package library;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;
    private ArrayList<Member> members;

    private FileHandler fileHandler;

    public Library() {

        fileHandler = new FileHandler();

        books = fileHandler.loadBooks();
        members = fileHandler.loadMembers();
    }

    public void addBook(Book book) {

        books.add(book);

        fileHandler.saveBooks(books);

        System.out.println("Book Added Successfully!");
    }

    public void displayBooks() {

        System.out.println("\n════════════════ BOOK LIST ════════════════");

        if (books.isEmpty()) {
            System.out.println("No Books Found");
            return;
        }

        for (Book b : books) {
            System.out.println(b);
        }
    }

    public void searchBook(String keyword) {

        System.out.println("\nSearch Results:\n");

        for (Book b : books) {

            if (b.getTitle().toLowerCase().contains(keyword.toLowerCase())
                    || b.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {

                System.out.println(b);
            }
        }
    }

    public void registerMember(Member member) {

        members.add(member);

        fileHandler.saveMembers(members);

        System.out.println("Member Registered Successfully!");
    }

    public Book findBook(String isbn) {

        for (Book b : books) {

            if (b.getIsbn().equals(isbn))
                return b;
        }

        return null;
    }

    public Member findMember(String id) {

        for (Member m : members) {

            if (m.getId().equals(id))
                return m;
        }

        return null;
    }

    public void borrowBook(String isbn, String memberId) {

        Book book = findBook(isbn);
        Member member = findMember(memberId);

        if (book == null || member == null) {
            System.out.println("Invalid Book or Member!");
            return;
        }

        if (!book.isAvailable()) {
            System.out.println("Book Already Borrowed!");
            return;
        }

        book.setAvailable(false);
        book.setBorrowedBy(memberId);
        book.setDueDate(LocalDate.now().plusDays(14));

        member.borrowBook(isbn);

        System.out.println("Book Borrowed Successfully!");
        System.out.println("Due Date: " + book.getDueDate());
    }

    public void returnBook(String isbn, String memberId) {

        Book book = findBook(isbn);
        Member member = findMember(memberId);

        if (book == null || member == null)
            return;

        if (book.getDueDate() != null &&
                LocalDate.now().isAfter(book.getDueDate())) {

            long days =
                    ChronoUnit.DAYS.between(
                            book.getDueDate(),
                            LocalDate.now());

            double fine = days * 5;

            System.out.println("Overdue Fine: ₹" + fine);
        }

        book.setAvailable(true);
        book.setBorrowedBy(null);
        book.setDueDate(null);

        member.returnBook(isbn);

        System.out.println("Book Returned Successfully!");
    }

    public void statistics() {

        int available = 0;

        for (Book b : books) {

            if (b.isAvailable())
                available++;
        }

        System.out.println("\n════════ LIBRARY STATISTICS ════════");

        System.out.println("Total Books : " + books.size());
        System.out.println("Available Books : " + available);
        System.out.println("Borrowed Books : " + (books.size() - available));
        System.out.println("Members : " + members.size());
    }
}