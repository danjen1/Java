package Chapter16;
import java.util.*;

public class TestTree
{
    public static void main(String[] args)
    {
        new TestTree().go();
    }

    public class BookCompare implements Comparator<Book>
    {
        public int compare(Book one, Book two)
        {
            return (one.title.compareTo(two.title));
        }
    }
    public void go ()
    {
        Book b1 = new Book("How Cats Work");
        Book b2 = new Book("Remix Your Body");
        Book b3 = new Book("Finding Emo");
        BookCompare bCOmpare = new BookCompare();
        TreeSet<Book> tree = new TreeSet<Book>(bCOmpare);
        TreeSet<Book> tree1 = new TreeSet<Book>();
        tree.add(b1);
        tree.add(b2);
        tree.add(b3);

        System.out.println(tree);
    }
    class Book implements Comparable
    {
        String title;
        public Book(String title)
        {
            this.title = title;
        }
        public int compareTo(Object b)
        {
            Book book = (Book) b;
            return (title.compareTo(book.title));
        }
        public String toString()
        {
            return title;
        }
    }
}
