import java.util.Random;

public class ShorterDoubleDice {
    public static void main(String[] args) {
        Random random = new Random();
        int dice1 = 0;
        int dice2 = 0;
        int diceTotal = 0;
        System.out.println("HERE COMES THE DICE!");

        // Execute do/while loop as instructed and to ensure the loop runs the block of code at least once.
        do {
            dice1 = random.nextInt(6) + 1;
            dice2 = random.nextInt(6) + 1;
            diceTotal = dice1 + dice2;

            System.out.println("");
            System.out.printf("Roll #1: %d \n", dice1);
            System.out.printf("Roll #2: %d \n", dice2);
            System.out.printf("Total is %d!\n", diceTotal);
        }
        while (diceTotal != 7);
    }
}
