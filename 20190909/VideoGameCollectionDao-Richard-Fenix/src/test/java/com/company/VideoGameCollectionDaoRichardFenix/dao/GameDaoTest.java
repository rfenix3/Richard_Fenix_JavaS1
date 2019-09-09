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
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GameDaoTest {
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
    public void addGetDeleteGame() {

        //========= Game data dependency creation starts here ===================

        // Creating the Console primary key dependency for Game table
        Console console = new Console();
        console.setName("Playstation 4");
        console.setYear("2018");

        // Console object added to the database
        console = consoleDao.addConsole(console);

        // Creating the Type primary key dependency for Game table
        Type type = new Type();
        type.setName("Bluray");
        type.setDescription("Games on blu ray format/discs");

        // Type object added to the database
        type = typeDao.addType(type);

        // Creating the Publisher primary key dependency for Game table
        Publisher publisher = new Publisher();
        publisher.setName("EA Sports");
        publisher.setWebsite("easports.com");

        // Publisher object added to the database
        publisher = publisherDao.addPublisher(publisher);

        //========= Game data dependency creation ends here =====================

        Game game = new Game();
        game.setConsole_id(console.getConsole_id());
        game.setPublisher_id(publisher.getPublisher_id());
        game.setType_id(type.getType_id());

        // Game object added to the database
        game = gameDao.addGame(game);

        // Now, Game object should have the database-generated game_id (must be programmed in GameDaoJdbcTemplateImpl)
        // Run the getGame() method here as well
        Game game1 = gameDao.getGame(game.getGame_id());

        // addConsole() test
        assertEquals(game1, game);

        gameDao.deleteGame(game.getGame_id());

        // Get the object reference
        game1 = gameDao.getGame(game.getGame_id());

        // deleteGame test
        assertNull(game1);
    }


    @Test(expected  = DataIntegrityViolationException.class)
    public void addWithRefIntegrityException() {

        Game game = new Game();
        game.setConsole_id(99);
        game.setPublisher_id(54);
        game.setType_id(91);

        game = gameDao.addGame(game);
    }

    @Test
    public void getAllGame() {
        //========= Game data dependency creation starts here ===================

        // Creating the Console primary key dependency for Game table
        Console console = new Console();
        console.setName("Playstation 4");
        console.setYear("2018");

        // Console object added to the database
        console = consoleDao.addConsole(console);

        // Creating the Type primary key dependency for Game table
        Type type = new Type();
        type.setName("Bluray");
        type.setDescription("Games on blu ray format/discs");

        // Type object added to the database
        type = typeDao.addType(type);

        // Add second type for creating multiple game rows
        Type type2 = new Type();
        type2.setName("DVD");
        type2.setDescription("Games on DVD format/discs");

        // Object added to the database
        type2 = typeDao.addType(type2);

        // Creating the Publisher primary key dependency for Game table
        Publisher publisher = new Publisher();
        publisher.setName("EA Sports");
        publisher.setWebsite("easports.com");

        // Publisher object added to the database
        publisher = publisherDao.addPublisher(publisher);

        //========= Game data dependency creation ends here =====================

        Game game = new Game();
        game.setConsole_id(console.getConsole_id());
        game.setPublisher_id(publisher.getPublisher_id());
        game.setType_id(type.getType_id());

        game = gameDao.addGame(game);

        // Create another game data starting here
        game.setConsole_id(console.getConsole_id());
        game.setPublisher_id(publisher.getPublisher_id());

        // We are adding type2 here to ensure new Game row will not have duplicate set of primary keys.
        game.setType_id(type2.getType_id());

        game = gameDao.addGame(game);

        List<Game> aList = gameDao.getAllGame();

        assertEquals(aList.size(), 2);

    }

    @Test
    public void updateGame() {
        //========= Game data dependency creation starts here ===================

        // Creating the Console primary key dependency for Game table
        Console console = new Console();
        console.setName("Playstation 4");
        console.setYear("2018");

        // Console object added to the database
        console = consoleDao.addConsole(console);

        // Creating the Type primary key dependency for Game table
        Type type = new Type();
        type.setName("Bluray");
        type.setDescription("Games on blu ray format/discs");

        // Type object added to the database
        type = typeDao.addType(type);

        // Add second type for creating multiple game rows
        Type type2 = new Type();
        type2.setName("DVD");
        type2.setDescription("Games on DVD format/discs");

        // Object added to the database
        type2 = typeDao.addType(type2);

        // Creating the Publisher primary key dependency for Game table
        Publisher publisher = new Publisher();
        publisher.setName("EA Sports");
        publisher.setWebsite("easports.com");

        // Publisher object added to the database
        publisher = publisherDao.addPublisher(publisher);

        //========= Game data dependency creation ends here =====================

        Game game = new Game();
        game.setConsole_id(console.getConsole_id());
        game.setPublisher_id(publisher.getPublisher_id());
        game.setType_id(type.getType_id());

        // Game object added to the database
        game = gameDao.addGame(game);

        // Update type_id with type2's type_id
        game.setType_id(type2.getType_id());

        gameDao.updateGame(game);

        // Create game1 reference to game
        Game game1 = gameDao.getGame(game.getGame_id());
        assertEquals(game1, game);

    }

}