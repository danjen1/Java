import java.util.ArrayList;
 
public class Library {
 
    private ArrayList<Book> books;
 
    public Library() {
        this.books = new ArrayList<Book>();
    }
 
    public void addBook(Book book) {
        this.books.add(book);
    }
 
    public void printBooks() {
        for (Book book : this.books) {
            System.out.println(book);
        }
    }
 
    public ArrayList<Book> searchByTitle(String title) {
        return searchBook(title, null, -1);
    }
 
    public ArrayList<Book> searchByPublisher(String publisher) {
        return searchBook(null, publisher, -1);
    }
 
    public ArrayList<Book> searchByYear(int year) {
        return searchBook(null, null, year);
    }
 
    // Helper method
    public ArrayList<Book> searchBook(String title, String bookName, int year) {
        ArrayList<Book> found = new ArrayList<Book>();
        for (Book book : this.books) {
            if (StringUtils.included(book.title(), title)
                    || StringUtils.included(book.publisher(), bookName)
                    || book.year() == year) {
                found.add(book);
            }
        }
 
        return found;
    }
}
 