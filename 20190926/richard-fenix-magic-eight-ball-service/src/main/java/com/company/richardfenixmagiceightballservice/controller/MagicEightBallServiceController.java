package com.company.richardfenixmagiceightballservice.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RefreshScope
public class MagicEightBallServiceController {
    // something to hold our greetings
    private List<String> ansList = new ArrayList<>();
    // so we can randomly return a greeting
    private Random rndGenerator = new Random();

    public MagicEightBallServiceController() {

        // some greetings
        ansList.add("No");
        ansList.add("Yes");
        ansList.add("Lookking cloudy");
        ansList.add("Not sure");
        ansList.add("Absolutely!");
        ansList.add("Ask again");
        ansList.add("Ummm");
        ansList.add("Not a chance");
    }

    @RequestMapping(value = "/eightballanswer", method = RequestMethod.GET)
    public String getRandomGreeting() {

        // select and return a random greeting
        int whichQuote = rndGenerator.nextInt(8);
        return ansList.get(whichQuote);
    }

}
