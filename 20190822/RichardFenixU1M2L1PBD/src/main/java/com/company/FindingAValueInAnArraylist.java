package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class FindingAValueInAnArraylist {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        List<Integer> intList1 = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            int x = random.nextInt(50) + 1;
            intList1.add(x);
        }

        System.out.println( "ArrayList: " + intList1 );

        System.out.print("Value to find: ");
        Integer userInput = Integer.parseInt(scanner.nextLine());

        int foundIndex = intList1.indexOf(userInput);

        if (foundIndex > 0) {
            System.out.printf("%d is in the ArrayList.", userInput);
        };

    }

}
