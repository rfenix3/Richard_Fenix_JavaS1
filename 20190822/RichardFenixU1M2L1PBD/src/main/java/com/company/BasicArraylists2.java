package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BasicArraylists2 {
    public static void main(String[] args) {
        Random random = new Random();

        List<Integer> numList =new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            int x = random.nextInt(100) + 1;
            numList.add(x);
        }

        System.out.println( "ArrayList: " + numList );


    }
}
