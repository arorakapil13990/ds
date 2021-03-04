import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookShop implements Iterable<Book> {

    static List<Book> books = new ArrayList<>();

    @Override
    public Iterator<Book> iterator() {
        return new BookIterator();
    }

    class BookIterator implements Iterator<Book> {
        int pos;

        @Override
        public boolean hasNext() {
            if (pos >= books.size()) {
                throw new ArrayIndexOutOfBoundsException();
            }
            return true;
        }

        @Override
        public Book next() {
            if (pos >= books.size()) {
                throw new ArrayIndexOutOfBoundsException();
            }
            Book b = books.get(pos);
            pos++;
            return b;
        }

        @Override
        public void remove() {

        }
    }

    public static void main(String[] args) {
        Book book1 = new Book(1, "Java");
        Book book2 = new Book(2, "Spring");
        Book book3 = new Book(3, "Struts");

        books.add(book1);
        books.add(book2);
        books.add(book3);

        for (Book book : books){
            System.out.println(book);
        }
    }
}
