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
public class TypeDaoTest {
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
    public void addGetDeleteType() {
        Type type = new Type();
        type.setName("Bluray");
        type.setDescription("Games on blu ray format/discs");

        // object added to the database
        typeDao.addType(type);

        // Now, object should have the database-generated type_id (must be programmed in TypeDaoJdbcTemplateImpl)
        // Run the getType() method here as well
        Type type1 = typeDao.getType(type.getType_id());

        // addType() test
        assertEquals(type1, type);

        typeDao.deleteType(type.getType_id());

        // Get the object reference
        type1 = typeDao.getType(type.getType_id());

        // deleteType test
        assertNull(type1);
    }

    @Test
    public void getAllType() {
        Type type = new Type();
        type.setName("Bluray");
        type.setDescription("Games on blu ray format/discs");

        // Object added to the database
        typeDao.addType(type);

        type = new Type();
        type.setName("DVD");
        type.setDescription("Games on DVD format/discs");

        // Object added to the database
        typeDao.addType(type);

        List<Type> cList = typeDao.getAllType();
        assertEquals(cList.size(), 2);
    }

    @Test
    public void updateType() {
        Type type = new Type();
        type.setName("DVD");
        type.setDescription("Games on DVD format/discs");

        // Object added to the database
        typeDao.addType(type);

        type.setName("4K");
        type.setDescription("Games on 4K format/discs");

        typeDao.updateType(type);

        // Get the reference of the updated type
        Type type1 = typeDao.getType(type.getType_id());

        assertEquals(type1, type);
    }


}