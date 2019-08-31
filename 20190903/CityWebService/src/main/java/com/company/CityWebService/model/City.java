package com.company.CityWebService.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class City {

    @NotEmpty( message="You must supply a name for the city.")
    private String name;
    @NotEmpty( message="You must supply a state for the city.")
    private String State;
    @NotNull( message="You must supply a population for the city.")
    private long Population;
    private boolean capital;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public long getPopulation() {
        return Population;
    }

    public void setPopulation(long population) {
        Population = population;
    }

    public boolean isCapital() {
        return capital;
    }

    public void setCapital(boolean capital) {
        this.capital = capital;
    }
}
