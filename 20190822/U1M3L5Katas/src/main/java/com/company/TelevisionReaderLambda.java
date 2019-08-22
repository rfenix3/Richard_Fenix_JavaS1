package com.company;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


public class TelevisionReaderLambda {

    public static void main(String[] args) {
        // Put try-catch at start of the code.
        try {
            ObjectMapper mapper = new ObjectMapper();

            List<Television> televisionList;

            // Reading of televisions.json file and storing in a list.
            televisionList = mapper.readValue(new File("televisions.json"), new TypeReference<List<Television>>(){});

            // Print the information for all Television that has screen size greater than 60 inches.
            int screenSize = 60;
            televisionList
                    .stream()
                    .filter(tv -> tv.getScreenSize() > screenSize)
                    .forEach(tv -> {
                        System.out.println("- - - - - - - - - ");
                        System.out.println("Brand: " + tv.getBrand());
                        System.out.println("Model: " + tv.getModel());
                        System.out.println("Price: " + tv.getPrice());
                        System.out.println("Screen Size: " + tv.getScreenSize());
                    });

            // Group our TVs by brand.
            Map<String, List<Television>> groupedTVs =
                    televisionList
                            .stream()
                            .collect(Collectors.groupingBy(b -> b.getBrand()));

            // grab all the keys and put into an array.
            Set<String> brands = groupedTVs.keySet();


            System.out.println("====== * BRANDS * ======");
            for(String brand : brands) {
                System.out.println(brand);
            }


            // Compute and display the average screen size of the TVs in inventory
            double avgScreenSize =
                    televisionList
                            .stream()
                            .mapToInt(b -> b.getScreenSize())
                            .average()
                            .getAsDouble();

            System.out.println("====== * Average Screen Size * ======");
            System.out.println("Average screen size is: " + avgScreenSize);

            // Find and display the largest screen.
            int largestScreen =
                    televisionList
                            .stream()
                            .mapToInt(b -> b.getScreenSize())
                            .max()
                            .getAsInt();

            System.out.println("====== * Largest Screen Size * ======");
            System.out.println("Largest screen: " + largestScreen);

        } catch (IOException e) {
            System.out.println("ERROR: Problem encountered reading JSON file - " + e.getMessage());
        }

    }




}
