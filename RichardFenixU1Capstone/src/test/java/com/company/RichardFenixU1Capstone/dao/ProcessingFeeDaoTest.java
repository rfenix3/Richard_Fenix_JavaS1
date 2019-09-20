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
public class ProcessingFeeDaoTest {

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
    public void addGetDeleteProcessingFee() {
        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setProductType("CONSOLES");
        processingFee.setFee(new BigDecimal("14.99"));
        processingFeeDao.addProcessingFee(processingFee);

        ProcessingFee processingFee1 = processingFeeDao.getProcessingFee(processingFee.getProductType());

        assertEquals(processingFee1, processingFee);

        processingFeeDao.deleteProcessingFee(processingFee.getProductType());

        processingFee1 = processingFeeDao.getProcessingFee(processingFee.getProductType());

        assertNull(processingFee1);
    }

    @Test
    public void getAllProcessingFees() {
        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setProductType("CONSOLES");
        processingFee.setFee(new BigDecimal("14.99"));
        processingFeeDao.addProcessingFee(processingFee);

        processingFee = new ProcessingFee();
        processingFee.setProductType("T-SHIRTS");
        processingFee.setFee(new BigDecimal("1.98"));
        processingFeeDao.addProcessingFee(processingFee);

        List<ProcessingFee> lList = processingFeeDao.getAllProcessingFees();

        assertEquals(2, lList.size());
    }

    @Test
    public void updateProcessingFee() {
        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setProductType("CONSOLES");
        processingFee.setFee(new BigDecimal("14.99"));
        processingFeeDao.addProcessingFee(processingFee);

        processingFee.setFee(new BigDecimal("7.49"));
        processingFeeDao.updateProcessingFee(processingFee);

        ProcessingFee processingFee1 = processingFeeDao.getProcessingFee(processingFee.getProductType());

        assertEquals(new BigDecimal("7.49"), processingFee1.getFee());
    }
}
