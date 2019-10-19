package com.company.RichardFenixU1Capstone.service;

import com.company.RichardFenixU1Capstone.dao.*;
import com.company.RichardFenixU1Capstone.dto.*;
import com.company.RichardFenixU1Capstone.viewModel.InvoiceViewModel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ServiceLayerTest {

    //@Mock is for unit testing. This makes mock assignments not needed.
    // i.e. invoiceDao = mock(InvoiceDaoJdbcTemplateImpl.class);

    //@Mockbean is for integration testing. This is used for controller testing.

    @InjectMocks
    ServiceLayer service;
    @Mock
    ConsoleDao consoleDao;
    @Mock
    GameDao gameDao;
    @Mock
    InvoiceDao invoiceDao;
    @Mock
    ProcessingFeeDao processingFeeDao;
    @Mock
    SalesTaxRateDao salesTaxRateDao;
    @Mock
    TShirtDao tShirtDao;

    @Before
    public void setUp() throws Exception {
        setUpConsoleDaoMock();
        setUpGameDaoMock();
        setUpInvoiceDaoMock();
        setUpProcessingFeeDaoMock();
        setUpSalesTaxRateDaoMock();
        setUpTShirtDaoMock();

        //This is filled-in with @InjectMocks
        //service = new ServiceLayer(consoleDao, gameDao, invoiceDao, processingFeeDao, salesTaxRateDao, tShirtDao);
    }

    @Test
    public void saveFindFindAllInvoiceViewModel() throws Exception{
        InvoiceViewModel ivm = new InvoiceViewModel();
        ivm.setName("Richard");
        ivm.setStreet("123 Johnson Ferry Rd");
        ivm.setCity("Marietta");
        ivm.setState("GA");
        ivm.setZipcode("30067");
        ivm.setItemType("Consoles");
        ivm.setItemId(101);
        ivm.setQuantity(2);

        ivm = service.saveInvoiceViewModel(ivm);

        InvoiceViewModel fromService = service.findInvoiceViewModel(ivm.getInvoiceId());

        assertEquals(ivm, fromService);

    }

    @Test
    public void updateInvoiceViewModel() {
        // In ServiceLayer,  check method's parameters: updateInvoice(invoiceViewModel viewModel);
        // We will see the call to invoiceDao.updateInvoice(invoice);

        //Instantiate an InvoiceViewModel;
        InvoiceViewModel ivm = new InvoiceViewModel();

        // Since we are not actually working with a db, we do not need to
        // insert a new row.
        ivm.setInvoiceId(1);  // <-- artificial Invoice ID number;

        // plus other invoice properties...;
        ivm.setName("Richard");
        ivm.setStreet("123 Johnson Ferry Rd");
        ivm.setCity("Marietta");
        ivm.setState("GA");
        ivm.setZipcode("30067");
        ivm.setItemType("Consoles");
        ivm.setItemId(101);
        ivm.setQuantity(2);

        ArgumentCaptor<Invoice>  invoiceCaptor = ArgumentCaptor.forClass((Invoice.class));
        doNothing().when(invoiceDao).updateInvoice(invoiceCaptor.capture());

        // Act phase. execution.
        service.updateInvoiceViewModel(ivm);

        // A phase. must be invoked one time only.
        verify(invoiceDao, times(1)).updateInvoice(invoiceCaptor.getValue());

        Invoice invoice = invoiceCaptor.getValue();

        assertEquals(1, invoice.getInvoiceId());
        assertEquals(ivm.getName(), invoice.getName());
        assertEquals(ivm.getItemType(), invoice.getItemType());

    }

    @Test
    public void removeInvoiceViewModel() {
        // When we remove a invoice, we capture an Integer value.
        ArgumentCaptor<Integer> integerCaptor = ArgumentCaptor.forClass(Integer.class);
        doNothing().when(invoiceDao).deleteInvoice(integerCaptor.capture());

        // Act
        service.removeInvoiceViewModel(10);

        verify(invoiceDao, atLeastOnce()).deleteInvoice(integerCaptor.getValue());

        Assert.assertEquals(10, integerCaptor.getValue().intValue());
    }

    @Test
    public void saveFindFindAllInvoice() {
        Invoice invoice = new Invoice();
        invoice.setName("Richard");
        invoice.setStreet("123 Johnson Ferry Rd");
        invoice.setCity("Marietta");
        invoice.setState("GA");
        invoice.setZipcode("30067");
        invoice.setItemType("Consoles");
        invoice.setItemId(101);
        invoice.setQuantity(2);
        invoice.setUnitPrice(new BigDecimal("249.99"));
        invoice.setSubtotal(new BigDecimal("499.98"));
        invoice.setTax(new BigDecimal("34.99"));
        invoice.setProcessingFee(new BigDecimal("14.99"));
        invoice.setTotal(new BigDecimal("549.96"));

        invoice = service.saveInvoice(invoice);

        Invoice fromService = service.findInvoice(invoice.getInvoiceId());

        assertEquals(invoice, fromService);
    }

    @Test
    public void updateInvoice() {
        //Instantiate an Invoice;
        Invoice invoice = new Invoice();

        // Since we are not actually working with a db, we do not need to
        // insert a new row.
        invoice.setInvoiceId(1);  // <-- artificial Invoice ID number;

        // plus other invoice properties...;
        invoice.setName("Richard");
        invoice.setStreet("123 Johnson Ferry Rd");
        invoice.setCity("Marietta");
        invoice.setState("GA");
        invoice.setZipcode("30067");
        invoice.setItemType("Consoles");
        invoice.setItemId(101);
        invoice.setQuantity(2);

        ArgumentCaptor<Invoice>  invoiceCaptor = ArgumentCaptor.forClass((Invoice.class));
        doNothing().when(invoiceDao).updateInvoice(invoiceCaptor.capture());

        // Act phase. execution.
        service.updateInvoice(invoice);

        // A phase. must be invoked one time only.
        verify(invoiceDao, times(1)).updateInvoice(invoiceCaptor.getValue());

        invoice = invoiceCaptor.getValue();

        assertEquals(1, invoice.getInvoiceId());
        assertEquals(invoice.getName(), invoice.getName());
        assertEquals(invoice.getItemType(), invoice.getItemType());
    }

    @Test
    public void removeInvoice() {
        // When we remove a invoice, we capture an Integer value.
        ArgumentCaptor<Integer> integerCaptor = ArgumentCaptor.forClass(Integer.class);
        doNothing().when(invoiceDao).deleteInvoice(integerCaptor.capture());

        // Act
        service.removeInvoice(10);

        verify(invoiceDao, atLeastOnce()).deleteInvoice(integerCaptor.getValue());

        Assert.assertEquals(10, integerCaptor.getValue().intValue());
    }

    // Helper Methods
    private void setUpInvoiceDaoMock() {
        //invoiceDao = mock(InvoiceDaoJdbcTemplateImpl.class);
        Invoice invoice = new Invoice();
        invoice.setInvoiceId(1);
        invoice.setName("Richard");
        invoice.setStreet("123 Johnson Ferry Rd");
        invoice.setCity("Marietta");
        invoice.setState("GA");
        invoice.setZipcode("30067");
        invoice.setItemType("Consoles");
        invoice.setItemId(101);
        invoice.setQuantity(2);

        // Below is mock computed or retrieved output data when addInvoice(invoice2) is ran.
        invoice.setUnitPrice(new BigDecimal("249.99"));
        invoice.setSubtotal(new BigDecimal("499.98"));
        invoice.setTax(new BigDecimal("34.99"));
        invoice.setProcessingFee(new BigDecimal("14.99"));
        invoice.setTotal(new BigDecimal("549.96"));

        /*
        invoice2 is the expected result when
        invoiceDao.addInvoice(invoice) is called.
         */

        Invoice invoice2 = new Invoice();
        invoice2.setName("Richard");
        invoice2.setStreet("123 Johnson Ferry Rd");
        invoice2.setCity("Marietta");
        invoice2.setState("GA");
        invoice2.setZipcode("30067");
        invoice2.setItemType("Consoles");
        invoice2.setItemId(101);
        invoice2.setQuantity(2);

        invoice2.setUnitPrice(new BigDecimal("249.99"));
        invoice2.setSubtotal(new BigDecimal("499.98"));
        invoice2.setTax(new BigDecimal("34.99"));
        invoice2.setProcessingFee(new BigDecimal("14.99"));
        invoice2.setTotal(new BigDecimal("549.96"));

        List<Invoice> aList = new ArrayList();
        aList.add(invoice);

        doReturn(invoice).when(invoiceDao).addInvoice(invoice2);
        doReturn(invoice).when(invoiceDao).getInvoice(1);
        doReturn(aList).when(invoiceDao).getAllInvoices();
    }

    public void setUpConsoleDaoMock(){
        //consoleDao = mock(ConsoleDaoJdbcTemplateImpl.class);
        /* Test value we are passing from invoice is a console with
        consoleId of 101 and unitPrice of "249.99".
        invoice.setItemId(101);
        invoice.setUnitPrice(new BigDecimal("249.99"));
         */
        Console console = new Console();
        console.setConsoleId(101);
        console.setModel("PS4 Pro");
        console.setManufacturer("Sony");
        console.setMemoryAmount("1 TB");
        console.setProcessor("AMD Jaguar 8-core");
        console.setPrice(new BigDecimal("249.99"));
        console.setQuantity(30);

        Console console2 = new Console();
        console2.setModel("PS4 Pro");
        console2.setManufacturer("Sony");
        console2.setMemoryAmount("1 TB");
        console2.setProcessor("AMD Jaguar 8-core");
        console2.setPrice(new BigDecimal("249.99"));
        console2.setQuantity(30);

        List<Console> aList = new ArrayList();
        aList.add(console);

        doReturn(console).when(consoleDao).addConsole(console2);
        doReturn(console).when(consoleDao).getConsole(101);
        doReturn(aList).when(consoleDao).getAllConsoles();
    }

    public void setUpGameDaoMock(){
        //gameDao = mock(GameDaoJdbcTemplateImpl.class);
        Game game = new Game();
        game.setGameId(1);
        game.setTitle("NBA 2k20");
        game.setEsrbRating("Everyone");
        game.setDescription("NBA Video Game");
        game.setPrice(new BigDecimal("59.99"));
        game.setStudio("EASports");
        game.setQuantity(80);

        Game game2 = new Game();
        game2.setTitle("NBA 2k20");
        game2.setEsrbRating("Everyone");
        game2.setDescription("NBA Video Game");
        game2.setPrice(new BigDecimal("59.99"));
        game2.setStudio("EASports");
        game2.setQuantity(80);

        List<Game> aList = new ArrayList();
        aList.add(game);

        doReturn(game).when(gameDao).addGame(game2);
        doReturn(game).when(gameDao).getGame(1);
        doReturn(aList).when(gameDao).getAllGames();
    }

    public void setUpTShirtDaoMock(){
        //tShirtDao = mock(TShirtDaoJdbcTemplateImpl.class);
        TShirt tShirt = new TShirt();
        tShirt.settShirtId(1);
        tShirt.setSize("Small");
        tShirt.setColor("Red");
        tShirt.setDescription("Small red T-shirt.");
        tShirt.setPrice(new BigDecimal("29.99"));
        tShirt.setQuantity(24);

        TShirt tShirt2 = new TShirt();
        tShirt2.setSize("Small");
        tShirt2.setColor("Red");
        tShirt2.setDescription("Small red T-shirt.");
        tShirt2.setPrice(new BigDecimal("29.99"));
        tShirt2.setQuantity(24);

        List<TShirt> aList = new ArrayList();
        aList.add(tShirt);

        doReturn(tShirt).when(tShirtDao).addTShirt(tShirt2);
        doReturn(tShirt).when(tShirtDao).getTShirt(1);
        doReturn(aList).when(tShirtDao).getAllTShirts();
    }


    private void setUpProcessingFeeDaoMock() {
        //processingFeeDao = mock(ProcessingFeeDaoJdbcTemplateImpl.class);
        /* Test value we are passing from invoice is a console.
        invoice.setItemType("Consoles");
        We will also provide a mock data of 14.99 processing fee.
        invoice.setProcessingFee(new BigDecimal("14.99"))
         */
        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setProductType("Consoles");
        processingFee.setFee(new BigDecimal("14.99"));

        ProcessingFee processingFee2 = new ProcessingFee();
        processingFee2.setProductType("Consoles");
        processingFee2.setFee(new BigDecimal("14.99"));

        List<ProcessingFee> aList = new ArrayList();
        aList.add(processingFee);

        doReturn(processingFee).when(processingFeeDao).addProcessingFee(processingFee2);
        doReturn(processingFee).when(processingFeeDao).getProcessingFee("Consoles");
        doReturn(aList).when(processingFeeDao).getAllProcessingFees();
    }

    private void setUpSalesTaxRateDaoMock() {
        //salesTaxRateDao = mock(SalesTaxRateDaoJdbcTemplateImpl.class);
        /* Test value we are passing from invoice is the processing fee from GA,
        invoice.setState("GA");
        where we will provide a mock data of 0.07 Sales tax rate.
         */
        SalesTaxRate salesTaxRate = new SalesTaxRate();
        salesTaxRate.setState("GA");
        salesTaxRate.setRate(new BigDecimal("0.07"));

        SalesTaxRate salesTaxRate2 = new SalesTaxRate();
        salesTaxRate2.setState("GA");
        salesTaxRate2.setRate(new BigDecimal("0.07"));

        List<SalesTaxRate> aList = new ArrayList();
        aList.add(salesTaxRate);

        doReturn(salesTaxRate).when(salesTaxRateDao).addSalesTaxRate(salesTaxRate2);
        doReturn(salesTaxRate).when(salesTaxRateDao).getSalesTaxRate("GA");
        doReturn(aList).when(salesTaxRateDao).getAllSalesTaxRates();
    }

}