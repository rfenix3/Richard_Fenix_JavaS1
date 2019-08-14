package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayFunUserArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] userNumbers = new int[5];
        for (int i=0, entry=5; i<5; i++, entry--) {
            System.out.printf("Please enter %d number(s): ", entry);
            userNumbers[i] = scanner.nextInt();
        }
        System.out.println(Arrays.toString(userNumbers));
    }

}
