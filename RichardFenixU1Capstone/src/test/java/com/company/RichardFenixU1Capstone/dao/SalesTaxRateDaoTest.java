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
public class SalesTaxRateDaoTest {

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
    public void addGetDeleteSalesTaxRate() {
        SalesTaxRate salesTaxRate = new SalesTaxRate();
        salesTaxRate.setState("GA");
        salesTaxRate.setRate(new BigDecimal("0.07"));
        salesTaxRateDao.addSalesTaxRate(salesTaxRate);

        SalesTaxRate salesTaxRate1 = salesTaxRateDao.getSalesTaxRate(salesTaxRate.getState());

        assertEquals(salesTaxRate1, salesTaxRate);

        salesTaxRateDao.deleteSalesTaxRate(salesTaxRate.getState());

        salesTaxRate1 = salesTaxRateDao.getSalesTaxRate(salesTaxRate.getState());

        assertNull(salesTaxRate1);

    }

    @Test
    public void getAllSalesTaxRates() {
        SalesTaxRate salesTaxRate = new SalesTaxRate();
        salesTaxRate.setState("GA");
        salesTaxRate.setRate(new BigDecimal("0.07"));
        salesTaxRateDao.addSalesTaxRate(salesTaxRate);

        salesTaxRate = new SalesTaxRate();
        salesTaxRate.setState("AZ");
        salesTaxRate.setRate(new BigDecimal("0.04"));
        salesTaxRateDao.addSalesTaxRate(salesTaxRate);

        List<SalesTaxRate> lList = salesTaxRateDao.getAllSalesTaxRates();

        assertEquals(2, lList.size());

    }

    @Test
    public void updateSalesTaxRate() {
        SalesTaxRate salesTaxRate = new SalesTaxRate();
        salesTaxRate.setState("GA");
        salesTaxRate.setRate(new BigDecimal("0.07"));
        salesTaxRateDao.addSalesTaxRate(salesTaxRate);

        salesTaxRate.setRate(new BigDecimal("0.03"));
        salesTaxRateDao.updateSalesTaxRate(salesTaxRate);

        SalesTaxRate salesTaxRate1 = salesTaxRateDao.getSalesTaxRate(salesTaxRate.getState());

        assertEquals(new BigDecimal("0.03"), salesTaxRate1.getRate());
    }

}