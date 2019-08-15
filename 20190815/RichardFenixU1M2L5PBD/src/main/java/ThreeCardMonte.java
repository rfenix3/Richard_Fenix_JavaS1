import java.util.Random;
import java.util.Scanner;

public class ThreeCardMonte {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int ace = random.nextInt(3) + 1;
        System.out.println("The card is in " + ace);

        System.out.println("You slide up to Fast Eddie's card table and plop down your cash.");
        System.out.println("He glances at you out of the corner of his eye and starts shuffling.");
        System.out.println("He lays down three cards.\n");
        System.out.println("Which one is the ace?\n");
        System.out.println("        ##  ##  ##");
        System.out.println("        ##  ##  ##");
        System.out.println("        1   2   3\n");
        System.out.print("> ");

        int userGuess = scanner.nextInt();

        // Extra space.
        System.out.println("");

        if (userGuess == ace) {
            System.out.println("You nailed it! Fast Eddie reluctantly hands over your winnings, scowling.");
        } else {
            System.out.printf("Ha! Fast Eddie wins again! The ace was card number %d.\n", ace);
        }

        switch (ace) {
            case 1:
                System.out.println("        AA  ##  ##");
                System.out.println("        AA  ##  ##");
                System.out.println("        1   2   3\n");
                break;
            case 2:
                System.out.println("        ##  AA  ##");
                System.out.println("        ##  AA  ##");
                System.out.println("        1   2   3\n");
                break;
            case 3:
                System.out.println("        ##  ##  AA");
                System.out.println("        ##  ##  AA");
                System.out.println("        1   2   3\n");
                break;
            default:
                System.out.println("System error out of bound.");
        }
    }
}
