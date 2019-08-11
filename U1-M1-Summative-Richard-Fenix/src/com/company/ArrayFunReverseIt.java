package com.company;

import java.util.Arrays;

public class ArrayFunReverseIt {
    public static void main(String[] args) {
        int[] initialArray = {1, 2, 3, 4, 5};

        int[] arrayCopy = new int[initialArray.length];

        for (int i = 0, a = initialArray.length - 1; i < initialArray.length; i++, a--) {
            arrayCopy[a] = initialArray[i];
        }

        System.out.println("Original array: " + Arrays.toString(initialArray));
        System.out.println("Reversed array: " + Arrays.toString(arrayCopy));
    }
}
