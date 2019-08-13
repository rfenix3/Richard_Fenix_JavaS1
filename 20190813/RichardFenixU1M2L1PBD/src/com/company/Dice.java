package com.company;

import java.util.Random;

public class Dice {
    public static void main(String[] args) {
        Random random = new Random();

        int dice1 = random.nextInt(6) + 1;
        int dice2 = random.nextInt(6) + 1;
        int diceTotal = dice1 + dice2;

        System.out.println("HERE COMES THE DICE!\n");
        System.out.printf("Roll #1: %d \n", dice1);
        System.out.printf("Roll #2: %d \n", dice2);
        System.out.printf("Total is %d!\n", diceTotal);

    }
}
