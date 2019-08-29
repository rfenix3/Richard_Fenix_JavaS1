package com.company.WeatherAPIFenixRichard.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Condition {

    @NotEmpty( message="You must supply a value for zipcode.")
    @Size(min=5, max=5, message="Zipcode must be 5 characters in length.")
    private String zipcode;
    private double windSpeed;
    private String windDirection;
    private String skies;
    private String precipitation;
    private Temperature temperature;

    public String  getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public String getSkies() {
        return skies;
    }

    public void setSkies(String skies) {
        this.skies = skies;
    }

    public String getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(String precipitation) {
        this.precipitation = precipitation;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }
}
