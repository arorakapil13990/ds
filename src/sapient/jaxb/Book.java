package sapient.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.File;

@XmlRootElement(name = "book")
@XmlType(propOrder = {
        "author",
        "name",
        "publisher",
        "isbn"
})
public class Book {

    private String name;
    private String author;
    private String publisher;
    private String isbn;

    @XmlElement(name = "title")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }

    public static void main(String[] args) throws JAXBException {
        Book book = new Book();
        book.setIsbn("978-0134685991");
        book.setName("Effective Java");
        book.setAuthor("Joshua Bloch");
        book.setPublisher("Amazon");

        JAXBContext context = JAXBContext.newInstance(Book.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        // Write to System.out
        m.marshal(book, System.out);

        // Write to File
        m.marshal(book, new File("bookstore-jaxb.xml"));


        Unmarshaller un = context.createUnmarshaller();
        Book unmarshalBook = (Book) un.unmarshal(new File("bookstore-jaxb.xml"));
        System.out.println(unmarshalBook);
    }

}

