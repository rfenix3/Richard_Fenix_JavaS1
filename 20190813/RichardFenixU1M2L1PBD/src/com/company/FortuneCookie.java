package com.company;

import java.util.Random;
import java.util.Scanner;

public class FortuneCookie {
    public static void main(String[] args) {
        Random random = new Random();

        int randomNum = random.nextInt(8) + 1;

        switch(randomNum) {
            case 1:
                System.out.println("The fortune you seek is in another cookie.");
                break;
            case 2:
                System.out.println("A foolish man listens to his heart. A wise man listens to cookies.");
                break;
            case 3:
                System.out.println("Some men dream of fortunes, others dream of cookies.");
                break;
            case 4:
                System.out.println("We don't know the future, but here's a cookie.");
                break;
            case 5:
                System.out.println("You will be hungry again in one hour.");
                break;
            case 6:
                System.out.println("The road to riches is paved with homework.");
                break;
            case 7:
                System.out.println("The early bird gets the worm, but the second mouse gets the cheese.");
                break;
            case 8:
                System.out.println("Help! I am being held prisoner in a fortune cookie factory.");
                break;
            default:
                System.out.println("Cookie Error!!!");
        }

        // Create lottoNum array to hold 6 lotto random number between 1 to 54.
        int[] lottoNum = new int[6];

        for (int i = 0; i < 6; i++) {
            lottoNum[i] = random.nextInt(54) + 1;
        }

        // Print out the lotto number in the desired format.
        System.out.printf("    %d - %d - %d - %d - %d - %d",
                lottoNum[0], lottoNum[1], lottoNum[2], lottoNum[3], lottoNum[4], lottoNum[5]);
    }
}
