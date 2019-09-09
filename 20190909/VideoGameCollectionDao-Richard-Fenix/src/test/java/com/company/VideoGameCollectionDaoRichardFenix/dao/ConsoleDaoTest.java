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
public class ConsoleDaoTest {

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
    public void addGetDeleteConsole() {
        Console console = new Console();
        console.setName("Playstation 4");
        console.setYear("2018");

        // ps4 object added to the database
        consoleDao.addConsole(console);

        // Now, ps4 object should have the database-generated console_id (must be programmed in ConsoleDaoJdbcTemplateImpl)
        // Run the getConsole() method here as well
        Console console1 = consoleDao.getConsole(console.getConsole_id());

        // addConsole() test
        assertEquals(console1, console);

        consoleDao.deleteConsole(console.getConsole_id());

        // Get the ps4 object reference
        console1 = consoleDao.getConsole(console.getConsole_id());

        // deleteConsole test
        assertNull(console1);
    }


    @Test
    public void getAllConsole() {
        Console console = new Console();
        console.setName("Playstation 4");
        console.setYear("2018");

        // Object added to the database
        consoleDao.addConsole(console);

        console = new Console();
        console.setName("Xbox One X");
        console.setYear("2019");

        // Object added to the database
        consoleDao.addConsole(console);

        List<Console> cList = consoleDao.getAllConsole();
        assertEquals(cList.size(), 2);

    }

    @Test
    public void updateConsole() {
        Console console = new Console();
        console.setName("Playstation 4");
        console.setYear("2018");

        // Object added to the database
        consoleDao.addConsole(console);

        console.setName("Playstation 4 Pro");
        console.setYear("2019");

        consoleDao.updateConsole(console);

        // Get the reference of the updated console
        Console console1 = consoleDao.getConsole(console.getConsole_id());

        assertEquals(console1, console);

    }

}