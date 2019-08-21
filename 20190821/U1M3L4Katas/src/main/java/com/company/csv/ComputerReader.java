package com.company.csv;

import com.company.Computer;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class ComputerReader {
    public static void main(String[] args) {
        try {
            // We read from CSV file and put the values in a list collection.
            List<Computer> computerListFromCSV =
                    new CsvToBeanBuilder<Computer>(new FileReader("computers.csv")).withType(Computer.class).build().parse();

            for (Computer computer : computerListFromCSV) {
                System.out.println("=================================");
                System.out.println(computer.getBrand());
                System.out.println(computer.getModel());
                System.out.println(computer.getCpu());
                System.out.println(computer.getRam());
                System.out.println(computer.getStorageSize());
            }

        } catch (FileNotFoundException e) {
            System.out.println("Could not find CSV file: " + e.getMessage());
        }
    }



}
