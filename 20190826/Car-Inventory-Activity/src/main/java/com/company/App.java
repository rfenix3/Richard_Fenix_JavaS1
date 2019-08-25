package com.company;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;
import java.util.List;
import java.util.Scanner;


public class App {
    public static Scanner scanner  = new Scanner(System.in);

    public static void main(String[] args) {

        int userChoice = 0;

        // Uncomment below code (seedCarList()) is there is no csv file available.
        //seedCarList();

        // Function to load CSV file into a Car List.
        loadCSV();

        do {
            userChoice = displayMainMenu();
            switch(userChoice) {
                case 1:
                    System.out.println("Adding a car...");
                    addCarToInventory();
                    save();
                    break;
                case 2:
                    displayCarInventory();
                    deletePrompt();
                    System.out.println("Deleting a car...");
                    save();
                    break;
                case 3:
                    System.out.println("Listing car...");
                    displayCarInventory();
                    break;
                case 4:
                    System.out.println("Searching inventory...");
                    int searchChoice = displaySearchOption();
                    searchSubOption(searchChoice);
                    break;
                case 0:
                    System.out.println("\n *** Thank you for using my application. Have a great day! ***");
                    break;
                default:
                    System.out.println("Input not valid.");
                    continue;
            }
        } while (userChoice != 0);
    }

    // This method can be ran for seeding a Car List if there is no csv file available.
    public static void seedCarList(){
        Car rav4 = new Car("Toyota", "rav4", "2019", "silver", 12);
        Car camry = new Car("Toyota", "camry", "2019", "silver", 12);
        Car corolla = new Car("Toyota", "corolla", "2019", "silver", 4_000);
        Car altima = new Car("Nissan", "altima", "2015", "black", 90_000);
        Car crv = new Car("Honda", "crv", "2017", "blue", 12_345);

        save();

        displayCarInventory();

    }

    public static void loadCSV(){
        try {
            Car.setCarList(
                    new CsvToBeanBuilder<Car>(new FileReader("carSeed.csv")).withType(Car.class).build().parse()
            );

            // Uncomment below code if you want to display car list in memory.
            // displayCarInventory();

        } catch (FileNotFoundException e) {
            System.out.println("Could not find CSV file: " + e.getMessage());
        }
    }

    public static void save(){
        try {
            for (Car car : Car.getCarList()) {
                // Now let's write the car list to a file for persistence.
                Writer writer = new FileWriter("carSeed.csv");
                StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).build();
                beanToCsv.write(Car.getCarList());
                writer.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not find CSV file: " + e.getMessage());
        } catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
            System.out.println("ERROR: Something went wrong writing your CSV file: " + e.getMessage());
        }
    }


    public static void displayCarInventory(){
        // Get carList from Car parent class which holds all cars that has been created.
        List<Car> carList = Car.getCarList();
        System.out.println("| ID |   Make  |   Model  |  Year  | Color 3 |  Odometer  |");

        carList
            .stream()
            .forEach(car -> {
                System.out.printf(" %d :  %s  :  %s  :  %s  :  %s  :  %d \n",
                        car.getId(), car.getMake(), car.getModel(), car.getYear(), car.getColor(), car.getOdometer());
            });
    }

    public static int displayMainMenu() {
        System.out.println("=========== Rich's Car Dealership Program ===========");
        System.out.println("    Here are your choices:");
        System.out.println("       1. Add a Car");
        System.out.println("       2. Delete a Car");
        System.out.println("       3. List All Available Cars");
        System.out.println("       4. Search Inventory");
        System.out.println("       0. Exit Program");
        System.out.println("=====================================================");
        System.out.print("    Enter your choice: ");

        int userChoice = Integer.parseInt(scanner.nextLine());

        return userChoice;
    }

    public static void addCarToInventory(){
        System.out.print("Please enter the Make: ");
        String make = scanner.nextLine();
        System.out.print("Enter the Model: ");
        String model = scanner.nextLine();
        System.out.print("Enter the Year: ");
        String year = scanner.nextLine();
        System.out.print("Enter the Color: ");
        String color = scanner.nextLine();
        System.out.print("Enter the Odometer Reading: ");
        int odometer = Integer.parseInt(scanner.nextLine());

        Car newCar = new Car(make, model, year, color, odometer);
        System.out.println(newCar + " created.");
    }

    public static void deletePrompt(){
        System.out.print("Enter ID to delete: ");
        int carId = Integer.parseInt(scanner.nextLine());

        int carIdIndex;
        Car carObj = new Car();
        // Use enhanced for loop to find the element based on ID
        for (Car car: Car.getCarList()) {
            if (car.getId() == carId) {
                carObj = car;
            }
        }
        // Get the index of the car object to be deleted.
        carIdIndex = Car.getCarList().indexOf(carObj);

        //Remove the car object from the Car list.
        Car.getCarList().remove(carIdIndex);
    }


    public static int displaySearchOption(){
        System.out.println("====== *** Search Inventory *** =========");
        System.out.println("    Here are your options:");
        System.out.println("       1. by MAKE");
        System.out.println("       2. by MODEL");
        System.out.println("       3. by YEAR");
        System.out.println("       4. by COLOR");
        System.out.println("       5. by MILEAGE");
        System.out.println("       0. Return to Main Menu");
        System.out.println("-----------------------------------------");
        System.out.print("    Enter your choice: ");

        int userChoice = Integer.parseInt(scanner.nextLine());

        return userChoice;
    }

    public static void searchSubOption(int userChoice){
        String userInput;
        do {
            switch (userChoice) {
                case 1:
                    System.out.print("Enter the Make: ");
                    userInput = scanner.nextLine();
                    userChoice = displayGroup("make", userInput);
                    break;
                case 2:
                    System.out.print("Enter the Model: ");
                    userInput = scanner.nextLine();
                    userChoice = displayGroup("model", userInput);
                    break;
                case 3:
                    System.out.print("Enter the Year: ");
                    userInput = scanner.nextLine();
                    userChoice = displayGroup("year", userInput);
                    break;
                case 4:
                    System.out.print("Enter the color: ");
                    userInput = scanner.nextLine();
                    userChoice = displayGroup("color", userInput);
                    break;
                case 5:
                    System.out.print("Enter miles less than: ");
                    userInput = scanner.nextLine();
                    userChoice = displayGroup("miles", userInput);
                    break;
                case 0:
                    System.out.println("Return to Main Menu Options...");
                    break;
                default:
                    System.out.println("Input not valid.");
                    continue;
            }
        } while (userChoice != 0);

    }

    public static int displayGroup(String subGroup, String criteria) {
        System.out.println("All " + criteria + " cars in inventory: ");
        switch (subGroup) {
            case "make":
                Car.getCarList()
                        .stream()
                        .filter(b -> b.getMake().equals(criteria))
                        .forEach(car -> {
                            System.out.println("===============");
                            System.out.println("Make: " + car.getMake());
                            System.out.println("Model: " + car.getModel());
                            System.out.println("Year: " + car.getYear());
                            System.out.println("Color: " + car.getColor());
                            System.out.println("Odometer: " + car.getOdometer());
                        });
                break;
            case "model":
                Car.getCarList()
                        .stream()
                        .filter(b -> b.getModel().equals(criteria))
                        .forEach(car -> {
                            System.out.println("===============");
                            System.out.println("Make: " + car.getMake());
                            System.out.println("Model: " + car.getModel());
                            System.out.println("Year: " + car.getYear());
                            System.out.println("Color: " + car.getColor());
                            System.out.println("Odometer: " + car.getOdometer());
                        });
                break;
            case "year":
                Car.getCarList()
                        .stream()
                        .filter(b -> b.getYear().equals(criteria))
                        .forEach(car -> {
                            System.out.println("===============");
                            System.out.println("Make: " + car.getMake());
                            System.out.println("Model: " + car.getModel());
                            System.out.println("Year: " + car.getYear());
                            System.out.println("Color: " + car.getColor());
                            System.out.println("Odometer: " + car.getOdometer());
                        });
                break;
            case "color":
                Car.getCarList()
                        .stream()
                        .filter(b -> b.getColor().equals(criteria))
                        .forEach(car -> {
                            System.out.println("===============");
                            System.out.println("Make: " + car.getMake());
                            System.out.println("Model: " + car.getModel());
                            System.out.println("Year: " + car.getYear());
                            System.out.println("Color: " + car.getColor());
                            System.out.println("Odometer: " + car.getOdometer());
                        });
                break;
            case "miles":
                int intCriteria = Integer.parseInt(criteria);
                Car.getCarList()
                        .stream()
                        .filter(b -> b.getOdometer() < intCriteria)
                        .forEach(car -> {
                            System.out.println("===============");
                            System.out.println("Make: " + car.getMake());
                            System.out.println("Model: " + car.getModel());
                            System.out.println("Year: " + car.getYear());
                            System.out.println("Color: " + car.getColor());
                            System.out.println("Odometer: " + car.getOdometer());
                        });
                break;

            default:
                System.out.println("none found...");
        }

        System.out.println("Press ENTER to return to Main Menu....");
        scanner.nextLine();
        return 0;
    }

}
