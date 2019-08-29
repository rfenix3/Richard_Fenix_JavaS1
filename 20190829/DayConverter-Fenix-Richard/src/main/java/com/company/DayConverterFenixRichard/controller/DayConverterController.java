package com.company.DayConverterFenixRichard.controller;

import com.company.DayConverterFenixRichard.model.Day;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class DayConverterController {
    @RequestMapping(value="/day/{dayNumber}", method= RequestMethod.GET)
    @ResponseStatus(value= HttpStatus.OK)
    public String getDay(@PathVariable int dayNumber)
    {
        Day wed = new Day();
        wed.setDayNumber(dayNumber);
        wed.setDayName("Wednesday");

        return wed.getDayName();

        /*
        // This switch block can be used if we don't use a model.
        String day = "";
        switch(dayNumber) {
            case 1:
                day = "Sunday";
                break;
            case 2:
                day = "Monday";
                break;
            case 3:
                day = "Tuesday";
                break;
            case 4:
                day = "Wednesday";
                break;
            case 5:
                day = "Thursday";
                break;
            case 6:
                day = "Friday";
                break;
            case 7:
                day = "Saturday";
                break;
            default:
                day = "Invalid day number.";
        }
        return day;
        */

    }


}
