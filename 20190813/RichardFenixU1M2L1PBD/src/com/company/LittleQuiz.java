package com.company;

import java.util.Scanner;

public class LittleQuiz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Are you ready for a quiz? ");
        String ans = scanner.nextLine().toUpperCase();

        switch (ans) {
            case "N":
                System.out.println("Ok, Bye, bye!");
                System.exit(0);
                break;
            case "Y":
                break;
            default:
                System.out.println("Invalid entry. Run program again.");
                System.exit(0);

        }

        System.out.println("Okey, here it comes!");
        System.out.println();

        System.out.println("Q1) What is the capital of Alaska?");
        System.out.println("         1) Melbourne");
        System.out.println("         2) Anchorage");
        System.out.println("         3) Juneau \n");

        System.out.print("> ");
        int choice = scanner.nextInt();

        System.out.println();

        int correctCount = 0;

        if (choice == 3){
            correctCount ++;
            System.out.println("That's right!\n");
        } else {
            System.out.println("Sorry that is wrong.\n");
        }

        System.out.println("Q2) Can you store the value of \"cat\" in a variable of type int?");
        System.out.println("         1) yes");
        System.out.println("         2) no\n");

        System.out.print("> ");
        choice = scanner.nextInt();

        System.out.println();

        if (choice == 2){
            correctCount ++;
            System.out.println("That's right!\n");
        } else {
            System.out.println("Sorry, \"cat\" is a string. ints can only store numbers.\n");
        }

        System.out.println("Q3) What is the result of 9+6/3?");
        System.out.println("         1) 5");
        System.out.println("         2) 11");
        System.out.println("         3) 15/3\n");

        System.out.print("> ");
        choice = scanner.nextInt();

        System.out.println();

        if (choice == 2){
            correctCount ++;
            System.out.println("That's correct!\n");
        } else {
            System.out.println("Sorry that is wrong.\n");
        }

        System.out.printf("Overall, you got %d out of 3 correct.\n", correctCount);
        System.out.println("Thanks for playing!");

    }


}
