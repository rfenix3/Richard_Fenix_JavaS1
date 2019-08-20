package com.company;

import java.util.HashSet;
import java.util.Iterator;

public class SetIterator {
    public static void printSet(int n1, int n2, int n3, int n4, int n5) {

        HashSet<Integer> numbers = new HashSet<Integer>();
        numbers.add(n1);
        numbers.add(n2);
        numbers.add(n3);
        numbers.add(n4);
        numbers.add(n5);

        /*
         Since Set interface or HashSet class doesn't provide a get() method to
         retrieve elements, the only way to take out elements from a Set is to
         iterate over it by using Iterator, or loop over
        */
        Iterator<Integer> iter = numbers.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }

    }

//    public static void main(String[] args) {
//        printSet(1,2,3,4,5);
//    }
}
