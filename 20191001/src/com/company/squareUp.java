package com.company;


/**
 * Array-3 > squareUp
 * Given n>=0, create an array length n*n with the following pattern, shown here for
 * n=3 : {0, 0, 1,    0, 2, 1,    3, 2, 1} (spaces added to show the 3 groups).
 *
 * squareUp(3) → [0, 0, 1, 0, 2, 1, 3, 2, 1]
 * squareUp(2) → [0, 1, 2, 1]
 * squareUp(4) → [0, 0, 0, 1, 0, 0, 2, 1, 0, 3, 2, 1, 4, 3, 2, 1]
 */

public class squareUp {

    public static int[] squareUp(int n) {
        int[] intArray = new int[n * n];
        int counter = n;
        // int anotherCounter = n;
        int k = 1;

        for (int i = n * n - 1; i >= 0; i--) {
            if (k > n) {
                k = 1;
                counter--;
            }

            if (k <= counter) {
                intArray[i] = k;
            } else {
                intArray[i] = 0;
            }
            k++;
        }

        for (int element: intArray){
            System.out.println(element);
        }
        return intArray;
    }


    public static void main (String[]args){
        squareUp(4);

    }

}

