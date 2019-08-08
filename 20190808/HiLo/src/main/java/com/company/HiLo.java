package com.company;

import java.util.Scanner;
import java.util.Random;

public class HiLo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Hi-Low!");

        System.out.println("Enter user name: ");
        String userName = scanner.nextLine();

        Random random = new Random();
        int computerNumber = random.nextInt(100) + 1;

        //System.out.println("Computer number: " + computerNumber);

        System.out.printf("OK, %s, here are the rules:\n", userName);
        System.out.println("The computer will come up with a number between 1 and 100 (inclusive).");
        System.out.println("The user will be prompted to guess the number until the user guesses it correctly.");

        int guesses = 0;
        boolean notGuessed = true;
        int userNumber;
        do {
            System.out.println("Enter a whole number between 1 to 100: ");
            userNumber = scanner.nextInt();
            guesses++;
            if (userNumber < 1 || userNumber > 100) {
                System.out.println("Your number is out or range. Guess again.");
                continue;
            }
            if (userNumber > computerNumber) {
                System.out.println("Too high!");
            } else if (userNumber < computerNumber) {
                System.out.println("Too low!");
            } else if (userNumber == computerNumber) {
                notGuessed = false;
            }
        }
        while (notGuessed);

        System.out.printf("Congratulations, %s! You win!\n", userName);
        System.out.printf("It took you %d guesses to find my number!", guesses);

    }
}
