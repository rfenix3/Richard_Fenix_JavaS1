package com.company;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingWithACounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int randomNum = random.nextInt(10) + 1;

        //System.out.println(randomNum);

        System.out.println("I have chosen a number between 1 and 10. Try to guess it.");

        int userGuess = 0;
        int numberOfGuesses = 1;

        while (userGuess != randomNum) {
            System.out.print("Your guess: ");
            userGuess = scanner.nextInt();

            if (userGuess == randomNum) {
                System.out.printf("That's right! You're a good guesser.\n");
                System.out.printf("It only took you %d tries.", numberOfGuesses);
            } else {
                System.out.printf("That is incorrect. Guess again.\n");
                numberOfGuesses ++;
            }
        }

    }

}
