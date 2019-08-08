package com.company;

import java.util.Scanner;

public class RangeChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number;

        do {
            System.out.println("Enter a number between 15 and 32 (not inclusive): ");
            number = scanner.nextInt();

            if (number > 15 && number < 32) {
                System.out.println(number);
                break;
            }
        }
        while (true);

    }
}
