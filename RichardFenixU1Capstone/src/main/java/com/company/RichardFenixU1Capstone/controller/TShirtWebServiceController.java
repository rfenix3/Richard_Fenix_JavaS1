package com.company.RichardFenixU1Capstone.controller;

import com.company.RichardFenixU1Capstone.dto.TShirt;
import com.company.RichardFenixU1Capstone.exceptions.GameStoreNotFoundException;
import com.company.RichardFenixU1Capstone.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("tshirt") // http://localhost:8080/tshirt
public class TShirtWebServiceController {
    private final ServiceLayer serviceLayer;

    @Autowired
    public TShirtWebServiceController(ServiceLayer serviceLayer) {
        this.serviceLayer = serviceLayer;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TShirt addTShirtToDB(@RequestBody @Valid TShirt tShirt) {
        return serviceLayer.saveTShirt(tShirt);
    }

    @DeleteMapping(path="/{tShirt_id}")
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void  deleteTShirtFromDB(@PathVariable int tShirt_id) {
        serviceLayer.removeTShirt(tShirt_id);
    }

    @GetMapping
    @ResponseStatus(value=HttpStatus.OK)
    public List<TShirt> getTShirtListfromDB() {
        return serviceLayer.findAllTShirts();
    }

    @GetMapping(path="/{tShirt_id}")
    @ResponseStatus(value=HttpStatus.OK)
    public TShirt getTShirtFromDB(@PathVariable int tShirt_id) throws Exception {
        TShirt tShirt = serviceLayer.findTShirt(tShirt_id);
        if (tShirt == null) {
            throw new GameStoreNotFoundException("Sales Tax Rate not found.");
        }
        return tShirt;

    }

    @PutMapping
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void updateTShirtInDB(@RequestBody @Valid TShirt tShirt){
        serviceLayer.updateTShirt(tShirt);
    }

}
