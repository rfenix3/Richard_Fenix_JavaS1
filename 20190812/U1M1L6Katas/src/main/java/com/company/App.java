package com.company;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        int[] arr1 = {0,1,2,3,4,5,6,7};
        int[] arr2 = {0, -4, -3, -2, -5, -1,};
        int[] arr3 = {3, 2, 2};
        int[] arr4 = {4, 8};
        int[] arr5 = {-4, 6, 3, -5};

        App.lessThanFive(arr1);
        App.lessThanFive(arr2);
        App.lessThanFive(arr3);
        App.lessThanFive(arr4);

        App.splitAtFive(arr1);
        App.splitAtFive(arr2);
        App.splitAtFive(arr3);
        App.splitAtFive(arr4);

    }

    public static int total(int[] arr1) {
        int sum=0;
        for (int i=0; i< arr1.length; i++){
            sum = sum + arr1[i];
        }
        return sum;
    }

    public static int totalOdd(int[] arr) {
        int sum=0;
        for (int i=1; i< arr.length; i=i+2){
            sum = sum + arr[i];
        }
        return sum;
    }

    public static int totalEven(int[] arr) {
        int sum=0;
        for (int i=0; i< arr.length; i=i+2){
            sum = sum + arr[i];
        }
        return sum;
    }

    /*
    =========================================================================
    Paired programming with Allister Rooke on secondLargestNumber method.
    Hence, we may have similar code.
    =========================================================================
     */
    public static int secondLargestNumber(int[] arr){
        int largest = arr[0];
        int secondLargest = arr[1];

        if (largest < secondLargest) {
            int temp = largest;
            largest = secondLargest;
            secondLargest = temp;
        };

        // First find the largest number.
        for (int element: arr) {
            if (element > largest) {
                largest = element;
            };
        }

        // Ignore the largest to find the second largest number.
        for (int element: arr) {
            if (element != largest && element > secondLargest){
                    secondLargest = element;
            };
        }
        return secondLargest;
    }

    public static String[] swapFirstAndLast(String[] arr){
        int arrLength = arr.length;

        String moveToLast = arr[0];
        String moveToFirst = arr[arrLength - 1];

        arr[0] = moveToFirst;
        arr[arrLength - 1] = moveToLast;

        return arr;
    }

    /*
    =========================================================================
    Paired programming with Allister Rooke on reverse method.
    Hence, we may have very similar code.
    =========================================================================
    */

    public static int[] reverse(int[] arr){

        int arrayLength = arr.length;
        int[] tempArray = new int[arrayLength];

        // Create 2 variables. One for the index and the other for subtracting from the end of array.
        for (int i = 0, a = 1; i < arr.length; i++, a++){
            tempArray[i] = arr[arrayLength - a];
        }
        //System.out.println(Arrays.toString(tempArray));
        return tempArray;
    }

    public static String concatenateString(String[] stringArr) {
        String concatenated = "";
        for (int i = 0; i < stringArr.length; i++){
            concatenated = concatenated + stringArr[i];
        }
        return concatenated;
    }

    public static int[] everyThird(int[] arr){

        if (arr.length < 3) {
            return null;
        }
        int arrayLength = arr.length/3;
        int[] tempArray = new int[arrayLength];

        for (int i = 0, a = 2; i < arrayLength; i++, a = a + 3){
            tempArray[i] = arr[a];
        }
        //System.out.println(Arrays.toString(tempArray));
        return tempArray;
    }

    public static int[] lessThanFive(int[] arr) {

        int arrayLength = 0;

        // Test to get number of elements that is less than 5.
        for (int element: arr) {
            if (element < 5 ) {
                arrayLength++;
            }
        }

        // Return null if there are no element found that is less than 5.
        if (arrayLength == 0) {
            // Returning null instead of a null array is not the best practice.
            // However, to satisfy the test program, I need to return null in this method.
            // The better way is creating an empty array and returning that array like the following code.
            //            int[] nullArray = {};
            //            return nullArray;
            return null;
        }

        // Create array based on the number of elements found that is less than 5.
        int[] lessThanFiveArray = new int[arrayLength];
        int index = 0;

        // Insert element that is less than five to lessThanFiveArray array.
        for (int element: arr) {
            if (element < 5 ) {
                lessThanFiveArray[index] = element;
                index++;
            }
        }
        System.out.println("lessThanFive method sample output: " + Arrays.toString(lessThanFiveArray));

        // Return created array.
        return lessThanFiveArray;
    }

    public static int[][] splitAtFive(int[] arr) {

        // Call the static method lessThanFive() and assign it to lessThanFiveArray array.
        int[] lessThanFiveArray = splitLessThanFive(arr);

        // Call the static method lessThanFive() and assign it to lessThanFiveArray array.
        int[] fiveOrGreaterArray = splitFiveOrGreater(arr);

        // Declare multidimensional array and assign the arrays.
        int[][] multiArray = {lessThanFiveArray, fiveOrGreaterArray};

        System.out.println("splitAtFive method sample output: " + Arrays.deepToString(multiArray));

        return multiArray;

    }

    // This method (splitLessThanFive) is created for splitAtFive static method.
    public static int[] splitLessThanFive(int[] arr) {

        int arrayLength = 0;

        // Test to get number of elements that is less than 5.
        for (int element: arr) {
            if (element < 5 ) {
                arrayLength++;
            }
        }

        // Return null if there are no element found that is less than 5.
        if (arrayLength == 0) {
            //create an empty or null array to return.
            int[] nullArray = {};
            return nullArray;
        }

        // Create array based on the number of elements found that is less than 5.
        int[] lessThanFiveArray = new int[arrayLength];
        int index = 0;

        // Insert element that is less than five to lessThanFiveArray array.
        for (int element: arr) {
            if (element < 5 ) {
                lessThanFiveArray[index] = element;
                index++;
            }
        }

        // Return created array.
        return lessThanFiveArray;
    }

    // This method (splitFiveOrGreater) is created for splitAtFive static method.
    public static int[] splitFiveOrGreater(int[] arr) {

        int arrayLength = 0;

        // Test to get number of elements that is GREATER THAN or EQUAL TO 5.
        for (int element: arr) {
            if (element >= 5 ) {
                arrayLength++;
            }
        }

        // Return null if there are no element found.
        if (arrayLength == 0) {
            int[] nullArray = {};
            return nullArray;
        }

        // Create array based on the number of elements found.
        int[] fiveOrGreaterArray = new int[arrayLength];
        int index = 0;

        // Insert element that is less than five to lessThanFiveArray array.
        for (int element: arr) {
            if (element >= 5 ) {
                fiveOrGreaterArray[index] = element;
                index++;
            }
        }

        // Return created array.
        return fiveOrGreaterArray;
    }

}
