package com.company.QuoteAPI.controller;

import com.company.QuoteAPI.dao.QuoteDaoImplementation;
import com.company.QuoteAPI.model.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class QuoteController {

    // We instantiate QuoteDaoImplementation to get the quote list and get() method into this controller
    private static QuoteDaoImplementation quoteDaoImplementation = new QuoteDaoImplementation();

    @GetMapping(path="/quote")
    @ResponseStatus(value=HttpStatus.OK)
    public Quote getQuote(){
        Random random = new Random();

        // get the random index based on the size of the list. Since size is 10, we set bound to 10.
        int i = random.nextInt(10);
        System.out.println("Index of quote " + i);
        return quoteDaoImplementation.get(i);
    }

}
