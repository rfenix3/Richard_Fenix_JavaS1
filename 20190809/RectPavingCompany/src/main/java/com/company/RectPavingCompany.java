package com.company;
import java.util.Scanner;

public class RectPavingCompany {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("What is the width of the driveway in feet? ");
        int width = Integer.parseInt(scan.nextLine());

        System.out.print("What is the length of the driveway in feet? ");
        int length = Integer.parseInt(scan.nextLine());

        float cementCost = 0.0f;
        float framingCost = 0.0f;

        System.out.print("What is the cost of cement per square foot? ");
        cementCost = Float.parseFloat(scan.nextLine());

        System.out.print("What is the cost of framing/footers per linear foot? ");
//        cementCost = Float.parseFloat(scan.nextLine());
        framingCost = Float.parseFloat(scan.nextLine());

        int area = length * width;
//        int perimeter = 2*length - 2*width;
        int perimeter = 2*length + 2*width;

        System.out.format("The area of the driveway is %d square feet.%n", area);
        System.out.format("The perimeter of the driveway is %d square feet.%n", perimeter);

        System.out.format("The cost of the cement is %f.%n", area*cementCost);
//        System.out.format("The cost of the framing/footers is %f.%n", perimeter+framingCost);
        System.out.format("The cost of the framing/footers is %f.%n", perimeter*framingCost);
    }
}
