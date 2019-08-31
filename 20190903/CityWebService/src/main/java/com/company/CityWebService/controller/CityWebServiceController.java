package com.company.CityWebService.controller;

import com.company.CityWebService.model.City;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CityWebServiceController {
    List<City> cityList = new ArrayList<>();

    @RequestMapping(value="/city", method= RequestMethod.POST)
    @ResponseStatus(value= HttpStatus.CREATED)
    public City createCity(@RequestBody @Valid City city)
    {
        // Test for duplicate State and City.
        boolean duplicateKey = false;
        for (City element: cityList){
            if (element.getName().equals(city.getName()) && element.getState().equals(city.getState())){
                duplicateKey = true;
            }
        }

        // if duplicate key is found, throw error;
        if (duplicateKey) {
            throw new IllegalArgumentException("The city and state you are adding already exists");
        }

        cityList.add(city);
        return city;
    }

    @DeleteMapping(path="/city/{name}")
    @ResponseStatus(value=HttpStatus.NO_CONTENT)
    public void  deleteCity(@PathVariable String name)
    {
        City cityLookUp = new City();
        for(City city: cityList) {
            if (city.getName().equals(name)){
                cityLookUp = city;
            }
        }
        cityList.remove(cityLookUp);
        System.out.println("City " + name + " deleted.");
        System.out.println(cityList);
    }

    @GetMapping(path="/city")
    @ResponseStatus(value=HttpStatus.OK)
    public List<City> getCityList()
    {
        return cityList;
    }

    @GetMapping(path="/city/{name}")
    @ResponseStatus(value=HttpStatus.OK)
    public City getCityList(@PathVariable String name)
    {
        City cityLookUp = new City();
        for(City city: cityList) {
            if (city.getName().equals(name)){
                cityLookUp = city;
            }
        }
        return cityLookUp;
    }

}
