package com.company;

import java.util.Scanner;

public class LoanCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter mortgage amount: ");
        double mortgage = scanner.nextDouble();

        System.out.println("Enter terms (in months): ");
        double term = scanner.nextDouble();

        System.out.println("Enter annual rate (in percent): ");
        double annualRate = scanner.nextDouble();

        double monthlyRate = annualRate/100/12;

        double compoundedMonthlyInterest = Math.pow( (1 + monthlyRate), term);

        //System.out.println(compoundedMonthlyInterest);

        double fixedMonthly = mortgage*((monthlyRate*compoundedMonthlyInterest)/(compoundedMonthlyInterest - 1));

        System.out.println("Monthly fixed payment is: " + fixedMonthly);

    }
}
