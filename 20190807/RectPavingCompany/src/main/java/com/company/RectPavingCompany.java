package com.company;

import java.util.*;

public class RectPavingCompany {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter width of the driveway (in feet): ");
        double width = scanner.nextDouble();

        System.out.print("Enter length of the driveway (in feet): ");
        double length = scanner.nextDouble();

        double area = length * width;
        double perimeter = 2 * (length + width);

        System.out.println("Total driveway area is: " + area + " sq ft.");
        System.out.println("The perimeter of the driveway is " + perimeter + " ft.");

        System.out.println("Enter cost of cement: ");
        double cement = scanner.nextDouble();
        //double cement = 12.50;

        System.out.println("Enter cost of framing/footers: ");
        double framing = scanner.nextDouble();
        //double framing = 8.25;

        System.out.format("Total cost of cement is %.2f.\n", area * cement);
        System.out.format("Total cost of framing/footer is %.2f.", perimeter * framing);



    }
}
