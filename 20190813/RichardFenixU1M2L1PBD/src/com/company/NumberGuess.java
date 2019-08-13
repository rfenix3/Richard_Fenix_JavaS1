package com.company;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class NumberGuess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int randomNum = random.nextInt(10) + 1;

        //System.out.println(randomNum);

        System.out.println("I'm thinking of a number from 1 to 10.");
        System.out.print("Your guess: ");
        int userGuess = scanner.nextInt();

        System.out.println();

        if (userGuess == randomNum) {
            System.out.printf("That's right! My secret number was %d!", randomNum);
        } else {
            System.out.printf("Sorry, but I was really thinking of %d", randomNum);
        }

    }
}
