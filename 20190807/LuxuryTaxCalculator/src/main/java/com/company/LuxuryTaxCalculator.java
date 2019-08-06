package com.company;

import java.util.Scanner;

public class LuxuryTaxCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter salary for Player 1: ");
        long salary1 = scanner.nextLong();

        System.out.println("Enter salary for Player 2: ");
        long salary2 = scanner.nextLong();

        System.out.println("Enter salary for Player 3: ");
        long salary3 = scanner.nextLong();

        long totalSalary = salary1 + salary2 + salary3;

        long luxuryTax = 0;

        if (totalSalary > 40_000_000) {
            luxuryTax = (long) ((totalSalary - 40_000_000)*0.18);
        };

        System.out.println("Total Salary of each player is: " + totalSalary);

        System.out.println("Cost of luxury tax is: " + luxuryTax);

    }
}
