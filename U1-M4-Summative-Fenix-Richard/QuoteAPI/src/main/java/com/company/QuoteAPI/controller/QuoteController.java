package com.company.QuoteAPI.controller;

import com.company.QuoteAPI.model.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class QuoteController {
    List<Quote> quoteList = new ArrayList<>();

    // Create initialization block to initialize variables. The function below is run only once.
    {
        seedQuoteList();
    }

    @GetMapping(path="/quote")
    @ResponseStatus(value=HttpStatus.OK)
    public Quote getQuote(){
        //Quote quoteOfTheDay = new Quote();
        Random random = new Random();

        // get the number of objects in quoteList;
        int listSize = quoteList.size();
        System.out.println("listSize: " + listSize);

        if (listSize == -1){
            throw new NullPointerException("There is no quotes available.");
        }

        // get the random index based on the size of the list.
        int i = random.nextInt(listSize);
        System.out.println("Index of quote " + i + " out of total quotes of " + listSize);
        return quoteList.get(i);
    }

    // Method to seed list of quotes.
    public void seedQuoteList(){

        Quote walt = new Quote();
        Quote einstein = new Quote();
        Quote jobs = new Quote();
        Quote aristotle = new Quote();
        Quote mandela = new Quote();

        Quote bonaparte = new Quote();
        Quote emerson = new Quote();
        Quote brunner = new Quote();
        Quote musk = new Quote();
        Quote grove = new Quote();

        walt.setAuthor("Walt Disney");
        walt.setQuote("All our dreams can come true, if we have the courage to pursue them.");
        einstein.setAuthor("Albert Einstein");
        einstein.setQuote("Imagination is more important than knowledge.");
        jobs.setAuthor("Steve Jobs");
        jobs.setQuote("The most precious resource we all have is time.");
        aristotle.setAuthor("Aristotle");
        aristotle.setQuote("We are what we repeatedly do. Excellence, then, is not an act, but a habit.");
        mandela.setAuthor("Nelson Mandela");
        mandela.setQuote("I learned that courage is not the absence of fear, but the triumph over it.");

        bonaparte.setAuthor("Napoleon Bonaparte");
        bonaparte.setQuote("Victory is not always winning the battle... but rising every time you fall.");
        emerson.setAuthor("Ralph Waldo Emerson");
        emerson.setQuote("Every artist was first an amateur.");
        brunner.setAuthor("John Brunner");
        brunner.setQuote("It’s supposed to be automatic, but actually you have to push this button.");
        musk.setAuthor("Elon Musk");
        musk.setQuote("When something is important enough, you do it even if the odds are not in your favor.");
        grove.setAuthor("Andy Grove");
        grove.setQuote("Only the paranoid survive.");

        quoteList.add(walt);
        quoteList.add(einstein);
        quoteList.add(jobs);
        quoteList.add(aristotle);
        quoteList.add(mandela);

        quoteList.add(bonaparte);
        quoteList.add(emerson);
        quoteList.add(brunner);
        quoteList.add(musk);
        quoteList.add(grove);

    }

    // Extra controller for creating quotes
    @RequestMapping(value="/quote", method= RequestMethod.POST)
    @ResponseStatus(value= HttpStatus.CREATED)
    public Quote createQuote(@RequestBody @Valid Quote quote){

        // Test for duplicate quote and author
        boolean duplicateKey = false;
        for (Quote element: quoteList){
            if (element.getAuthor().equals(quote.getAuthor()) && element.getQuote().equals(quote.getQuote())){
                duplicateKey = true;
            }
        }

        // if duplicate key is found, throw error;
        if (duplicateKey) {
            throw new IllegalArgumentException("The author and quote you are adding already exists");
        }
        quoteList.add(quote);
        System.out.println(quoteList);
        return quote;
    }

}
