package com.company;

import java.util.Collections;
import java.util.LinkedList;

public class LinkedListApp {
    public static int total (LinkedList<Integer> numbers) {

        int sum = 0;
        for(int num : numbers) {
            sum += num;
        }

        return sum;
    }

    public static int totalEven (LinkedList<Integer> numbers) {

        int sum = 0;

        for(int i = 0; i < numbers.size(); i += 2) {
            // Use the get() method for LinkedList;
            sum += numbers.get(i);
        }

        return sum;
    }

    public static LinkedList<String> swapFirstAndLast(LinkedList<String> strings) {

        String temp = strings.get(0);
        strings.set(0 , strings.get(strings.size() - 1));
        strings.set((strings.size() - 1 ), temp);
        return strings;
    }

    public static LinkedList<Integer> reverse(LinkedList<Integer> numbers) {

        // Create shallow copy of LinkedList
        LinkedList<Integer> reversed = new LinkedList<>(numbers);

        for(int i = 0; i < numbers.size(); i++) {

            // length - (i + 1) is the n-th to last element
            // so when i = 0, it would be the last element
            // when i = 3, it would be the fourth to last element since i=3 is the 4th element, etc
            reversed.set(i, numbers.get(numbers.size() - (i + 1)));
        }

        return reversed;
    }

    public static LinkedList<Integer> lessThanFive(LinkedList<Integer> numbers) {

        int numLessThanFive = 0;

        for(int num : numbers) {
            if ( num < 5 ) {
                numLessThanFive++;
            }
        }

        if ( numLessThanFive == 0 ) {
            return null;
        }

        // Create LinkedList<Integer> variable with defined length of 0 values.
        LinkedList<Integer> lessThan = new LinkedList<>(Collections.nCopies(numLessThanFive, 0));

        for(int num : numbers) {
            if ( num < 5 ) {

                // subtracting numLessThanFive from length then decrementing numLessThanFive
                // allows us to go from 0 to length - 1 in order without additional variables
                lessThan.set((lessThan.size() - numLessThanFive), num);
                numLessThanFive--;
            }
        }

        return lessThan;
    }

    //challenge
    public static int[][] splitAtFive(int[] numbers) {
        int numLessThanFive = 0;
        int numMoreThanFive = 0;

        for(int num : numbers) {
            if ( num < 5 ) {
                numLessThanFive++;
            } else {
                numMoreThanFive++;
            }
        }

        int[] lessThan = new int[numLessThanFive];
        int[] moreThan = new int[numMoreThanFive];


        for(int num : numbers) {

            // subtracting numLessThanFive from length then decrementing numLessThanFive
            // allows us to go from 0 to length - 1 in order without additional variables
            // same with numMoreThanFive
            if ( num < 5 ) {
                lessThan[lessThan.length - numLessThanFive] = num;
                numLessThanFive--;
            } else {
                moreThan[moreThan.length - numMoreThanFive] = num;
                numMoreThanFive--;
            }
        }

        return new int[][] { lessThan, moreThan };
    }

    // Challenge
    public static String[][] evensAndOdds(String[] strings) {

        //leveraging integer division
        String[] odds = new String[ strings.length/2 ];

        // Set evens to null for reassignment below
        String[] evens = null;

        // again leveraging integer division
        // if it's already of even length, we're good
        // but if it's of odd length, there's one more even index than odd
        if (strings.length % 2 == 0) {
            evens = new String[ strings.length/2];
        } else {
            evens = new String[ strings.length/2 + 1];
        }

        for(int i = 0; i < strings.length; i++) {
            int currIndex = i/2;
            if( i % 2 == 0 ) {
                evens[currIndex] = strings[i];
            } else {
                odds[currIndex] = strings[i];
            }
        }

        return new String[][] { evens, odds };
    }
}




