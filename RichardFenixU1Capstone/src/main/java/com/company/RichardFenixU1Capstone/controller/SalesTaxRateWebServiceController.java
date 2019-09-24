package com.company.RichardFenixU1Capstone.controller;

import com.company.RichardFenixU1Capstone.dto.SalesTaxRate;
import com.company.RichardFenixU1Capstone.exceptions.GameStoreNotFoundException;
import com.company.RichardFenixU1Capstone.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("salestaxrate") // http://localhost:8080/salestaxrate
public class SalesTaxRateWebServiceController {
    private final ServiceLayer serviceLayer;

    @Autowired
    public SalesTaxRateWebServiceController(ServiceLayer serviceLayer) {
        this.serviceLayer = serviceLayer;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SalesTaxRate addSalesTaxRateToDB(@RequestBody @Valid SalesTaxRate salesTaxRate) {
        return serviceLayer.saveSalesTaxRate(salesTaxRate);
    }

    @DeleteMapping(path="/{state}")
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void  deleteSalesTaxRateFromDB(@PathVariable String state) {
        serviceLayer.removeSalesTaxRate(state);
    }

    @GetMapping
    @ResponseStatus(value=HttpStatus.OK)
    public List<SalesTaxRate> getSalesTaxRateListfromDB() {
        return serviceLayer.findAllSalesTaxRates();
    }

    @GetMapping(path="/{state}")
    @ResponseStatus(value=HttpStatus.OK)
    public SalesTaxRate getSalesTaxRateFromDB(@PathVariable String state) throws Exception {
        SalesTaxRate salesTaxRate = serviceLayer.findSalesTaxRate(state);
        if (salesTaxRate == null) {
            throw new GameStoreNotFoundException("Sales Tax Rate not found.");
        }
        return salesTaxRate;
    }

    @PutMapping
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void updateSalesTaxRateInDB(@RequestBody @Valid SalesTaxRate salesTaxRate){
        serviceLayer.updateSalesTaxRate(salesTaxRate);
    }

}
