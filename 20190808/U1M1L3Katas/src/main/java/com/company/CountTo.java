package com.company;

import java.util.Scanner;

public class CountTo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int number = scanner.nextInt();

        for (int i=0; i<=number; i++) {
            System.out.println(i);
        }

    }
}
