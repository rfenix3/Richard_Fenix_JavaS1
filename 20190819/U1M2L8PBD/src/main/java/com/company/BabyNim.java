package com.company;

import java.util.Scanner;

public class BabyNim {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pileA = 3, pileB = 3, pileC = 3;

        boolean gameOver = false;
        String userPile = "";
        int userNumber = 0;

        System.out.printf("A: %d    B: %d    C: %d\n", pileA, pileB, pileC);

        do {
            System.out.printf("\nChoose a pile :");
            userPile = scanner.nextLine().toUpperCase();

            System.out.printf("How many to remove from pile %s: ", userPile);
            userNumber = Integer.parseInt(scanner.nextLine());

            switch(userPile){
                case "A":
                    pileA = pileA - userNumber;
                    break;
                case "B":
                    pileB = pileB - userNumber;
                    break;
                case "C":
                    pileC = pileC - userNumber;
                    break;
                default:
                    pileA = 0; pileB = 0; pileC=0;
            }

            System.out.printf("\nA: %d    B: %d    C: %d\n", pileA, pileB, pileC);

            if ((pileA <= 0) && (pileB <=0) && (pileC <= 0)) {
                gameOver = true;
            }
        }
        while (gameOver == false);

        System.out.println("All piles are empty. Good job!");

    }
}
