package com.company.HelloRestServiceFenixRichard.controller;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {
    @RequestMapping(value="hello/{name}", method= RequestMethod.GET)
    public String hello(@PathVariable String name) {
        return "Hello, " + name;
    }
}
