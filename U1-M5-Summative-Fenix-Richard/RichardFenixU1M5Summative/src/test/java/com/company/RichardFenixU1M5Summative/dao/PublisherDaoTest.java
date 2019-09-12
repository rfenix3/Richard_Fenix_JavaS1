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
public class PublisherDaoTest {

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
    public void addGetDeletePublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("Random House");
        publisher.setStreet("33 Ravina Drive");
        publisher.setCity("Atlanta");
        publisher.setState("GA");
        publisher.setPostalCode("30346");
        publisher.setPhone("123-456-7890");
        publisher.setEmail("rich@gmail.com");

        // object added to the database
        publisherDao.addPublisher(publisher);

        // Now, object should have the database-generated publisher_id (must be programmed in PublisherDaoJdbcTemplateImpl)
        // Run the getPublisher() method here as well
        Publisher publisher1 = publisherDao.getPublisher(publisher.getPublisherId());

        // addPublisher() test
        assertEquals(publisher1, publisher);

        publisherDao.deletePublisher(publisher.getPublisherId());

        // Get the object reference
        publisher1 = publisherDao.getPublisher(publisher.getPublisherId());

        // deletePublisher test
        assertNull(publisher1);
    }

    @Test
    public void getAllPublisher() {
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

        publisher = new Publisher();
        publisher.setName("Pearson Education Inc");
        publisher.setStreet("999 Roswell Road");
        publisher.setCity("Roswell");
        publisher.setState("GA");
        publisher.setPostalCode("30067");
        publisher.setPhone("404-456-7890");
        publisher.setEmail("pearson@gmail.com");

        // Object added to the database
        publisher = publisherDao.addPublisher(publisher);

        List<Publisher> cList = publisherDao.getAllPublisher();
        assertEquals(cList.size(), 2);

    }

    @Test
    public void updatePublisher() {
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

        publisher.setName("Random Publishing");
        publisher.setEmail("randomhouse@gmail.com");

        publisherDao.updatePublisher(publisher);

        // Get the reference of the updated publisher
        Publisher publisher1 = publisherDao.getPublisher(publisher.getPublisherId());

        assertEquals("Random Publishing", publisher1.getName());
        assertEquals("randomhouse@gmail.com", publisher1.getEmail());

    }

}