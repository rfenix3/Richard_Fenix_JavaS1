package com.company;

import java.util.Scanner;

public class IsJavaKeyword {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a word: ");
        String word = scanner.nextLine();

        switch (word) {
            case "if":
                System.out.println("is a java keyword");
                break;
            case "then":
                System.out.println("is a java keyword");
                break;
            case "else":
                System.out.println("is a java keyword");
                break;
            case "for":
                System.out.println("is a java keyword");
                break;
            case "while":
                System.out.println("is a java keyword");
                break;
            case "do":
                System.out.println("is a java keyword");
                break;
            case "switch":
                System.out.println("is a java keyword");
                break;
            case "case":
                System.out.println("is a java keyword");
                break;
            default:
                System.out.println("not a java keyword");
        }

    }
}
