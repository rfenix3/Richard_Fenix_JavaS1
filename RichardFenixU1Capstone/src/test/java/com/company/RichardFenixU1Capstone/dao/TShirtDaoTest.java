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
public class TShirtDaoTest {

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
    public void addGetDeleteTShirt() {
        TShirt tShirt = new TShirt();
        tShirt.setSize("Small");
        tShirt.setColor("Red");
        tShirt.setDescription("Small red T-shirt.");
        tShirt.setPrice(new BigDecimal("29.99"));
        tShirt.setQuantity(24);
        tShirtDao.addTShirt(tShirt);

        TShirt tShirt1 = tShirtDao.getTShirt(tShirt.gettShirtId());

        assertEquals(tShirt1, tShirt);

        tShirtDao.deleteTShirt(tShirt.gettShirtId());

        tShirt1 = tShirtDao.getTShirt(tShirt.gettShirtId());

        assertNull(tShirt1);

    }


    @Test
    public void getAllTShirts() {
        TShirt tShirt = new TShirt();
        tShirt.setSize("Small");
        tShirt.setColor("Red");
        tShirt.setDescription("Small red T-shirt.");
        tShirt.setPrice(new BigDecimal("29.99"));
        tShirt.setQuantity(20);
        tShirtDao.addTShirt(tShirt);

        tShirt = new TShirt();
        tShirt.setSize("M");
        tShirt.setColor("Blue");
        tShirt.setDescription("Medium blue T-shirt.");
        tShirt.setPrice(new BigDecimal("19.99"));
        tShirt.setQuantity(24);
        tShirtDao.addTShirt(tShirt);

        List<TShirt> lList = tShirtDao.getAllTShirts();

        assertEquals(2, lList.size());
    }

    @Test
    public void updateTShirt() {
        TShirt tShirt = new TShirt();
        tShirt.setSize("Small");
        tShirt.setColor("Red");
        tShirt.setDescription("Small red T-shirt.");
        tShirt.setPrice(new BigDecimal("29.99"));
        tShirt.setQuantity(20);
        tShirtDao.addTShirt(tShirt);

        tShirt.setPrice(new BigDecimal("14.99"));
        tShirtDao.updateTShirt(tShirt);

        TShirt tShirt1 = tShirtDao.getTShirt(tShirt.gettShirtId());

        assertEquals(new BigDecimal("14.99"), tShirt1.getPrice());
    }

}