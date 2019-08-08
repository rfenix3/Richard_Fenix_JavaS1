package com.company;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        // Set up the scanner and variables
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[10];
        String stringIn;
        int min;
        int max;
        int sum = 0;
        double avg;

        // Read in 10 ints
        for (int i = 0; i < numbers.length; i++) {

            System.out.println("Please enter a number:");
            stringIn = scanner.nextLine();
            numbers[i] = Integer.parseInt(stringIn);
        }

        // Calculate min
        min = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }

        // Calculate max
        max = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        // Calculate average
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        avg = sum/(double)numbers.length;

        System.out.println("Minimum value: " + min);
        System.out.println("Maximum value: " + max);
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + avg);
    }

}
