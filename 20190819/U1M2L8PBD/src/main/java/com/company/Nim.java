package com.company;

import java.util.Scanner;

public class Nim {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pileA = 3, pileB = 4, pileC = 5;

        // Initialize player names and currentPlayer variable to hold current player.
        String player1 = "";
        String player2 = "";
        String currentPlayer = "";

        boolean gameOver = false;
        String userPile = "";
        int userNumber = 0;

        System.out.printf("Player 1, enter your name: ");
        player1 = scanner.nextLine();

        System.out.printf("Player 2: enter your name: ");
        player2 = scanner.nextLine();

        // Set initial player to the first player.
        currentPlayer = player1;

        System.out.printf("A: %d    B: %d    C: %d\n", pileA, pileB, pileC);

        do {
            System.out.printf("\n%s choose a pile :", currentPlayer);
            userPile = scanner.nextLine().toUpperCase();

            switch(userPile){
                case "A":
                    // Test if chosen pile is empty, ask user to try again.
                    if (pileA == 0) {
                        System.out.printf("Nice try, %s. That pile is empty.", currentPlayer);
                        continue;
                    }

                    System.out.printf("How many to remove from pile %s: ", userPile);
                    userNumber = Integer.parseInt(scanner.nextLine());

                    // Test if user put a negative number, ask user to try again.
                    if (userNumber < 1) {
                        System.out.println("You must choose at least 1. Try again.");
                        continue;
                    }

                    // Test if user puts a bigger number than what is left in the pile, ask user to try again.
                    if (userNumber > pileA) {
                        System.out.println("File A doesn't have that many. Try again.");
                        continue;
                    }

                    // Compute for the new pile balance.
                    pileA = pileA - userNumber;
                    break;
                case "B":
                    if (pileB == 0) {
                        System.out.printf("Nice try, %s. That pile is empty.", currentPlayer);
                        continue;
                    }
                    System.out.printf("How many to remove from pile %s: ", userPile);
                    userNumber = Integer.parseInt(scanner.nextLine());
                    if (userNumber < 1) {
                        System.out.println("You must choose at least 1. Try again.");
                        continue;
                    }
                    if (userNumber > pileB) {
                        System.out.println("File B doesn't have that many. Try again.");
                        continue;
                    }
                    pileB = pileB - userNumber;
                    break;
                case "C":
                    if (pileC == 0) {
                        System.out.printf("Nice try, %s. That pile is empty.", currentPlayer);
                        continue;
                    }
                    System.out.printf("How many to remove from pile %s: ", userPile);
                    userNumber = Integer.parseInt(scanner.nextLine());
                    if (userNumber < 1) {
                        System.out.println("You must choose at least 1. Try again.");
                        continue;
                    }
                    if (userNumber > pileC) {
                        System.out.println("File C doesn't have that many. Try again.");
                        continue;
                    }
                    pileC = pileC - userNumber;
                    break;
                // Is user inputs other character or string other than A, B, or C, notify
                // user of valid entries and ask user to try again.
                default:
                    System.out.println("Please select only A, a, B, b, C, or c.");
                    continue;
            }

            System.out.printf("\nA: %d    B: %d    C: %d\n", pileA, pileB, pileC);

            // Switch current player in this if statement block.
            if (currentPlayer.equals(player1)){
                currentPlayer = player2;
            } else {
                currentPlayer = player1;
            }

            // If all piles are empty, set flag gameOver to true to exit the do/while loop.
            if ((pileA <= 0) && (pileB <=0) && (pileC <= 0)) {
                gameOver = true;
            }
        }
        while (gameOver == false);

        // Print winner of the game.
        System.out.printf("\n%s, there are no counters left, so you WIN!", currentPlayer);
    }

}
