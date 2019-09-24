package com.company.richardfenixrandomquoteservice.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RefreshScope
public class QuoteCloudServiceController {

    @RequestMapping(value="/quote", method=RequestMethod.GET)
    public String quoteCoud(){

        List<String> quoteList = new ArrayList<>();
        quoteList.add("To me programming is more than an important practical art. It is also" +
                " a gigantic undertaking in the foundations of knowledge. - Grace Hopper");
        quoteList.add("Programs must be written for people to read, and only incidentally for" +
                " machines to execute. - Hal Ableson");
        quoteList.add("Don't call me the mother of the internet. - Radia Perlman");
        quoteList.add("When I first started using the phrase software engineering, it was " +
                "considered to be quite amusing. They used to kid me about my radical ideas. " +
                "Software eventually and necessarily gained the same respect as any other " +
                "discipline. - Margaret Hamilton");
        quoteList.add("Machines take me by surprise with great frequency. - Alan Turing");
        quoteList.add("The function of good software is to make the complex appear simple. - " +
                "Grady Booch");
        quoteList.add("An API that isn't comprehensible isn't usable. - James Gosling");
        quoteList.add("I'm not a great programmer; I'm just a good programmer with great habits. " +
                "- Martin Fowler");

        Random random = new Random();
        // get the random index based on the size of the list. Since size is 10, we set bound to 10.
        int i = random.nextInt(8);
        return quoteList.get(i);
    }

}
