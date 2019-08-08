package com.company;

public class App {
    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int subtractOrZero(int a, int b) {
        if (b > a) {
            return 0;
        } else {
            return a - b;
        }
    }


    public static int max(int a, int b, int c) {
        int largest = a;
        if (b > a && b > c) {
            largest = b;
        } else if (c > a && c > b) {
            largest = c;
        }
        return largest;
    }

    public static int min(int a, int b, int c) {
        int smallest = a;
        if (b < a && b < c) {
            smallest = b;
        } else if (c < a && c < b) {
            smallest = c;
        }
        return smallest;
    }

    public static boolean isLarger(int a, int b) {
        if (a > b ) {
            return true;
        } else {
            return false;
        }
    }

}
