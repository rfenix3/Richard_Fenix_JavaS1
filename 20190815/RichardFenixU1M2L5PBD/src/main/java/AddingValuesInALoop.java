import java.util.Scanner;

public class AddingValuesInALoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("I will add up the numbers you give me until you enter a 0.");
        int userNumber = 0;
        int total = 0;

        System.out.print("Number: ");
        userNumber = scanner.nextInt();
        total += userNumber;

        if (userNumber != 0) {
            System.out.println("The total so far is " + total);
        } else {
            System.out.println("\nThe total is " + total);
        }

        while (userNumber != 0){
            System.out.print("Number: ");
            userNumber = scanner.nextInt();
            total += userNumber;
            if (userNumber != 0) {
                System.out.println("The total so far is " + total);
            } else {
                System.out.println("\nThe total is " + total);
            }
        };

    }
}
