package step.learning.OOP;
import java.util.List;
import java.util.ArrayList;
public class Library extends Book{
    private final List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void add(Book book) {
        books.add(book);
    }

    public void printAllCards() {
        for (Book book : books) {
            System.out.println(book.getCard());
        }
    }
}
