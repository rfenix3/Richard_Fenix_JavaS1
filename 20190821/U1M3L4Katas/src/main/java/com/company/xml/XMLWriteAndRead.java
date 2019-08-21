package com.company.xml;

import com.company.Car;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class XMLWriteAndRead {

    public static void main(String[] args) {

        PrintWriter writer = null;

        // Create Car ArrayList
        List<Car> carList = new ArrayList<>();

        carList.add(new Car(2012, "Toyota", "Camry", "Blue"));
        carList.add(new Car(2001, "Honda", "Civic", "Silver"));
        carList.add(new Car(2009, "Jeep", "Wrangler", "Rust"));
        carList.add(new Car(2018, "Tesla", "Roadster", "Black"));
        carList.add(new Car(1964, "Ford", "Mustang", "Red"));

        try {
            ObjectMapper mapper = new XmlMapper();
            String xmlCarList = mapper.writeValueAsString(carList);

            /* Uncomment this block to see the value of xmlCarList (in computer's memory).
            System.out.println(xmlCarList);
             */

            // Open a file
            writer = new PrintWriter(new FileWriter("cars.xml"));

            // Write xmlCarList value to file
            writer.println(xmlCarList);


        } catch (JsonProcessingException e) {
            System.out.println("ERROR: Trouble converting object to XML string: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("ERROR: Could not write to file: " + e.getMessage());
        } finally {
            if (writer != null) {
                writer.flush();
                writer.close();
            }
        }

        try {
            ObjectMapper mapper = new XmlMapper();

            // Creating a List
            List<Car> carList1;

            // Getting xml values from file into a list.
            carList1 = mapper.readValue(new File("cars.xml"), new TypeReference<List<Car>>(){});

            for (Car car : carList1) {
                System.out.println("=================================");
                System.out.println(car.getYear());
                System.out.println(car.getMake());
                System.out.println(car.getModel());
                System.out.println(car.getColor());
            }

        } catch (IOException e) {
            System.out.println("ERROR: Problem encountered reading XML file - " + e.getMessage());
        }

    }

}
