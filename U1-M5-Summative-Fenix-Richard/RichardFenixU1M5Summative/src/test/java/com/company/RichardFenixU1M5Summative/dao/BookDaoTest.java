package com.company.RichardFenixU1M5Summative.dao;

import com.company.RichardFenixU1M5Summative.dto.Author;
import com.company.RichardFenixU1M5Summative.dto.Book;
import com.company.RichardFenixU1M5Summative.dto.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookDaoTest {
    @Autowired
    AuthorDao authorDao;
    @Autowired
    PublisherDao publisherDao;
    @Autowired
    BookDao bookDao;

    @Before
    public void setUp() throws Exception {
        // Clean up the test db
        // Note: Game table should be deleted first since Book table has foreign keys to all other tables.
        List<Book> bList = bookDao.getAllBook();
        for (Book b : bList) {
            bookDao.deleteBook(b.getBookId());
        }

        List<Author> aList = authorDao.getAllAuthor();
        for (Author a : aList) {
            authorDao.deleteAuthor(a.getAuthorId());
        }

        List<Publisher> pList = publisherDao.getAllPublisher();
        for (Publisher p : pList) {
            publisherDao.deletePublisher(p.getPublisherId());
        }
    }

    @Test
    public void addGetDeleteBook() {
        //========= Book data dependency creation starts here ===================

        // Creating the Author primary key dependency for Book table
        Author author = new Author();
        author.setFirstName("Rich");
        author.setLastName("Fen");
        author.setStreet("123 Ashford Dunwoody");
        author.setCity("Atlanta");
        author.setState("GA");
        author.setPostalCode("30346");
        author.setPhone("123-456-7890");
        author.setEmail("rich@gmail.com");

        // object added to the database
        authorDao.addAuthor(author);

        // Creating the Publisher primary key dependency for Book table
        Publisher publisher = new Publisher();
        publisher.setName("Random House");
        publisher.setStreet("33 Ravina Drive");
        publisher.setCity("Atlanta");
        publisher.setState("GA");
        publisher.setPostalCode("30346");
        publisher.setPhone("123-456-7890");
        publisher.setEmail("random@gmail.com");

        // Object added to the database
        publisher = publisherDao.addPublisher(publisher);

        //========= Book data dependency creation ends here =====================

        Book book = new Book();
        book.setIsbn("RS-12345.");
        book.setPublishDate(LocalDate.now());
        book.setAuthorId(author.getAuthorId());
        book.setTitle("This is the Book Title");
        book.setPublisherId(publisher.getPublisherId());
        book.setPrice(new BigDecimal("15.99"));

        // Book object added to the database
        book = bookDao.addBook(book);

        // Now, Book object should have the database-generated book_id (must be programmed in BookDaoJdbcTemplateImpl)
        // Run the getBook() method here as well
        Book book1 = bookDao.getBook(book.getBookId());

        // add test
        assertEquals(book1, book);

        bookDao.deleteBook(book.getBookId());

        // Get the object reference
        book1 = bookDao.getBook(book.getBookId());

        // deleteBook test
        assertNull(book1);
    }

    @Test
    public void getAllBook() {
        //========= Book data dependency creation starts here ===================

        // Creating the Author primary key dependency for Book table
        Author author = new Author();
        author.setFirstName("Rich");
        author.setLastName("Fen");
        author.setStreet("123 Ashford Dunwoody");
        author.setCity("Atlanta");
        author.setState("GA");
        author.setPostalCode("30346");
        author.setPhone("123-456-7890");
        author.setEmail("rich@gmail.com");

        // object added to the database
        authorDao.addAuthor(author);

        // Creating the Publisher primary key dependency for Book table
        Publisher publisher = new Publisher();
        publisher.setName("Random House");
        publisher.setStreet("33 Ravina Drive");
        publisher.setCity("Atlanta");
        publisher.setState("GA");
        publisher.setPostalCode("30346");
        publisher.setPhone("123-456-7890");
        publisher.setEmail("random@gmail.com");

        // Object added to the database
        publisher = publisherDao.addPublisher(publisher);

        // Create additional Publisher
        Publisher publisher2 = new Publisher();
        publisher2.setName("Pearson Education Inc");
        publisher2.setStreet("999 Roswell Road");
        publisher2.setCity("Roswell");
        publisher2.setState("GA");
        publisher2.setPostalCode("30067");
        publisher2.setPhone("404-456-7890");
        publisher2.setEmail("pearson@gmail.com");

        // Object added to the database
        publisher2 = publisherDao.addPublisher(publisher2);

        //========= Book data dependency creation ends here =====================

        Book book = new Book();
        book.setIsbn("RS-12345.");
        book.setPublishDate(LocalDate.now());
        book.setAuthorId(author.getAuthorId());
        book.setTitle("This is the Book Title");
        book.setPublisherId(publisher.getPublisherId());
        book.setPrice(new BigDecimal("15.99"));

        // Book object added to the database
        book = bookDao.addBook(book);

        // Create another book data with different publisher starting here
        book.setIsbn("PE-67890.");
        book.setPublishDate(LocalDate.now());

        // same author
        book.setAuthorId(author.getAuthorId());
        book.setTitle("This is the Book Title");

        // different publisher
        book.setPublisherId(publisher2.getPublisherId());
        book.setPrice(new BigDecimal("12.99"));

        // Book object added to the database
        book = bookDao.addBook(book);

        List<Book> bList = bookDao.getAllBook();

        assertEquals(2, bList.size());

    }

    @Test
    public void updateBook() {
        //========= Book data dependency creation starts here ===================

        // Creating the Author primary key dependency for Book table
        Author author = new Author();
        author.setFirstName("Rich");
        author.setLastName("Fen");
        author.setStreet("123 Ashford Dunwoody");
        author.setCity("Atlanta");
        author.setState("GA");
        author.setPostalCode("30346");
        author.setPhone("123-456-7890");
        author.setEmail("rich@gmail.com");

        // object added to the database
        authorDao.addAuthor(author);

        // Creating the Publisher primary key dependency for Book table
        Publisher publisher = new Publisher();
        publisher.setName("Random House");
        publisher.setStreet("33 Ravina Drive");
        publisher.setCity("Atlanta");
        publisher.setState("GA");
        publisher.setPostalCode("30346");
        publisher.setPhone("123-456-7890");
        publisher.setEmail("random@gmail.com");

        // Object added to the database
        publisher = publisherDao.addPublisher(publisher);

        //========= Book data dependency creation ends here =====================

        Book book = new Book();
        book.setIsbn("RS-12345.");
        book.setPublishDate(LocalDate.now());
        book.setAuthorId(author.getAuthorId());
        book.setTitle("Core Java");
        book.setPublisherId(publisher.getPublisherId());
        book.setPrice(new BigDecimal("15.99"));

        // Book object added to the database
        book = bookDao.addBook(book);

        book.setTitle("Core Java 2nd Edition");
        book.setPrice(new BigDecimal("18.99"));

        bookDao.updateBook(book);

        // Get the reference of the updated publisher
        Book book1 = bookDao.getBook(book.getBookId());

        assertEquals("Core Java 2nd Edition", book1.getTitle());

        BigDecimal bd1 = new BigDecimal("18.99");
        BigDecimal bd2 = book1.getPrice();

        assertEquals(bd1, bd2);

    }

    @Test
    public void getBookByAuthor() {
        //========= Book data dependency creation starts here ===================

        // Creating the Author primary key dependency for Book table
        Author author = new Author();
        author.setFirstName("Rich");
        author.setLastName("Fen");
        author.setStreet("123 Ashford Dunwoody");
        author.setCity("Atlanta");
        author.setState("GA");
        author.setPostalCode("30346");
        author.setPhone("123-456-7890");
        author.setEmail("rich@gmail.com");

        // object added to the database
        authorDao.addAuthor(author);

        // Add another Author
        Author author2 = new Author();
        author2.setFirstName("Jet");
        author2.setLastName("Li");
        author2.setStreet("456 Roswell Road");
        author2.setCity("Roswell");
        author2.setState("GA");
        author2.setPostalCode("30067");
        author2.setPhone("404-456-7890");
        author2.setEmail("jet@gmail.com");

        // Object added to the database
        author2 = authorDao.addAuthor(author2);

        // Creating the Publisher primary key dependency for Book table
        Publisher publisher = new Publisher();
        publisher.setName("Random House");
        publisher.setStreet("33 Ravina Drive");
        publisher.setCity("Atlanta");
        publisher.setState("GA");
        publisher.setPostalCode("30346");
        publisher.setPhone("123-456-7890");
        publisher.setEmail("random@gmail.com");

        // Object added to the database
        publisher = publisherDao.addPublisher(publisher);

        // Create additional Publisher
        Publisher publisher2 = new Publisher();
        publisher2.setName("Pearson Education Inc");
        publisher2.setStreet("999 Roswell Road");
        publisher2.setCity("Roswell");
        publisher2.setState("GA");
        publisher2.setPostalCode("30067");
        publisher2.setPhone("404-456-7890");
        publisher2.setEmail("pearson@gmail.com");

        // Object added to the database
        publisher2 = publisherDao.addPublisher(publisher2);

        //========= Book data dependency creation ends here =====================

        Book book = new Book();
        book.setIsbn("RS-12345.");
        book.setPublishDate(LocalDate.now());
        book.setAuthorId(author.getAuthorId());
        book.setTitle("Core Java");
        book.setPublisherId(publisher.getPublisherId());
        book.setPrice(new BigDecimal("15.99"));

        // Book #1 object added to the database
        book = bookDao.addBook(book);

        // Create another book data with different publisher but same author
        Book book2 = new Book();
        book2.setIsbn("PE-67890.");
        book2.setPublishDate(LocalDate.now());
        book2.setAuthorId(author.getAuthorId());
        book2.setTitle("Core Java 2nd Edition");
        book2.setPublisherId(publisher2.getPublisherId());
        book2.setPrice(new BigDecimal("12.99"));

        // Book #2 object added to the database
        book2 = bookDao.addBook(book2);

        // Create book 3 data with different Author but same publisher
        Book book3 = new Book();
        book3.setIsbn("XX-77777.");
        book3.setPublishDate(LocalDate.now());

        // Different author
        book3.setAuthorId(author2.getAuthorId());
        book3.setTitle("React Redux Vol 1");


        book3.setPublisherId(publisher2.getPublisherId());
        book3.setPrice(new BigDecimal("15.99"));

        // Book #3 object added to the database
        book3 = bookDao.addBook(book3);

        List<Book> bList = bookDao.getBookByAuthor(book.getAuthorId());

        assertEquals(2, bList.size());
    }

}