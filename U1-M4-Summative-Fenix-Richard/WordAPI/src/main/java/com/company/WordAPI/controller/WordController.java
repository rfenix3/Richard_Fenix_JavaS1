package com.company.WordAPI.controller;

import com.company.WordAPI.dao.WordDao;
import com.company.WordAPI.model.Definition;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class WordController {

    // We instantiate WordDao to get the word list and get() method into this controller
    private static WordDao wordDao = new WordDao();

    @GetMapping(path="/word")
    @ResponseStatus(value=HttpStatus.OK)
    public Definition getDefinition(){
        Random random = new Random();

        // get the random index based on the size of the list. Since size is 10, we set bound to 10.
        int i = random.nextInt(10);
        System.out.println("Index of word in list is " + i);
        return wordDao.get(i);
    }

}
