import java.util.Scanner;
import java.sql.Array;
import java.util.ArrayList;
public class BlackJack {

    private CardDeck deck;
    private ArrayList<Card> player;
    private ArrayList<Card> dealer;

    int playerValue, dealerValue;

    public BlackJack() {
        deck = new CardDeck();
        player = new ArrayList<>();
        dealer = new ArrayList<>();
        Scanner kb = new Scanner(System.in);

    }
    public static void main(String[] args) {
        BlackJack game = new BlackJack();

        game.run();
    }

    public void dealCards() {
        player.add(deck.getCard());
        dealer.add(deck.getCard());
        player.add(deck.getCard());
        dealer.add(deck.getCard());
        printAll();
        System.out.println();
    }

    public void printAll() {
        System.out.print("Dealer's Hand: ");
        for (int i = 0; i < dealer.toArray().length; i++) {
            System.out.print(dealer.get(i) + " ");
        }
        System.out.println("");

        System.out.print("Player's Hand: ");
        for (int i = 0; i < player.toArray().length; i++) {
            System.out.print(player.get(i) + " ");
        }
        System.out.println("");
    }

    public void printDealer() {
        System.out.print("Dealer's Hand: ");
        for (int i = 0; i < dealer.toArray().length; i++) {
            System.out.print(dealer.get(i) + " ");
        }
        System.out.println("");
    }

    public void printPlayer() {
        System.out.print("Player's Hand: ");
        for (int i = 0; i < player.toArray().length; i++) {
            System.out.print(player.get(i) + " ");
        }
        System.out.println("");
    }

    public void hitOrStand() {
        Scanner kb = new Scanner(System.in);
        System.out.println("Would you like to hit or stand?");

        if((kb.nextLine().equals("hit"))) {
            player.add(deck.getCard());
            printAll();
            addCardsValue();
        }


    }

    public void checkValue() {
        if(playerValue > 21) {
            ""
        }
    }

    public void addCardsValue() {
        dealerValue = 0;
        for (int i = 0; i < dealer.size(); i++) {
            dealerValue += dealer.get(i).getCardValue();
        }
        System.out.println("Dealer's total value = " + dealerValue);

        playerValue = 0;
        for (int i = 0; i < player.size(); i++) {
            playerValue += player.get(i).getCardValue();
        }
        System.out.println("Player's total value = " + playerValue);

    }

    private void run() {
        deck.shuffle();
        dealCards();
        hitOrStand();
    }
}
