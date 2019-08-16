import java.util.Random;

public class BabyBlackjack {
    public static void main(String[] args) {
        System.out.println("Baby Blackjack!\n");

        Random random = new Random();

        int playerCard1 = random.nextInt(10) + 1;
        int playerCard2 = random.nextInt(10) + 1;

        int playerTotal = playerCard1 + playerCard2;

        System.out.printf("You drew %d and %d.\n", playerCard1, playerCard2);
        System.out.printf("Your total is %d.\n", playerTotal);

        int dealerCard1 = random.nextInt(10) + 1;
        int dealerCard2 = random.nextInt(10) + 1;

        int dealerTotal = dealerCard1 + dealerCard2;

        System.out.printf("\nThe dealer has %d and %d.\n", dealerCard1, dealerCard2);
        System.out.printf("Dealer's total is %d.\n", dealerTotal);

        if (dealerTotal > playerTotal) {
            System.out.println("\nYou lose!");
        } else {
            System.out.println("\nYOU WIN!");
        }

    }
}
