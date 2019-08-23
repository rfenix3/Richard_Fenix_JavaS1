package com.company;

import java.util.List;
import java.util.Scanner;

public class App {
    public static Scanner scanner  = new Scanner(System.in);

    public static void main(String[] args) {

        int userChoice = 0;
        int deleteId = 0;
        seedCarList();

        do {
            userChoice = displayMainMenu();
            switch(userChoice) {
                case 1:
                    System.out.println("Adding a car...");
                    addCarToInventory();
                    break;
                case 2:
                    displayCarInventory();
                    deletePrompt();
                    //deleteId = deletePrompt();
                    //deleteCar(deleteId);
                    System.out.println("Deleting a car...");
                    break;
                case 3:
                    System.out.println("Listing car...");
                    displayCarInventory();
                    break;
                case 4:
                    System.out.println("Searching inventory...");
                    int searchOption = displaySearchOption();
                    //searchSubOptions(searchOption)
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Input not valid.");
                    continue;
            }
        } while (userChoice != 0);
    }

    public static void seedCarList(){
        Car rav4 = new Car("Toyota", "rav4", "2019", "silver", 12);
        Car camry = new Car("Toyota", "camry", "2019", "silver", 12);
        Car corolla = new Car("Toyota", "corolla", "2019", "silver", 4_000);
        Car altima = new Car("Nissan", "altima", "2015", "black", 90_000);
        Car crv = new Car("Honda", "crv", "2017", "blue", 12_345);

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
        Car.getCarList().get(carId - 1);
        Car.getCarList().remove(carId - 1);
    }

//    public static void deleteCar(int userSelection){
//
//    }

    public static int displaySearchOption(){
        System.out.println("=========== Search ===========");
        System.out.println("    Here are your options:");
        System.out.println("       1. by MAKE");
        System.out.println("       2. by MODEL");
        System.out.println("       3. by YEAR");
        System.out.println("       4. by COLOR");
        System.out.println("       5. by MILEAGE");
        System.out.println("       0. Exit Program");
        System.out.println("=====================================");
        System.out.print("    Enter your choice: ");

        int userChoice = Integer.parseInt(scanner.nextLine());

        return userChoice;

    }

}
