package com.company;

import com.company.interfaces.Converter;

public class ConverterSwitch implements Converter {
    @Override
    public String convertMonth(int monthNumber) {
        String returnMessage;
        switch (monthNumber) {
            case 1:
                returnMessage = "January";
                break;
            case 2:
                returnMessage = "February";
                break;
            case 3:
                returnMessage = "March";
                break;
            case 4:
                returnMessage = "April";
                break;
            case 5:
                returnMessage = "May";
                break;
            case 6:
                returnMessage = "June";
                break;
            case 7:
                returnMessage = "July";
                break;
            case 8:
                returnMessage = "August";
                break;
            case 9:
                returnMessage = "September";
                break;
            case 10:
                returnMessage = "October";
                break;
            case 11:
                returnMessage = "November";
                break;
            case 12:
                returnMessage = "December";
                break;
            default:
                returnMessage = "Invalid value. convertMonth() method's argument should only be between 1 to 12.";
        }
        return returnMessage;
    }

    @Override
    public String convertDay(int dayNumber) {
        String returnMessage;
        switch (dayNumber) {
            case 1:
                returnMessage = "Sunday";
                break;
            case 2:
                returnMessage = "Monday";
                break;
            case 3:
                returnMessage = "Tuesday";
                break;
            case 4:
                returnMessage = "Wednesday";
                break;
            case 5:
                returnMessage = "Thursday";
                break;
            case 6:
                returnMessage = "Friday";
                break;
            case 7:
                returnMessage = "Saturday";
                break;
            default:
                returnMessage = "Invalid value. convertMonth() method's argument should only be between 1 to 12.";
        }
        return returnMessage;
    }
}
