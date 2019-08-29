package com.company.RestCalculatorFenixRichard.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class RestCalculatorController {

//    Old design:
//    @RequestMapping(value="calculator/add/{a}/{b}", method= RequestMethod.GET)
//    public int add(@PathVariable int a, @PathVariable int b) {
//        return a + b;
//    }

    // Using @PostMapping instead of @RequestMapping for processing parameters.
    // Using postman, run 'POST' http://localhost:8080/calculator/add?a=12&b=6
    @PostMapping("/calculator/add")
    public int add(@RequestParam int a, @RequestParam int b) {
        return a + b;
    }

    // Using postman, run 'POST' http://localhost:8080/calculator/subtract?a=12&b=6
    @PostMapping("/calculator/subtract")
    public int subtract(@RequestParam int a, @RequestParam int b) {
        return a - b;
    }

    // Using postman, run 'POST' http://localhost:8080/calculator/mult?a=12&b=6
    @PostMapping("/calculator/mult")
    public int mult(@RequestParam int a, @RequestParam int b) {
        return a * b;
    }

    // Using postman, run 'POST' http://localhost:8080/calculator/divide?a=12&b=6
    @PostMapping("/calculator/divide")
    public double divide(@RequestParam int a, @RequestParam int b) {
        return a / b;
    }

}
