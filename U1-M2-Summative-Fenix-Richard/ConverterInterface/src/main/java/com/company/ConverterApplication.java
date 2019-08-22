package com.company;

public class ConverterApplication {
    public static void main(String[] args) {

        // Instantiate ConvertIf class
        ConverterIf convertIf = new ConverterIf();

        System.out.println("Using ConverterIf Class... ");
        System.out.println("============================");

        // Show output of convertDay() method using parameters from 1 to 8 using for-loop. Although
        // values considered as valid is only between 1-7, extend i to 8 to show the error message.
        for (int i=1; i <= 8; i++){
            System.out.println(convertIf.convertDay(i));
        }

        // Show output of convertMonth() method using parameters from 1 to 13 using for-loop. Although
        // values considered as valid is only between 1-12, extend i to 13 to show the error message.
        for (int i=1; i <= 13; i++){
            System.out.println(convertIf.convertMonth(i));
        }

        System.out.println("Using ConverterSwitch Class... ");
        System.out.println("============================== ");

        // Instantiate ConvertSwitch class
        ConverterSwitch convertSwitch = new ConverterSwitch();

        // Show output of convertDay() method using parameters from 1 to 8 using for-loop. Although
        // values considered as valid is only between 1-7, extend i to 8 to show the error message.
        for (int i=1; i <= 8; i++){
            System.out.println(convertSwitch.convertDay(i));
        }

        // Show output of convertMonth() method using parameters from 1 to 13 using for-loop. Although
        // values considered as valid is only between 1-12, extend i to 13 to show the error message.
        for (int i=1; i <= 13; i++){
            System.out.println(convertSwitch.convertMonth(i));
        }



    }
}
