package com.company;

import java.util.Scanner;

public class AgeAgain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How old are you: ");
        int age = scanner.nextInt();

        if (age < 14) {
            System.out.println("What grade are you in? ");
            int grade = scanner.nextInt();
            System.out.printf("Wow! %s grade - that sounds exciting!", grade );
        } else if (age >= 14 && age <= 18) {
            System.out.println("Going to college?");
            String college = scanner.nextLine();
            if (college.equals("yes")) {
                System.out.printf("%s" is a great school!", college);
            }

        }

        System.out.println("That's the number I was looking for! 42 is definitely the answer!");

    }
}
