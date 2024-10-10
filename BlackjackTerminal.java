import java.util.Scanner;

// import Dealer;
// import Deck;
// import Player;

public class BlackjackTerminal {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        boolean keepPlaying = true;

        while (keepPlaying) {
            Deck deck = new Deck();
            deck.shuffle();

            Player player = new Player();
            Dealer dealer = new Dealer();

            player.hit(deck);
            player.hit(deck);
            dealer.hit(deck);
            dealer.hit(deck);

            boolean playerTurn = true;
            while (playerTurn) {
                System.out.println(
                        "Your hand: " + player.getHand().getCards() + " (Value: " + player.getHandValue() + ")");
                System.out.println("Dealer's hand: " + dealer.getUpCard() + " and [Hidden]");
                System.out.print("Hit or stand? (h/s): ");
                String input = scanner.nextLine().trim().toLowerCase();

                if (input.equals("h")) {
                    player.hit(deck);
                    if (player.isBust()) {
                        System.out.println("Your final hand: " + player.getHand().getCards() + " (Value: "
                                + player.getHandValue() + ")");
                        System.out.println("Bust! You lose.");
                        playerTurn = false;
                    }
                } else if (input.equals("s")) {
                    playerTurn = false;
                } else {
                    System.out.println("Invalid input. Please enter 'h' to hit or 's' to stand.");
                }
            }

            if (!player.isBust()) {
                while (dealer.getHandValue() < 17) {
                    dealer.hit(deck);
                }
            }

            String dealerHand = dealer.getHand().getCards() + " (Value: " + dealer.getHandValue() + ")";
            System.out.println("Dealer's hand: " + dealerHand);

            if (dealer.isBust()) {
                System.out.println("Dealer busts! You win.");
            } else {
                int playerValue = player.getHandValue();
                int dealerValue = dealer.getHandValue();
                if (playerValue > dealerValue) {
                    System.out.println("You win!");
                } else if (playerValue < dealerValue) {
                    System.out.println("Dealer wins.");
                    System.out.println("Dealer's final hand: " + dealer.getHand().getCards() + " (Value: "
                            + dealer.getHandValue() + ")");
                } else {
                    System.out.println("Push.");
                }
            }

            if (deck.isEmpty()) {
                System.out.println("The deck is empty. The game will now end.");
                keepPlaying = false;
            } else {
                System.out.print("Do you want to play another round? (y/n): ");
                String response = scanner.nextLine().trim().toLowerCase();
                if (response.equals("y")) {
                    keepPlaying = true;
                } else if (response.equals("n")) {
                    keepPlaying = false;
                } else {
                    System.out.println("Invalid Input. Exitting the game.");
                    keepPlaying = false;
                }
            }
        }
        scanner.close();
    }
}
