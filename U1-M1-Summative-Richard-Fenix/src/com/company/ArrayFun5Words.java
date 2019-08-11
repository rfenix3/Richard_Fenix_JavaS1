package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayFun5Words {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] userWords = new String[5];
        for (int i=0, entry=5; i<5; i++, entry--) {
            System.out.printf("Please enter %d word(s): ", entry);
            userWords[i] = scanner.nextLine();
        }
        System.out.println(Arrays.toString(userWords));
    }
}
