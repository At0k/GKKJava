import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

class Book {
    private String name;
    private int age;
    private String bookTitle;
    private boolean isAvailable;

    public Book(String bookTitle) {
        this.bookTitle = bookTitle;
        this.isAvailable = true; // Initially, all books are available
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void rentBook() {
        isAvailable = false;
    }

    public void returnBook() {
        isAvailable = true;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for age
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class AssignJava2_1 {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        // Add some books to the list
        books.add(new Book("Abu"));
        books.add(new Book("Abuyah"));
        books.add(new Book("Abuyah yang Teliti"));

        try {
            while (true) {
                System.out.println("\n1. View available books");
                System.out.println("2. Borrow a book");
                System.out.println("3. Return a book");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1:
                        // View available books
                        System.out.println("\nAvailable Books:");
                        for (int i = 0; i < books.size(); i++) {
                            if (books.get(i).isAvailable()) {
                                System.out.println((i + 1) + ". " + books.get(i).getBookTitle());
                            }
                        }
                        break;

                    case 2:
                        // Borrow a book
                        System.out.println("\nEnter the book number to borrow:");
                        int bookIndexToRent = scanner.nextInt() - 1;
                        scanner.nextLine(); // Consume the newline

                        if (bookIndexToRent >= 0 && bookIndexToRent < books.size() && books.get(bookIndexToRent).isAvailable()) {
                            System.out.println("Enter start date for borrowing (dd/MM/yyyy):");
                            String startDateInput = scanner.nextLine();
                            Date startDate = dateFormat.parse(startDateInput);

                            System.out.println("Enter end date for borrowing (dd/MM/yyyy):");
                            String endDateInput = scanner.nextLine();
                            Date endDate = dateFormat.parse(endDateInput);

                            books.get(bookIndexToRent).rentBook();
                            System.out.println("Book borrowed successfully from " + startDateInput + " to " + endDateInput);
                        } else {
                            System.out.println("Invalid selection or book is not available.");
                        }
                        break;

                    case 3:
                        // Return a book
                        System.out.println("\nEnter the book number to return:");
                        int bookIndexToReturn = scanner.nextInt() - 1;

                        if (bookIndexToReturn >= 0 && bookIndexToReturn < books.size() && !books.get(bookIndexToReturn).isAvailable()) {
                            books.get(bookIndexToReturn).returnBook();
                            System.out.println("Book returned successfully.");
                        } else {
                            System.out.println("Invalid selection or book is already available.");
                        }
                        break;

                    case 4:
                        // Exit the program
                        System.out.println("Thank you. Goodbye!");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
        } catch (ParseException e) {
            System.out.println("Error: Invalid date format. Please enter the date in dd/MM/yyyy format.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
