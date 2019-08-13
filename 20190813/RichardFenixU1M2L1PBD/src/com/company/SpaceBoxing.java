package com.company;

import java.sql.SQLOutput;
import java.util.Scanner;

public class SpaceBoxing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your current earth weight: ");
        double earthWeight = scanner.nextDouble();

        System.out.println();
        System.out.println("I have information for the following planets");
        System.out.println("   1. Venus   2. Mars    3. Jupiter");
        System.out.println("   4. Saturn  5. Uranus  6. Neptune");
        System.out.println();

        System.out.print("Which planet are you visiting? ");
        int planetChoice = scanner.nextInt();
        System.out.println();

        double otherPlanetWeight = 0;

        switch (planetChoice) {
            case 1:
                otherPlanetWeight = earthWeight * 0.78;
                break;
            case 2:
                otherPlanetWeight = earthWeight * 0.39;
                break;
            case 3:
                otherPlanetWeight = earthWeight * 2.65;
                break;
            case 4:
                otherPlanetWeight = earthWeight * 1.17;
                break;
            case 5:
                otherPlanetWeight = earthWeight * 1.05;
                break;
            case 6:
                otherPlanetWeight = earthWeight * 1.23;
                break;
            default:
                System.out.println("Invalid choice. Please enter between 1 to 6 only.");
        }

        System.out.printf("Your weight would be %.2f pounds on that planet.", otherPlanetWeight);


    }

}
