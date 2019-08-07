package com.company;

import java.util.Scanner;

public class AddFiveAndDouble {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num1 = scanner.nextInt();

        double ans = (num1 + 5)*2;

        System.out.println("Is you add 5 and double it, you new value is: " + ans);

    }
}
