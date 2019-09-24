package com.company.RichardFenixU1Capstone.service;

import com.company.RichardFenixU1Capstone.dao.*;
import com.company.RichardFenixU1Capstone.dto.*;
import com.company.RichardFenixU1Capstone.viewModel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
    /*
    The itemIds will be the consoleId, gameId, and tShirtId;
    User will supply these values;
    - Name
    - Street
    - City
    - State
    - Zip
    - Item Type
    - Item ID
    - Quantity

    The following will be extracted from DB:
    - unit_price
    - tax
    - processing fee

    The following will be computed:
    - subtotal
    - processing_fee (add 15.49 if more than 10 items)
    - total

    */

@Component
public class ServiceLayer {

    private ConsoleDao consoleDao;
    private GameDao gameDao;
    private InvoiceDao invoiceDao;
    private ProcessingFeeDao processingFeeDao;
    private SalesTaxRateDao salesTaxRateDao;
    private TShirtDao tShirtDao;

    @Autowired
    public ServiceLayer(ConsoleDao consoleDao, GameDao gameDao, InvoiceDao invoiceDao, ProcessingFeeDao processingFeeDao, SalesTaxRateDao salesTaxRateDao, TShirtDao tShirtDao) {
        this.consoleDao = consoleDao;
        this.gameDao = gameDao;
        this.invoiceDao = invoiceDao;
        this.processingFeeDao = processingFeeDao;
        this.salesTaxRateDao = salesTaxRateDao;
        this.tShirtDao = tShirtDao;
    }

    @Transactional
    public InvoiceViewModel saveInvoiceViewModel(InvoiceViewModel viewModel) throws Exception{

        // Validate order quantity.
        if (viewModel.getQuantity() <= 0) {
            throw new Exception("Order quantity must greater than 0.");
        }

        // Validate state.
        if (salesTaxRateDao.getSalesTaxRate(viewModel.getState()) == null) {
            throw new Exception("Invalid state.");
        }

        // Persist Invoice
        Invoice i = new Invoice();
        i.setName(viewModel.getName());
        i.setStreet(viewModel.getStreet());
        i.setCity(viewModel.getCity());
        i.setState(viewModel.getState());
        i.setZipcode(viewModel.getZipcode());
        i.setItemType(viewModel.getItemType());
        i.setItemId(viewModel.getItemId());
        i.setQuantity(viewModel.getQuantity());

        int ivmQty = viewModel.getQuantity();

        // get unit_price from database
        switch(viewModel.getItemType()) {
            case "Consoles":
                Console c = new Console();
                c = consoleDao.getConsole(viewModel.getItemId());
                int consoleQty = c.getQuantity();
                if (consoleQty < ivmQty){
                    throw new Exception("Console quantity is not enough.");
                }
                // Reduce console inventory by view model qty.
                c.setQuantity(consoleQty - ivmQty);

                // Update console w new quantity
                consoleDao.updateConsole(c);

                // Set invoice unit price.
                i.setUnitPrice(c.getPrice());
                break;
            case "T-Shirts":
                TShirt t = new TShirt();
                t = tShirtDao.getTShirt(viewModel.getItemId());
                int tShirtQty = t.getQuantity();
                if (tShirtQty < ivmQty){
                    throw new Exception("T-Shirt quantity is not enough.");
                }
                // Reduce t-shirt inventory by view model qty.
                t.setQuantity(tShirtQty - ivmQty);

                // Update t-shirt w new quantity
                tShirtDao.updateTShirt(t);

                // Set invoice unit price.
                i.setUnitPrice(t.getPrice());

                break;
            case "Games":
                Game g = new Game();
                g = gameDao.getGame(viewModel.getItemId());
                int gameQty = g.getQuantity();

                if (gameQty < ivmQty){
                    throw new Exception("Game quantity is not enough.");
                }
                // Reduce t-shirt inventory by view model qty.
                g.setQuantity(gameQty - ivmQty);

                // Update game w new quantity
                gameDao.updateGame(g);

                // Set invoice unit price.
                i.setUnitPrice(g.getPrice());
                break;
            default:
                System.out.println("Invalid item type entered. Closing java program");
                System.exit(1); //non zero value to exit says abnormal termination of JVM
        }

        // Compute for subtotal
        int qty = viewModel.getQuantity();
        BigDecimal unitP = i.getUnitPrice();

        BigDecimal subT = unitP.multiply(new BigDecimal(qty));

        // Set subtotal value
        i.setSubtotal(subT);

        // Get tax rate from database
        BigDecimal rate = salesTaxRateDao.getSalesTaxRate(viewModel.getState()).getRate();

        // Compute for the total tax and set invoice tax to it
        BigDecimal taxAmount = subT.multiply(rate);
        i.setTax(taxAmount.setScale(2, RoundingMode.DOWN));

        // Get processing_fee from db
        BigDecimal processingFee = processingFeeDao.getProcessingFee(viewModel.getItemType()).getFee();
        if (qty > 10) {
            processingFee = processingFee.add(new BigDecimal("15.49"));
        }
        i.setProcessingFee(processingFee);

        // set total
        BigDecimal total = subT.add(taxAmount).add(processingFee);
        i.setTotal(total.setScale(2, RoundingMode.DOWN));

        // Once we are able to assign all the data, the final step is to add the invoice into the database.
        i = invoiceDao.addInvoice(i);
        viewModel.setInvoiceId(i.getInvoiceId());

        return viewModel;
    }

    public void updateInvoiceViewModel(InvoiceViewModel viewModel) {

        // Update the invoice information
        Invoice i = new Invoice();
        i.setInvoiceId(viewModel.getInvoiceId());
        i.setName(viewModel.getName());
        i.setStreet(viewModel.getStreet());
        i.setCity(viewModel.getCity());
        i.setState(viewModel.getState());
        i.setZipcode(viewModel.getZipcode());

        i.setItemType(viewModel.getItemType());
        i.setItemId(viewModel.getItemId());
        i.setQuantity(viewModel.getQuantity());

        // get unit_price from database
        switch(viewModel.getItemType()) {
            case "Consoles":
                Console c = new Console();
                c = consoleDao.getConsole(viewModel.getItemId());
                i.setUnitPrice(c.getPrice());
                break;
            case "T-Shirts":
                TShirt t = new TShirt();
                t = tShirtDao.getTShirt(viewModel.getItemId());
                i.setUnitPrice(t.getPrice());
                break;
            case "Games":
                Game g = new Game();
                g = gameDao.getGame(viewModel.getItemId());
                i.setUnitPrice(g.getPrice());
                break;
            default:
                System.out.println("Invalid item type entered. Closing java program");
                System.exit(1); //non zero value to exit says abnormal termination of JVM
        }

        // Compute for subtotal
        int qty = viewModel.getQuantity();
        BigDecimal unitP = i.getUnitPrice();

        BigDecimal subT = unitP.multiply(new BigDecimal(qty));

        // Set subtotal value
        i.setSubtotal(subT);

        // Get tax rate from database
        BigDecimal rate = salesTaxRateDao.getSalesTaxRate(viewModel.getState()).getRate();

        // Compute for the total tax and set invoice tax to it
        BigDecimal taxAmount = subT.multiply(rate);
        i.setTax(taxAmount);

        // Get processing_fee from db
        BigDecimal processingFee = processingFeeDao.getProcessingFee(viewModel.getItemType()).getFee();
        if (qty > 10) {
            processingFee = processingFee.add(new BigDecimal("15.49"));
        }
        i.setProcessingFee(processingFee);

        // set total
        BigDecimal total = subT.add(taxAmount).add(processingFee);
        i.setTotal(total);

        invoiceDao.updateInvoice(i);
    }


    public InvoiceViewModel findInvoiceViewModel(int id) {

        Invoice invoice= invoiceDao.getInvoice(id);

        return buildInvoiceViewModel(invoice);
    }


    public List<InvoiceViewModel> findAllInvoiceVIewModels() {
        List<Invoice> invoiceList = invoiceDao.getAllInvoices();

        List<InvoiceViewModel> ivmList = new ArrayList<>();

        for (Invoice invoice : invoiceList) {
            InvoiceViewModel avm = buildInvoiceViewModel(invoice);
            ivmList.add(avm);
        }
        return ivmList;
    }


    public void removeInvoiceViewModel(int id) {

        invoiceDao.deleteInvoice(id);
    }

    // Invoice API
    //
    public Invoice saveInvoice(Invoice invoice) {

        return invoiceDao.addInvoice(invoice);
    }

    public List<Invoice> findAllInvoices() {

        return invoiceDao.getAllInvoices();
    }

    public void removeInvoice(int id) {

        invoiceDao.deleteInvoice(id);
    }

    public Invoice findInvoice(int id) {

        return invoiceDao.getInvoice(id);
    }

    public void updateInvoice(Invoice invoice) {

        invoiceDao.updateInvoice(invoice);
    }


    // Console API
    //

    public Console saveConsole(Console console) {

        return consoleDao.addConsole(console);
    }

    public Console findConsole(int id) {

        return consoleDao.getConsole(id);
    }

    public List<Console> findAllConsoles() {

        return consoleDao.getAllConsoles();
    }

    public void updateConsole(Console console) {

        consoleDao.updateConsole(console);
    }

    public void removeConsole(int id) {

        consoleDao.deleteConsole(id);
    }

    public List<Console> findConsolesByManufacturer(String manufacturer){
        return consoleDao.getConsolesByManufacturer(manufacturer);
    }


    // TShirt API
    //

    public TShirt saveTShirt(TShirt tShirt) {

        return tShirtDao.addTShirt(tShirt);
    }

    public TShirt findTShirt(int id) {

        return tShirtDao.getTShirt(id);
    }

    public List<TShirt> findAllTShirts() {

        return tShirtDao.getAllTShirts();
    }

    public void updateTShirt(TShirt tShirt) {

        tShirtDao.updateTShirt(tShirt);
    }

    public void removeTShirt(int id) {

        tShirtDao.deleteTShirt(id);
    }

    public List<TShirt> findTShirtsByColor(String color){
        return tShirtDao.getTShirtsByColor(color);
    }

    public List<TShirt> findTShirtsBySize(String size){
        return tShirtDao.getTShirtsBySize(size);
    }


    // Game API
    //

    public Game saveGame(Game game) {

        return gameDao.addGame(game);
    }

    public Game findGame(int id) {

        return gameDao.getGame(id);
    }

    public List<Game> findAllGames() {

        return gameDao.getAllGames();
    }

    public void updateGame(Game game) {

        gameDao.updateGame(game);
    }

    public void removeGame(int id) {

        gameDao.deleteGame(id);
    }

    public List<Game> findGamesByStudio(String studio){
        return gameDao.getGamesByStudio(studio);
    }

    public List<Game> findGamesByEsrbRating(String esrbRating){
        return gameDao.getGamesByEsrbRating(esrbRating);
    }

    public Game findGameByTitle(String title) {

        return gameDao.getGameByTitle(title);
    }

    // SalesTaxRate API
    //

    public SalesTaxRate saveSalesTaxRate(SalesTaxRate salesTaxRate) {

        return salesTaxRateDao.addSalesTaxRate(salesTaxRate);
    }

    public SalesTaxRate findSalesTaxRate(String state) {

        return salesTaxRateDao.getSalesTaxRate(state);
    }

    public List<SalesTaxRate> findAllSalesTaxRates() {

        return salesTaxRateDao.getAllSalesTaxRates();
    }

    public void updateSalesTaxRate(SalesTaxRate salesTaxRate) {

        salesTaxRateDao.updateSalesTaxRate(salesTaxRate);
    }

    public void removeSalesTaxRate(String state) {

        salesTaxRateDao.deleteSalesTaxRate(state);
    }

    // ProcessingFee API
    //

    public ProcessingFee saveProcessingFee(ProcessingFee processingFee) {

        return processingFeeDao.addProcessingFee(processingFee);
    }

    public ProcessingFee findProcessingFee(String productType) {

        return processingFeeDao.getProcessingFee(productType);
    }

    public List<ProcessingFee> findAllProcessingFees() {

        return processingFeeDao.getAllProcessingFees();
    }

    public void updateProcessingFee(ProcessingFee processingFee) {

        processingFeeDao.updateProcessingFee(processingFee);
    }

    public void removeProcessingFee(String productType) {

        processingFeeDao.deleteProcessingFee(productType);
    }

    // Helper Methods
    private InvoiceViewModel buildInvoiceViewModel(Invoice invoice) {

        // Assemble the InvoiceViewModel
        InvoiceViewModel ivm = new InvoiceViewModel();

        ivm.setInvoiceId(invoice.getInvoiceId());
        ivm.setName(invoice.getName());
        ivm.setStreet(invoice.getStreet());
        ivm.setCity(invoice.getCity());
        ivm.setState(invoice.getState());
        ivm.setZipcode(invoice.getZipcode());
        ivm.setItemType(invoice.getItemType());
        ivm.setItemId(invoice.getItemId());
        ivm.setQuantity(invoice.getQuantity());

        // Return the InvoiceViewModel
        return ivm;

    }


}

