package com.company.VideoGameCollectionDaoRichardFenix.dao;

import com.company.VideoGameCollectionDaoRichardFenix.model.Console;
import com.company.VideoGameCollectionDaoRichardFenix.model.Game;
import com.company.VideoGameCollectionDaoRichardFenix.model.Publisher;
import com.company.VideoGameCollectionDaoRichardFenix.model.Type;
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
    ConsoleDao consoleDao;
    @Autowired
    GameDao gameDao;
    @Autowired
    PublisherDao publisherDao;
    @Autowired
    TypeDao typeDao;

    @Before
    public void setUp() throws Exception {
        // Clean up the test db
        // Note: Game table should be deleted first since Game table has foreign keys to all other tables.
        List<Game> gList = gameDao.getAllGame();
        for (Game g : gList) {
            gameDao.deleteGame(g.getGame_id());
        }

        List<Console> cList = consoleDao.getAllConsole();
        for (Console c : cList) {
            consoleDao.deleteConsole(c.getConsole_id());
        }

        List<Publisher> pList = publisherDao.getAllPublisher();
        for (Publisher p : pList) {
            publisherDao.deletePublisher(p.getPublisher_id());
        }

        List<Type> tList = typeDao.getAllType();
        for (Type t : tList) {
            typeDao.deleteType(t.getType_id());
        }

    }

    @Test
    public void addGetDeletePublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("EA Sports");
        publisher.setWebsite("easports.com");

        // Publisher object added to the database
        publisherDao.addPublisher(publisher);

        // Now, publisher object should have the database-generated publisher_id (must be programmed in PublisherDaoJdbcTemplateImpl)
        // Run the getPublisher() method here as well
        Publisher publisher1 = publisherDao.getPublisher(publisher.getPublisher_id());

        // addPublisher() test
        assertEquals(publisher1, publisher);

        publisherDao.deletePublisher(publisher.getPublisher_id());

        // Get the object reference
        publisher1 = publisherDao.getPublisher(publisher.getPublisher_id());

        // deletePublisher test
        assertNull(publisher1);

    }

    @Test
    public void getAllPublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("EA Sports");
        publisher.setWebsite("easports.com");

        // Object added to the database
        publisherDao.addPublisher(publisher);

        publisher = new Publisher();
        publisher.setName("Activision Blizzard");
        publisher.setWebsite("activisionblizzard.com");

        // Object added to the database
        publisherDao.addPublisher(publisher);

        List<Publisher> cList = publisherDao.getAllPublisher();
        assertEquals(cList.size(), 2);
    }

    @Test
    public void updatePublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("EA Sports");
        publisher.setWebsite("easports.com");

        // Object added to the database
        publisherDao.addPublisher(publisher);

        publisher.setName("EA Games");
        publisher.setWebsite("eagames.com");

        publisherDao.updatePublisher(publisher);

        // Get the reference of the updated publisher
        Publisher publisher1 = publisherDao.getPublisher(publisher.getPublisher_id());

        assertEquals(publisher1, publisher);

    }

}