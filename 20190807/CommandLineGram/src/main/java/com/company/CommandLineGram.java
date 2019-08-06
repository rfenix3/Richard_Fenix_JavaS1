package com.company;

import java.util.Scanner;

public class CommandLineGram {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Emain address: ");
        String email = scanner.nextLine();

        System.out.print("Twitter handle: ");
        String twitter = scanner.nextLine();

        System.out.print("Age: ");
        int age = scanner.nextInt();

        scanner.nextLine(); // Consumes "\n"

        System.out.print("Country: ");
        String country = scanner.nextLine();

        System.out.print("Profession: ");
        String profession = scanner.nextLine();

        System.out.print("Favorite operating system: ");
        String favOS = scanner.nextLine();

        System.out.print("Favorite programming language: ");
        String favProgLang = scanner.nextLine();

        System.out.print("Favorite computer scientist: ");
        String favCS = scanner.nextLine();

        System.out.print("Favorite keyboard shortcut: ");
        String favKey = scanner.nextLine();

        System.out.print("Have you ever built your own computer? ");
        String builtComp = scanner.nextLine();

        System.out.print("If you could be any superhero, who would it be? ");
        String superhero = scanner.nextLine();

        System.out.println("");
        System.out.println("===========================================");
        System.out.println("First name : " + firstName);
        System.out.println("Last name : " + lastName);
        System.out.println("Email: " + email);
        System.out.println("Twitter handle: " + twitter);
        System.out.println("Age: " + age);
        System.out.println("Country: " + country);
        System.out.println("Profession: " + profession);
        System.out.println("Favorite OS: " + favOS);
        System.out.println("Favorite programming language: " + favProgLang);
        System.out.println("Favorite computer scientist: " + favCS);
        System.out.println("Favorite keyboard shortcut: " + favKey);
        System.out.println("Built a computer: " + builtComp);
        System.out.println("Superhero character: " + superhero);
        System.out.println("===========================================");


    }
}
