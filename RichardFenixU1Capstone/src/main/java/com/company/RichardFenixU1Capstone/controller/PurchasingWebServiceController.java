package com.company.RichardFenixU1Capstone.controller;

import com.company.RichardFenixU1Capstone.exceptions.GameStoreNotFoundException;
import com.company.RichardFenixU1Capstone.service.ServiceLayer;
import com.company.RichardFenixU1Capstone.viewModel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("purchasing") // http://localhost:8080/purchasing
public class PurchasingWebServiceController {
    private final ServiceLayer serviceLayer;

    @Autowired
    public PurchasingWebServiceController(ServiceLayer serviceLayer) {
        this.serviceLayer = serviceLayer;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InvoiceViewModel addInvoiceViewModelfromDB(@RequestBody @Valid InvoiceViewModel invoiceViewModel) {
        return serviceLayer.saveInvoiceViewModel(invoiceViewModel);
    }

    @DeleteMapping(path="/{invoice_id}")
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void  deleteInvoiceViewModelFromDB(@PathVariable int invoice_id) {
        serviceLayer.removeInvoiceViewModel(invoice_id);
    }

    @GetMapping
    @ResponseStatus(value=HttpStatus.OK)
    public List<InvoiceViewModel> getInvoiceViewModelListfromDB() {
        return serviceLayer.findAllInvoiceVIewModels();
    }

    @GetMapping(path="/{invoice_id}")
    @ResponseStatus(value=HttpStatus.OK)
    public InvoiceViewModel getInvoiceViewModelFromDB(@PathVariable int invoice_id) throws Exception {
        InvoiceViewModel invoiceViewModel = serviceLayer.findInvoiceViewModel(invoice_id);
        if (invoiceViewModel == null) {
            throw new GameStoreNotFoundException("Invoice not found.");
        }
        return invoiceViewModel;
    }

    @PutMapping
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void updateInvoiceViewModelInDB(@RequestBody @Valid InvoiceViewModel invoiceViewModel){
        serviceLayer.updateInvoiceViewModel(invoiceViewModel);
    }

}
