package com.company.RichardFenixU1M5Summative.dao;

import com.company.RichardFenixU1M5Summative.dto.Author;
import com.company.RichardFenixU1M5Summative.dto.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AuthorDaoTest {

    @Autowired
    AuthorDao authorDao;
    @Autowired
    PublisherDao publisherDao;
//    @Autowired
//    BookDao bookDao;

    @Before
    public void setUp() throws Exception {
        // Clean up the test db
        // Note: Game table should be deleted first since Book table has foreign keys to all other tables.
//        List<Book> gList = bookDao.getAllBook();
//        for (Book g : gList) {
//            bookDao.deleteBook(g.getBookId());
//        }

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
    public void addGetDeleteAuthor() {
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

        // Now, object should have the database-generated author_id (must be programmed in AuthorDaoJdbcTemplateImpl)
        // Run the getAuthor() method here as well
        Author author1 = authorDao.getAuthor(author.getAuthorId());

        // addAuthor() test
        assertEquals(author1, author);

        authorDao.deleteAuthor(author.getAuthorId());

        // Get the object reference
        author1 = authorDao.getAuthor(author.getAuthorId());

        // deleteAuthor test
        assertNull(author1);

    }

    @Test
    public void getAllAuthor() {
        Author author = new Author();
        author.setFirstName("Rich");
        author.setLastName("Fen");
        author.setStreet("123 Ashford Dunwoody");
        author.setCity("Atlanta");
        author.setState("GA");
        author.setPostalCode("30346");
        author.setPhone("123-456-7890");
        author.setEmail("rich@gmail.com");

        // Object added to the database
        author = authorDao.addAuthor(author);

        author = new Author();
        author.setFirstName("Jet");
        author.setLastName("Li");
        author.setStreet("456 Roswell Road");
        author.setCity("Roswell");
        author.setState("GA");
        author.setPostalCode("30067");
        author.setPhone("404-456-7890");
        author.setEmail("jet@gmail.com");

        // Object added to the database
        author = authorDao.addAuthor(author);

        List<Author> cList = authorDao.getAllAuthor();
        assertEquals(cList.size(), 2);

    }

    @Test
    public void updateAuthor() {
        Author author = new Author();
        author.setFirstName("Rich");
        author.setLastName("Fen");
        author.setStreet("123 Ashford Dunwoody");
        author.setCity("Atlanta");
        author.setState("GA");
        author.setPostalCode("30346");
        author.setPhone("123-456-7890");
        author.setEmail("rich@gmail.com");

        // Object added to the database
        author = authorDao.addAuthor(author);

        author.setFirstName("Richard");
        author.setEmail("richard@gmail.com");

        authorDao.updateAuthor(author);

        // Get the reference of the updated author
        Author author1 = authorDao.getAuthor(author.getAuthorId());

        assertEquals("Richard", author1.getFirstName());
        assertEquals("richard@gmail.com", author1.getEmail());

    }
}