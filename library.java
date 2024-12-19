import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    // Constructor to initialize the library
    public Library() {
        this.books = new ArrayList<>();
    }

    // Add a book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Lend a book to a patron
    public boolean lendBook(String isbn, Patron patron) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn) && book.isAvailable()) {
                book.setAvailable(false);
                patron.borrowBook(book);
                return true;
            }
        }
        return false; // Book not available or not found
    }

    // Return a book to the library
    public boolean returnBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn) && !book.isAvailable()) {
                book.setAvailable(true);
                return true;
            }
        }
        return false; // Book not found or already available
    }

    // Display all books in the library
    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
