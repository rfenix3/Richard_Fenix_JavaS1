package com.company;

import com.company.interfaces.UserIO;

import java.util.Scanner;

public class Input implements UserIO
{
    @Override
    public int readInt(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        int userInput = scanner.nextInt();
        return userInput;
    }

    @Override
    public long readLong(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        long userInput = scanner.nextLong();
        return userInput;
    }

    @Override
    public double readDouble(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        double userInput = scanner.nextDouble();
        return userInput;
    }

    @Override
    public float readFloat(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        float userInput = scanner.nextFloat();
        return userInput;
    }

    @Override
    public String readString(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        String userInput = scanner.nextLine();
        return userInput;
    }
}
