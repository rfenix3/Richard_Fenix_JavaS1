package com.company.MonthConverterFenixRichard.model;

import javax.validation.constraints.NotEmpty;

public class Month {
    private int monthNumber;
    private String monthName;

    @NotEmpty( message = "You must supply a value for month number.")
    public int getMonthNumber() {
        return monthNumber;
    }

    public void setMonthNumber(int monthNumber) {
        this.monthNumber = monthNumber;
    }

    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }
}
