import java.util.Scanner;

public class SafeSquareRoot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("SQUARE ROOT!");
        System.out.print("Enter a number: ");
        int userNumber = scanner.nextInt();

        while (userNumber < 0) {
            System.out.println("You can't take the square root of a negative number, silly.");
            System.out.print("Try again: ");
            userNumber = scanner.nextInt();
        }

        double userNumberSqrt = Math.sqrt(userNumber);
        System.out.printf("The square root of %d is %f.", userNumber, userNumberSqrt);
    }
}
