package com.company;

import java.util.Scanner;

public class FavoriteProgrammingLanguage {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String favLanguage;

        do {
            System.out.println("What's your favorite programming language? ");
            favLanguage = scanner.nextLine();

        }
        while (!favLanguage.equals("Java"));

        System.out.println("That's what I was looking for! Java is definitely the answer!");

    }
}
