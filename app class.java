import java.util.ArrayList;
import java.util.List;

public class Patron {
    private String name;
    private String patronId;
    private List<Book> borrowedBooks;

    // Constructor to initialize a patron
    public Patron(String name, String patronId) {
        this.name = name;
        this.patronId = patronId;
        this.borrowedBooks = new ArrayList<>();
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getPatronId() {
        return patronId;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    // Borrow a book
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    // Return a book
    public boolean returnBook(String isbn) {
        for (Book book : borrowedBooks) {
            if (book.getIsbn().equals(isbn)) {
                borrowedBooks.remove(book);
                return true;
            }
        }
        return false; // Book not found in borrowed list
    }

    @Override
    public String toString() {
        return "Patron{" +
                "name='" + name + '\'' +
                ", patronId='" + patronId + '\'' +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }
}