package com.company.WordAPI.controller;

import com.company.WordAPI.model.Definition;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class WordController {
    List<Definition> definitionList = new ArrayList<>();

    // Create initialization block to initialize variables. The function below is run only once.
    {
        seedDefinitionList();
    }

    @GetMapping(path="/word")
    @ResponseStatus(value=HttpStatus.OK)
    public Definition getDefinition(){
        Random random = new Random();

        // get the number of objects in definitionList;
        int listSize = definitionList.size();
        System.out.println("listSize: " + listSize);

        if (listSize == -1){
            throw new NullPointerException("There is no Words available.");
        }

        // get the random index based on the size of the list.
        int i = random.nextInt(listSize);
        System.out.println("Index of Word " + i + " out of total Words of " + listSize);
        return definitionList.get(i);
    }

    // Method to seed list of Words.
    public void seedDefinitionList(){

        Definition vicinal = new Definition();
        Definition degust = new Definition();
        Definition bravura = new Definition();
        Definition constellate = new Definition();
        Definition bafflegab = new Definition();

        Definition verdant = new Definition();
        Definition abecedarian = new Definition();
        Definition mondegreen = new Definition();
        Definition boffo = new Definition();
        Definition diaphanous = new Definition();

        vicinal.setWord("vicinal");
        vicinal.setDefinition("Adjacent, local");
        degust.setWord("Degust");
        degust.setDefinition("To carefully and thoughtfully savor food");
        bravura.setWord("Bravura");
        bravura.setDefinition("A bold, brilliant display or performance");
        constellate.setWord("constellate");
        constellate.setDefinition("To gather together in a cluster");
        bafflegab.setWord("bafflegab");
        bafflegab.setDefinition("Messy, wordy jargon");

        verdant.setWord("verdant");
        verdant.setDefinition("Bright green in hue");
        abecedarian.setWord("abecedarian");
        abecedarian.setDefinition("Of or relating to the alphabet; Arranged in alphabetical order");
        mondegreen.setWord("mondegreen");
        mondegreen.setDefinition("A word or phrase that results from misheard language");
        boffo.setWord("boffo");
        boffo.setDefinition("Wildly successful or popular; Outstanding");
        diaphanous.setWord("diaphanous");
        diaphanous.setDefinition("Translucent; Very delicate");

        definitionList.add(vicinal);
        definitionList.add(degust);
        definitionList.add(bravura);
        definitionList.add(constellate);
        definitionList.add(bafflegab);

        definitionList.add(verdant);
        definitionList.add(abecedarian);
        definitionList.add(mondegreen);
        definitionList.add(boffo);
        definitionList.add(diaphanous);

    }

    // Extra controller for creating new Definitions
    @RequestMapping(value="/word", method= RequestMethod.POST)
    @ResponseStatus(value= HttpStatus.CREATED)
    public Definition createDefinition(@RequestBody @Valid Definition definition){

        // Test for duplicate word and definition
        boolean duplicateKey = false;
        for (Definition element: definitionList){
            if (element.getDefinition().equals(definition.getDefinition()) && element.getWord().equals(definition.getWord())){
                duplicateKey = true;
            }
        }

        // if duplicate key is found, throw error;
        if (duplicateKey) {
            throw new IllegalArgumentException("The Definition and Word you are adding already exists");
        }
        definitionList.add(definition);
        System.out.println(definitionList);
        return definition;
    }




}
