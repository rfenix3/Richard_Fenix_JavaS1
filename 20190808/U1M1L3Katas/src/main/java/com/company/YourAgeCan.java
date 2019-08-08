package com.company;

import java.util.Scanner;

public class YourAgeCan {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an age: ");
        int age = scanner.nextInt();

        String message;

        if (age >= 18) {
            System.out.println("vote");
        }

        if (age >= 21) {
            System.out.println("alcohol");
        }

        if (age >= 35) {
            System.out.println("president");
        }

        if (age >= 55) {
            System.out.println("aarp");
        }
        if (age >= 65) {
            System.out.println("retire");
        }
        if (age >= 80 && age <=89 ) {
            System.out.println("octogenarian");
        }

        if (age >= 180) {
            System.out.println("century");
        }


    }
}
