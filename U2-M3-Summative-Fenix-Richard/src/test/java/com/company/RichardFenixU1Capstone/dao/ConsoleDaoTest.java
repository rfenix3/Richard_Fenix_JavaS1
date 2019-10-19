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
public class ConsoleDaoTest {

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
    public void addGetDeleteConsole() {
        Console console = new Console();
        console.setModel("PS4 Pro");
        console.setManufacturer("Sony");
        console.setMemoryAmount("1 TB");
        console.setProcessor("AMD Jaguar 8-core");
        console.setPrice(new BigDecimal("350.00"));
        console.setQuantity(30);
        consoleDao.addConsole(console);

        Console console1 = consoleDao.getConsole(console.getConsoleId());

        assertEquals(console1, console);

        consoleDao.deleteConsole(console.getConsoleId());

        console1 = consoleDao.getConsole(console.getConsoleId());

        assertNull(console1);
    }

    @Test
    public void getAllConsoles() {
        Console console = new Console();
        console.setModel("PS4 Pro");
        console.setManufacturer("Sony");
        console.setMemoryAmount("1 TB");
        console.setProcessor("AMD Jaguar 8-core");
        console.setPrice(new BigDecimal("349.99"));
        console.setQuantity(30);
        consoleDao.addConsole(console);

        console = new Console();
        console.setModel("Switch");
        console.setManufacturer("Nintendo");
        console.setMemoryAmount("32 GB");
        console.setProcessor("Cortex 4-core");
        console.setPrice(new BigDecimal("299.99"));
        console.setQuantity(25);
        consoleDao.addConsole(console);

        List<Console> lList = consoleDao.getAllConsoles();

        assertEquals(2, lList.size());

    }

    @Test
    public void updateConsole() {
        Console console = new Console();
        console.setModel("PS4 Pro");
        console.setManufacturer("Sony");
        console.setMemoryAmount("1 TB");
        console.setProcessor("AMD Jaguar 8-core");
        console.setPrice(new BigDecimal("349.99"));
        console.setQuantity(30);
        consoleDao.addConsole(console);

        console.setPrice(new BigDecimal("299.99"));
        console.setMemoryAmount("500 GB");
        consoleDao.updateConsole(console);

        Console console1 = consoleDao.getConsole(console.getConsoleId());

        assertEquals("500 GB", console1.getMemoryAmount());
        assertEquals(new BigDecimal("299.99"), console1.getPrice());

    }

    @Test
    public void getConsolesByManufacturer() {

        Console console = new Console();
        console.setModel("PS4 Pro");
        console.setManufacturer("Sony");
        console.setMemoryAmount("1 TB");
        console.setProcessor("AMD Jaguar 8-core");
        console.setPrice(new BigDecimal("349.99"));
        console.setQuantity(30);
        consoleDao.addConsole(console);

        console = new Console();
        console.setModel("Switch");
        console.setManufacturer("Nintendo");
        console.setMemoryAmount("32 GB");
        console.setProcessor("Cortex 4-core");
        console.setPrice(new BigDecimal("299.99"));
        console.setQuantity(25);
        consoleDao.addConsole(console);

        console = new Console();
        console.setModel("Family Computer Retro");
        console.setManufacturer("Nintendo");
        console.setMemoryAmount("8 GB");
        console.setProcessor("Intel 4-core");
        console.setPrice(new BigDecimal("79.99"));
        console.setQuantity(40);
        consoleDao.addConsole(console);

        List<Console> tList = consoleDao.getConsolesByManufacturer("Nintendo");
        assertEquals(2, tList.size());

        tList = consoleDao.getConsolesByManufacturer("Sony");
        assertEquals(1, tList.size());

    }


}