package library;

import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    private final String BOOK_FILE = "data/books.txt";
    private final String MEMBER_FILE = "data/members.txt";

    public void saveBooks(ArrayList<Book> books) {

        try (PrintWriter pw = new PrintWriter(new FileWriter(BOOK_FILE))) {

            for (Book b : books) {
                pw.println(
                        b.getIsbn() + "," +
                                b.getTitle() + "," +
                                b.getAuthor() + "," +
                                b.getYear());
            }

        } catch (Exception e) {
            System.out.println("Error Saving Books!");
        }
    }

    public ArrayList<Book> loadBooks() {

        ArrayList<Book> books = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(BOOK_FILE))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] p = line.split(",");

                books.add(
                        new Book(
                                p[0],
                                p[1],
                                p[2],
                                Integer.parseInt(p[3])));
            }

        } catch (Exception e) {

        }

        return books;
    }

    public void saveMembers(ArrayList<Member> members) {

        try (PrintWriter pw = new PrintWriter(new FileWriter(MEMBER_FILE))) {

            for (Member m : members) {
                pw.println(m.getId() + "," + m.getName());
            }

        } catch (Exception e) {
            System.out.println("Error Saving Members!");
        }
    }

    public ArrayList<Member> loadMembers() {

        ArrayList<Member> members = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(MEMBER_FILE))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] p = line.split(",");

                members.add(
                        new Member(
                                p[0],
                                p[1]));
            }

        } catch (Exception e) {

        }

        return members;
    }
}