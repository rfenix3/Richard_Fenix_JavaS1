package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Scanner scanner = new Scanner(System.in);

        System.out.println("-------------------------------------");
        System.out.println("Welcome to How Many Times to 7 Game!");
        System.out.println("-------------------------------------");

        System.out.println("How many times do you want to roll the dice?");
        int userInput = scanner.nextInt();

        Random randomizer = new Random();

        int dice1;
        int dice2;
        int diceTotal;

        // declare a variable to count the total of 7's that will be rolled.
        boolean first7 = false;
        int firstRollToSeven = 0;

        // declare a variable to count the total of 7's that will be rolled.
        int totalSevens = 0;

        for (int i= 1; i <= userInput; i++) {
            dice1 = randomizer.nextInt(6) + 1;
            dice2 = randomizer.nextInt(6) + 1;
            diceTotal = dice1 + dice2;
            if (diceTotal == 7) {
                totalSevens++;
                System.out.println("Dice one = " + dice1 + ", Dice two = " + dice2 + " --> Total: " + diceTotal + " <-- Lucky 7!!!");
                if (first7 == false) {
                    firstRollToSeven = i;
                    first7 = true;
                }
            } else {
                System.out.println("Dice one = " + dice1 + ", Dice two = " + dice2 + " --> Total: " + diceTotal);
            }
        }

        System.out.println("Total number of 7s rolled is : " + totalSevens);

        if (first7 == false) {
            System.out.println("You never rolled a 7.");
        } else {
            System.out.println("It took " + firstRollToSeven + " rolls to roll the first 7.");
        }
    }
}
