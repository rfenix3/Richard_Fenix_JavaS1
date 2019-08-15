package com.company;

import com.company.interfaces.UserIO;

import java.util.Scanner;

public class BetterInput implements UserIO {
    @Override
    public int readInt(String prompt) {
        int userInput = 0;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println(prompt);
            userInput = scanner.nextInt();
        } catch (Exception e) {
            // Assign the output of the recursive call to userInput variable to retain the value;
            userInput = readInt(prompt);
        }
        return userInput;
    }

    @Override
    public long readLong(String prompt) {
        long userInput = 0;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println(prompt);
            userInput = scanner.nextLong();
        } catch (Exception e) {
            // Assign the output of the recursive call to userInput variable to retain the value;
            userInput = readLong(prompt);
        }
        return userInput;
    }

    @Override
    public double readDouble(String prompt) {
        double userInput = 0;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println(prompt);
            userInput = scanner.nextDouble();
        } catch (Exception e) {
            // Assign the output of the recursive call to userInput variable to retain the value;
            userInput = readDouble(prompt);
        }
        return userInput;
    }

    @Override
    public float readFloat(String prompt) {
        float userInput = 0;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println(prompt);
            userInput = scanner.nextFloat();
        } catch (Exception e) {
            // Assign the output of the recursive call to userInput variable to retain the value;
            userInput = readFloat(prompt);
        }
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
