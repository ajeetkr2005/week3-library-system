package library;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Library library = new Library();

        while (true) {

            System.out.println("\n");
            System.out.println("╔════════════════════════════════════════════╗");
            System.out.println("║       📚 LIBRARY MANAGEMENT SYSTEM 📚      ║");
            System.out.println("╠════════════════════════════════════════════╣");
            System.out.println("║ 1. Add New Book                           ║");
            System.out.println("║ 2. View All Books                         ║");
            System.out.println("║ 3. Search Book                            ║");
            System.out.println("║ 4. Register Member                        ║");
            System.out.println("║ 5. Borrow Book                            ║");
            System.out.println("║ 6. Return Book                            ║");
            System.out.println("║ 7. View Statistics                        ║");
            System.out.println("║ 8. Exit                                   ║");
            System.out.println("╚════════════════════════════════════════════╝");

            System.out.print("\nEnter Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("ISBN: ");
                    String isbn = sc.nextLine();

                    System.out.print("Title: ");
                    String title = sc.nextLine();

                    System.out.print("Author: ");
                    String author = sc.nextLine();

                    System.out.print("Year: ");
                    int year = sc.nextInt();

                    library.addBook(
                            new Book(isbn, title, author, year));
                    break;

                case 2:

                    library.displayBooks();
                    break;

                case 3:

                    System.out.print("Keyword: ");
                    String key = sc.nextLine();

                    library.searchBook(key);
                    break;

                case 4:

                    System.out.print("Member ID: ");
                    String id = sc.nextLine();

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    library.registerMember(
                            new Member(id, name));
                    break;

                case 5:

                    System.out.print("ISBN: ");
                    String borrowISBN = sc.nextLine();

                    System.out.print("Member ID: ");
                    String borrowID = sc.nextLine();

                    library.borrowBook(
                            borrowISBN,
                            borrowID);
                    break;

                case 6:

                    System.out.print("ISBN: ");
                    String returnISBN = sc.nextLine();

                    System.out.print("Member ID: ");
                    String returnID = sc.nextLine();

                    library.returnBook(
                            returnISBN,
                            returnID);
                    break;

                case 7:

                    library.statistics();
                    break;

                case 8:

                    System.out.println("\nThank You For Using Library System ❤️");
                    System.exit(0);

                default:

                    System.out.println("Invalid Choice!");
            }
        }
    }
}