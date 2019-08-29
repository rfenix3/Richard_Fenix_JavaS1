package com.company.WeatherAPIFenixRichard.controller;

import com.company.WeatherAPIFenixRichard.model.Condition;
import com.company.WeatherAPIFenixRichard.model.Temperature;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class WeatherAPIController {
    @RequestMapping(value="/temp/{zipcode}", method= RequestMethod.GET)
    @ResponseStatus(value= HttpStatus.OK)
    public Temperature getTemparature(@PathVariable String zipcode)
    {
        Temperature mariettaTemp = new Temperature();
        mariettaTemp.setFahrenheit(76);
        mariettaTemp.setCelsius(26.11);

        Condition marietta = new Condition();
        marietta.setZipcode(zipcode);
        marietta.setPrecipitation("rain");
        marietta.setSkies("cloudy");
        marietta.setWindDirection("NW");
        marietta.setWindSpeed(12);
        marietta.setTemperature(mariettaTemp);

        return mariettaTemp;
    }

    @RequestMapping(value="/conditions/{zipcode}", method= RequestMethod.GET)
    @ResponseStatus(value= HttpStatus.OK)
    public Condition getCondition(@PathVariable String zipcode)
    {
        Temperature mariettaTemp = new Temperature();
        mariettaTemp.setFahrenheit(76);
        mariettaTemp.setCelsius(26.11);

        Condition marietta = new Condition();
        marietta.setZipcode(zipcode);
        marietta.setPrecipitation("rain");
        marietta.setSkies("cloudy");
        marietta.setWindDirection("NW");
        marietta.setWindSpeed(12);
        marietta.setTemperature(mariettaTemp);

        return marietta;
    }

    @RequestMapping(value="/conditions/{zipcode}", method=RequestMethod.PUT)
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public Condition updateCondition (@PathVariable String zipcode, @RequestBody Condition condition)
    {
        if (!zipcode.equals(condition.getZipcode())) {
            throw new IllegalArgumentException("Zipcode on path must match the ID ");
        };
        return condition;
    }

    @RequestMapping(value="/conditions", method=RequestMethod.POST)
    @ResponseStatus(value= HttpStatus.CREATED)
    public Condition createCondition(@RequestBody Condition condition)
    {
        condition.setZipcode("30338");
        return condition;
    }

    @RequestMapping(value = "/conditions/{zipcode}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCondition(@PathVariable("zipcode") String zipcode) {
        // do nothing here - in a real application we would delete the entry from
        // the data store.
    }

}
