package com.company.RichardFenixU1Capstone.controller;

import com.company.RichardFenixU1Capstone.dto.ProcessingFee;
import com.company.RichardFenixU1Capstone.exceptions.GameStoreNotFoundException;
import com.company.RichardFenixU1Capstone.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("processingfee") // http://localhost:8080/processingfee
public class ProcessingFeeWebServiceController {
    private final ServiceLayer serviceLayer;

    @Autowired
    public ProcessingFeeWebServiceController(ServiceLayer serviceLayer) {
        this.serviceLayer = serviceLayer;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProcessingFee addProcessingFeeToDB(@RequestBody @Valid ProcessingFee processingFee) {
        return serviceLayer.saveProcessingFee(processingFee);
    }

    @DeleteMapping(path="/{productType}")
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void  deleteProcessingFeeFromDB(@PathVariable String productType) {
        serviceLayer.removeProcessingFee(productType);
    }

    @GetMapping
    @ResponseStatus(value=HttpStatus.OK)
    public List<ProcessingFee> getProcessingFeeListfromDB() {
        return serviceLayer.findAllProcessingFees();
    }

    @GetMapping(path="/{productType}")
    @ResponseStatus(value=HttpStatus.OK)
    public ProcessingFee getProcessingFeeFromDB(@PathVariable String productType) throws Exception {
        ProcessingFee processingFee = serviceLayer.findProcessingFee(productType);
        if (processingFee == null) {
            throw new GameStoreNotFoundException("Processing Fee not found.");
        }
        return processingFee;
    }

    @PutMapping
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void updateProcessingFeeInDB(@RequestBody @Valid ProcessingFee processingFee){
        serviceLayer.updateProcessingFee(processingFee);
    }

}
