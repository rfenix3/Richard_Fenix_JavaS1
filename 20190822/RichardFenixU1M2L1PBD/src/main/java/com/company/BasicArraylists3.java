package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BasicArraylists3 {

    public static void main(String[] args) {
        Random random = new Random();

        List<Integer> numList =new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            // For range from 10 to 99.
            // r.nextInt((max - min) + 1) + min
            int x = random.nextInt(90) + 10;
            numList.add(x);
        }

        System.out.println( "ArrayList: " + numList );


    }

}
