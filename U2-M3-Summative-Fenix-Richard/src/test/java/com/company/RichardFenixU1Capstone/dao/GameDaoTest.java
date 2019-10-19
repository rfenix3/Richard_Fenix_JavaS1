package com.company.RichardFenixU1Capstone.dao;

import com.company.RichardFenixU1Capstone.dto.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
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
    InvoiceDao invoiceDao;
    @Autowired
    ProcessingFeeDao processingFeeDao;
    @Autowired
    SalesTaxRateDao salesTaxRateDao;
    @Autowired
    TShirtDao tShirtDao;

    @Before
    public void setUp() throws Exception {
        // Clean up the test db
        List<Invoice> iList = invoiceDao.getAllInvoices();
        for (Invoice i : iList) {
            invoiceDao.deleteInvoice(i.getInvoiceId());
        }

        List<Console> cList = consoleDao.getAllConsoles();
        for (Console c : cList) {
            consoleDao.deleteConsole(c.getConsoleId());
        }

        List<Game> gList = gameDao.getAllGames();
        for (Game g : gList) {
            gameDao.deleteGame(g.getGameId());
        }

        List<TShirt> tList = tShirtDao.getAllTShirts();
        for (TShirt t : tList) {
            tShirtDao.deleteTShirt(t.gettShirtId());
        }

        List<ProcessingFee> pList = processingFeeDao.getAllProcessingFees();
        for (ProcessingFee p : pList) {
            processingFeeDao.deleteProcessingFee(p.getProductType());
        }

        List<SalesTaxRate> sList = salesTaxRateDao.getAllSalesTaxRates();
        for (SalesTaxRate s : sList) {
            salesTaxRateDao.deleteSalesTaxRate(s.getState());
        }
    }

    @Test
    public void addGetDeleteGame() {
        Game game = new Game();
        game.setTitle("NBA 2k20");
        game.setEsrbRating("Everyone");
        game.setDescription("NBA Video Game");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("EASports");
        game.setQuantity(80);
        gameDao.addGame(game);

        Game game1 = gameDao.getGame(game.getGameId());

        assertEquals(game1, game);

        gameDao.deleteGame(game.getGameId());

        game1 = gameDao.getGame(game.getGameId());

        assertNull(game1);

    }

    @Test
    public void getAllGames() {
        Game game = new Game();
        game.setTitle("NBA 2k20");
        game.setEsrbRating("Everyone");
        game.setDescription("NBA Video Game");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("EASports");
        game.setQuantity(80);
        gameDao.addGame(game);

        game = new Game();
        game.setTitle("Call of Duty: Modern Warfare");
        game.setEsrbRating("Mature 17+");
        game.setDescription("First Person Shooter");
        game.setPrice(new BigDecimal("49.99"));
        game.setStudio("Activision");
        game.setQuantity(35);
        gameDao.addGame(game);

        List<Game> lList = gameDao.getAllGames();

        assertEquals(2, lList.size());
    }

    @Test
    public void updateGame() {
        Game game = new Game();
        game.setTitle("NBA 2k20");
        game.setEsrbRating("Everyone");
        game.setDescription("NBA Video Game");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("EASports");
        game.setQuantity(80);
        gameDao.addGame(game);

        game.setPrice(new BigDecimal("29.99"));
        gameDao.updateGame(game);

        Game game1 = gameDao.getGame(game.getGameId());

        assertEquals(new BigDecimal("29.99"), game1.getPrice());
    }

    @Test
    public void getGamesByStudio() {

        Game game = new Game();
        game.setTitle("NBA 2k20");
        game.setEsrbRating("Everyone");
        game.setDescription("NBA Video Game");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("EASports");
        game.setQuantity(80);
        gameDao.addGame(game);

        game = new Game();
        game.setTitle("Call of Duty: Modern Warfare");
        game.setEsrbRating("Mature 17+");
        game.setDescription("First Person Shooter");
        game.setPrice(new BigDecimal("49.99"));
        game.setStudio("Activision");
        game.setQuantity(35);
        gameDao.addGame(game);

        game = new Game();
        game.setTitle("Madden 2k20");
        game.setEsrbRating("Everyone");
        game.setDescription("Football Video Game");
        game.setPrice(new BigDecimal("49.99"));
        game.setStudio("EASports");
        game.setQuantity(80);
        gameDao.addGame(game);

        List<Game> tList = gameDao.getGamesByStudio("EASports");
        assertEquals(2, tList.size());

        tList = gameDao.getGamesByStudio("Activision");
        assertEquals(1, tList.size());

    }

    @Test
    public void getGamesByEsrbRating() {

        Game game = new Game();
        game.setTitle("NBA 2k20");
        game.setEsrbRating("Everyone");
        game.setDescription("NBA Video Game");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("EASports");
        game.setQuantity(80);
        gameDao.addGame(game);

        game = new Game();
        game.setTitle("Call of Duty: Modern Warfare");
        game.setEsrbRating("Mature 17+");
        game.setDescription("First Person Shooter");
        game.setPrice(new BigDecimal("49.99"));
        game.setStudio("Activision");
        game.setQuantity(35);
        gameDao.addGame(game);

        game = new Game();
        game.setTitle("Madden 2k20");
        game.setEsrbRating("Everyone");
        game.setDescription("Football Video Game");
        game.setPrice(new BigDecimal("49.99"));
        game.setStudio("EASports");
        game.setQuantity(80);
        gameDao.addGame(game);

        List<Game> tList = gameDao.getGamesByEsrbRating("Everyone");
        assertEquals(2, tList.size());

        tList = gameDao.getGamesByEsrbRating("Mature 17+");
        assertEquals(1, tList.size());

    }

    @Test
    public void getGameByTitle() {
        Game game = new Game();
        game.setTitle("NBA 2k20");
        game.setEsrbRating("Everyone");
        game.setDescription("NBA Video Game");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("EASports");
        game.setQuantity(80);
        game = gameDao.addGame(game);

        Game game2 = new Game();
        game2.setTitle("Call of Duty: Modern Warfare");
        game2.setEsrbRating("Mature 17+");
        game2.setDescription("First Person Shooter");
        game2.setPrice(new BigDecimal("49.99"));
        game2.setStudio("Activision");
        game2.setQuantity(35);
        gameDao.addGame(game2);

        Game game3 = gameDao.getGameByTitle("NBA 2k20");

        assertEquals(game3, game);

    }


}