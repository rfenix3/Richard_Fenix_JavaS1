package com.company.RichardFenixU1Capstone.controller;

import com.company.RichardFenixU1Capstone.dto.Invoice;
import com.company.RichardFenixU1Capstone.exceptions.GameStoreNotFoundException;
import com.company.RichardFenixU1Capstone.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController

@RequestMapping("invoice") // http://localhost:8080/invoice
public class InvoiceWebServiceController {
    private final ServiceLayer serviceLayer;

    @Autowired
    public InvoiceWebServiceController(ServiceLayer serviceLayer) {
        this.serviceLayer = serviceLayer;
    }

    //private final InvoiceDao invoiceDao;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Invoice addInvoiceToDB(@RequestBody @Valid Invoice invoice) {
        return serviceLayer.saveInvoice(invoice);
    }


    @DeleteMapping(path="/{invoice_id}")
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void  deleteInvoiceFromDB(@PathVariable int invoice_id) {
        serviceLayer.removeInvoice(invoice_id);
    }

    @GetMapping
    @ResponseStatus(value=HttpStatus.OK)
    public List<Invoice> getInvoiceListfromDB() {
        return serviceLayer.findAllInvoices();
    }

    @GetMapping(path="/{invoice_id}")
    @ResponseStatus(value=HttpStatus.OK)
    public Invoice getInvoiceFromDB(@PathVariable int invoice_id) throws Exception {
        Invoice invoice = serviceLayer.findInvoice(invoice_id);
        if (invoice == null) {
            throw new GameStoreNotFoundException("Invoice not found.");
        }
        return invoice;
    }

    @PutMapping
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void updateInvoiceInDB(@RequestBody @Valid Invoice invoice){
        serviceLayer.updateInvoice(invoice);
    }

}
