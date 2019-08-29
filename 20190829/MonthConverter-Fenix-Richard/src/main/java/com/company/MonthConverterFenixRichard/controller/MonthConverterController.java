package com.company.MonthConverterFenixRichard.controller;

import com.company.MonthConverterFenixRichard.model.Month;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class MonthConverterController {
    @RequestMapping(value="/month/{monthNumber}", method= RequestMethod.GET)
    @ResponseStatus(value= HttpStatus.OK)
    public String getMonth(@PathVariable int monthNumber)
    {
        Month march = new Month();
        march.setMonthNumber(monthNumber);
        march.setMonthName("March");

        return march.getMonthName();
    }


}
