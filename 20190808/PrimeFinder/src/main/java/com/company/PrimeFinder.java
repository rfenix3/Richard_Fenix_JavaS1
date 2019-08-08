package com.company;

import java.util.Scanner;

public class PrimeFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //System.out.println("Prime Finder");

        System.out.println("Enter a ceiling number (inclusive): ");
        int ceiling = scanner.nextInt();

        // set up a variable to indicate if number being tested is a prime number. Set default to true.
        boolean isPrime = true;

        // set i limit to <= in order for the prime finder to be inclusive.
        for (int i = 2; i <= ceiling; i++) {

            // Test for prime loop. For each number, divide it from 2 up to <= half of the ceiling.
            for (int j = 2; j <= i/2; j++) {

                // test if there will be a remainder.
                if (i % j == 0) {
                    isPrime = false;
                }
            }

            // After testing for prime loop and boolean isPrime wasn't switched to false, print the prime number.
            if (isPrime) {
                System.out.println(i);
            } else {
                //reset the boolean isPrime for next number's prime testing.
                isPrime = true;
            }
        }

    }
}
