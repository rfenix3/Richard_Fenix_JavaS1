package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class City {
    private String name;
    private long population;

    public City(String name, long population) {
        this.name = name;
        this.population = population;
    }

    // Define getters
    public String getName() {
        return name;
    }

    // Define getters
    public long getPopulation() {
        return population;
    }

    // Define toString to customize output
    public String toString()
    {
        return "[name=" + name + ", population=" + population + "]";
    }

    public static void main(String[] args) {
        Map<String, City> city = new HashMap<String, City>();

        City newYork = new City("New York", 8654321);
        City losAngeles = new City("Los Angeles",4563218);

        city.put("New York", newYork);
        city.put("Los Angeles", losAngeles);
        city.put("Chicago", new City("Chicago", 2716520));
        city.put("Denver", new City("Denver", 704621));
        city.put("Des Moines", new City("Des Moines", 217521));
        city.put("Atlanta", new City("Atlanta", 486213));

        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the city's minimum population you are looking for? ");
        long minPop = Integer.parseInt(scanner.nextLine());

//        Below code uses lambda medhod.
//        city.forEach((k, v) -> {
//            if (v.getPopulation() >= minPop){
//                System.out.println(k);
//            }
//        });

        ""

    }
}
