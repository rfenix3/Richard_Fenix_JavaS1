package com.company;

import java.util.Scanner;

public class ValidNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Valid Number Loop Program");

        int userNumber;

        //Prompt user.
        System.out.print("Enter a number between 1 to 10: ");
        userNumber = scanner.nextInt();

        while (userNumber < 1 || userNumber > 10) {
            System.out.print("You must enter a number between 1 and 10, please try again.: ");
            userNumber = scanner.nextInt();
        }
        // once user enters a valid number, print the number.
        System.out.println(userNumber);
    }
}
