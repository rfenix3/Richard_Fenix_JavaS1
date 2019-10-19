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

//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNull;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceDaoTest {
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
    public void addGetDeleteInvoice() {
        Invoice invoice = new Invoice();
        invoice.setName("Richard");
        invoice.setStreet("123 Johnson Ferry Rd");
        invoice.setCity("Marietta");
        invoice.setState("GA");
        invoice.setZipcode("30067");
        invoice.setItemType("Consoles");
        invoice.setItemId(101);
        invoice.setUnitPrice(new BigDecimal("249.99"));
        invoice.setQuantity(2);
        invoice.setSubtotal(new BigDecimal("499.98"));
        //invoice.setTax(new BigDecimal("34.9986"));
        invoice.setTax(new BigDecimal("34.99"));
        invoice.setProcessingFee(new BigDecimal("14.99"));
        //invoice.setTotal(new BigDecimal("549.9686"));
        invoice.setTotal(new BigDecimal("549.96"));

        invoice = invoiceDao.addInvoice(invoice);

        Invoice invoice1 = invoiceDao.getInvoice(invoice.getInvoiceId());

        assertEquals(invoice1, invoice);

        invoiceDao.deleteInvoice(invoice.getInvoiceId());

        invoice1 = invoiceDao.getInvoice(invoice.getInvoiceId());

        assertNull(invoice1);
    }

    @Test
    public void getAllInvoices() {
        Invoice invoice = new Invoice();
        invoice.setName("Richard");
        invoice.setStreet("123 Johnson Ferry Rd");
        invoice.setCity("Marietta");
        invoice.setState("GA");
        invoice.setZipcode("30067");
        invoice.setItemType("Consoles");
        invoice.setItemId(101);
        invoice.setUnitPrice(new BigDecimal("249.99"));
        invoice.setQuantity(2);
        invoice.setSubtotal(new BigDecimal("499.98"));
        //invoice.setTax(new BigDecimal("34.9986"));
        invoice.setTax(new BigDecimal("34.99"));
        invoice.setProcessingFee(new BigDecimal("14.99"));
        //invoice.setTotal(new BigDecimal("549.9686"));
        invoice.setTotal(new BigDecimal("549.96"));
        invoiceDao.addInvoice(invoice);

        invoice = new Invoice();
        invoice.setName("Richard");
        invoice.setStreet("123 Johnson Ferry Rd");
        invoice.setCity("Marietta");
        invoice.setState("GA");
        invoice.setZipcode("30067");
        invoice.setItemType("T-Shirts");
        invoice.setItemId(303);
        invoice.setUnitPrice(new BigDecimal("29.99"));
        invoice.setQuantity(3);
        invoice.setSubtotal(new BigDecimal("89.97"));
        //invoice.setTax(new BigDecimal("6.2979"));
        invoice.setTax(new BigDecimal("6.29"));
        invoice.setProcessingFee(new BigDecimal("1.98"));
        //invoice.setTotal(new BigDecimal("98.2479"));
        invoice.setTotal(new BigDecimal("98.24"));
        invoiceDao.addInvoice(invoice);

        List<Invoice> lList = invoiceDao.getAllInvoices();

        assertEquals(2, lList.size());
    }


    @Test
    public void updateInvoice() {
        Invoice invoice = new Invoice();
        invoice.setName("Richard");
        invoice.setStreet("123 Johnson Ferry Rd");
        invoice.setCity("Marietta");
        invoice.setState("GA");
        invoice.setZipcode("30067");
        invoice.setItemType("Consoles");
        invoice.setItemId(101);
        invoice.setUnitPrice(new BigDecimal("249.99"));
        invoice.setQuantity(2);
        invoice.setSubtotal(new BigDecimal("499.98"));
        //invoice.setTax(new BigDecimal("34.9986"));
        invoice.setTax(new BigDecimal("34.99"));
        invoice.setProcessingFee(new BigDecimal("14.99"));
        //invoice.setTotal(new BigDecimal("549.9686"));
        invoice.setTotal(new BigDecimal("549.96"));

        invoiceDao.addInvoice(invoice);

        invoice.setUnitPrice(new BigDecimal("249.99"));
        invoice.setQuantity(3);
        invoiceDao.updateInvoice(invoice);

        Invoice invoice1 = invoiceDao.getInvoice(invoice.getInvoiceId());

        assertEquals(3, invoice1.getQuantity());
        assertEquals(new BigDecimal("249.99"), invoice1.getUnitPrice());
    }

}