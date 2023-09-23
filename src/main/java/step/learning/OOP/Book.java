package step.learning.OOP;

public class Book extends Literature{
    private String author;

    public Book() {

    }
    public Book(String author, String title) {

        this.setAuthor( author );
        super.setTitle( title );
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String getCard() {
        return String.format(
                "Book \nName: %s \nAuthor: %s",
                getAuthor(),
                getTitle()
        );
    }


}
