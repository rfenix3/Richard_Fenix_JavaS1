package com.company.DayConverterFenixRichard.model;

import javax.validation.constraints.NotEmpty;

public class Day {
    private int dayNumber;
    private String dayName;

    @NotEmpty( message = "You must supply a value for day number.")
    public int getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(int dayId) {
        this.dayNumber = dayId;
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }
}
