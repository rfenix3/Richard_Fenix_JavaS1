package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GettingTheLargestValueInAnArraylist {

    public static void main(String[] args) {

        Random random = new Random();
        List<Integer> integerList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            int x = random.nextInt(100) + 1;
            integerList.add(x);
        }
        System.out.println("ArrayList: " + integerList);

        // Execute linear search...
        int size = integerList.size();
        Integer largestNum = integerList.get(0);
        for(int i = 0; i < size; i++){
            if (integerList.get(i) > largestNum) {
                largestNum = integerList.get(i);
            }
        }

        System.out.println("\nThe largest value is " + largestNum);


    }
}
