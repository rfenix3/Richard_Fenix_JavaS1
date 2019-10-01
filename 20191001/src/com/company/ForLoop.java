package com.company;

public class ForLoop {

    public static void main(String[] args) {
	// write your code here
        int tens = 0;
        int ones = 0;
        int total = 0;
        for (int i=10; i < 100; i++) {
            tens = i / 10;
            ones = i % 10;
            total = tens + ones;
            System.out.printf("%d, %d+%d = %d \n", i, tens, ones, total);
        }

    }
}
