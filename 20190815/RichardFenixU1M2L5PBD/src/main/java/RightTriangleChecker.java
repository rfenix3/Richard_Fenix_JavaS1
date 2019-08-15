import java.util.Scanner;

public class RightTriangleChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ENTER three integers:");
        int side1, side2, side3 = 0;

        System.out.print("Side 1: ");
        side1 = scanner.nextInt();

        do {
            System.out.print("Side 2: ");
            side2 = scanner.nextInt();

            if (side1 > side2) {
                System.out.println(side2 + " is smaller than " + side1 + ". Try again.");
            }
        }
        while (side1 > side2);

        do {
            System.out.print("Side 3: ");
            side3 = scanner.nextInt();

            if (side2 > side3) {
                System.out.println(side3 + " is smaller than " + side2 + ". Try again.");
            }
        }
        while (side2 > side3);

        System.out.println("Your three sides are "+ side1 + " " + side2 + " " + side3);

        // User Math.pow to square the sides and check using Pythagorean triangle equation.
        if (Math.pow(side1, 2) + Math.pow(side2, 2) == Math.pow(side3, 2)) {
            System.out.println("These sides *do* make a right triangle.  Yippy-skippy!");
        } else {
            System.out.println("NO! These sides to not make a right triangle!");
        }

    }
}
