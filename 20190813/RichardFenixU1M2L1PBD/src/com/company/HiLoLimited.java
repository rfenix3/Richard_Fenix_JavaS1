package com.company;

import java.util.Random;
import java.util.Scanner;

public class HiLoLimited {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Hi-Lo-Limited!");
        System.out.println("I am thinking of a number between 1-100. You have 7 guesses.");

        Random random = new Random();
        int computerNumber = random.nextInt(100) + 1;

        System.out.println("Computer number: " + computerNumber);

        int guesses = 1;
        boolean notGuessed = true;
        int userNumber;
        do {
            if (guesses == 1) {
                System.out.print("First guess: ");
            } else {
                System.out.printf("Guess # %d :", guesses);
            }
            userNumber = scanner.nextInt();
            if (userNumber < 1 || userNumber > 100) {
                System.out.println("Your number is out or range. Guess again.");
                continue;
            }
            if (userNumber > computerNumber && guesses < 7) {
                System.out.println("Too high!");
            } else if (userNumber < computerNumber && guesses < 7) {
                System.out.println("Too low!");
            } else if (userNumber == computerNumber) {
                notGuessed = false;
            }
            guesses++;
        }
        while (notGuessed && guesses <= 7);

        if (guesses <= 7) {
            System.out.printf("You guessed it! What are the odds?!?\n");
        } else {
            System.out.println("Sorry, you didn't guess it in 7 tries. You lose.");
        }

    }
}
