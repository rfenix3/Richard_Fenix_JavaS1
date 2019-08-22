package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class CopyingArraylists {

    public static void main(String[] args) {
        Random random = new Random();

        List<Integer> intList1 = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            int x = random.nextInt(100) + 1;
            intList1.add(x);
        }

        System.out.println( "ArrayList 1: " + intList1 );

        // Create second ArrayList
        List<Integer> intList2 = new ArrayList<>();

        // Create an Iterator for the ArrayList.
        Iterator<Integer> iterator = intList1.iterator();

        while(iterator.hasNext()){
            intList2.add((Integer) iterator.next());
        }

        intList2.set(intList2.size()-1, -7);

        System.out.println( "ArrayList 2: " + intList2 );


    }

}
