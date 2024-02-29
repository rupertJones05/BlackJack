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
        System.out.println("Dealer's Hand: " + dealer.getFirst() + " ?");
        printPlayer();
        addCardsValue();
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

    boolean runAgain = false;;
                             
    public void hitOrStand() {
        Scanner kb = new Scanner(System.in);

        while(true) {
            System.out.println("Would you like to hit or stand?");
            String userInput = kb.nextLine().toLowerCase();

            if(userInput.equals("hit")) {
                player.add(deck.getCard());
                printAll();
                addCardsValue();

                if(playerValue > 21) {
                    System.out.println("You've Lost!");
                    break;
                }
            } else if(userInput.equals("stand")) {
                break;
            } else {
                System.out.println("Please enter a valid input of 'hit' or 'stand'.");
            }
        }  
    }

    public void checkResult() {
        if(playerValue > 21) {
            System.out.println("You've lost");
        } else if(dealerValue > 21) {
            System.out.println("You've won");
        } else if(playerValue > dealerValue) {
            System.out.println("You've won");
        } else if(dealerValue > playerValue) {
            System.out.println("You've lost");
        } else {
            System.out.println("You've both drawn");
        }
    }
        
            

    public void addCardsValue() {
        dealerValue = 0;
        int numberOfAces = 0;
        for (int i = 0; i < dealer.size(); i++) {
            dealerValue += dealer.get(i).getCardValue();

            if(dealer.get(i).equals("A")){
                numberOfAces++;
            }
        }
        
        while(numberOfAces > 0 && dealerValue > 21) {
            dealerValue -= 10;
            numberOfAces--;
        }
        
        System.out.println("Dealer's total value = " + dealerValue);
        

        playerValue = 0;
        for (int i = 0; i < player.size(); i++) {
            playerValue += player.get(i).getCardValue();
            if(player.get(i).equals("A")){
                numberOfAces++;
            }
        }
        
        while(numberOfAces > 0 && playerValue > 21) {
            playerValue -= 10;
            numberOfAces--;
        }
        System.out.println("Player's total value = " + playerValue);

    }

    private void run() {
        while(true) { 
            deck.shuffle();
            player.clear();
            dealer.clear();
            
            dealCards();
            
            hitOrStand();

            while(dealerValue < 17) {
                dealer.add(deck.getCard());
                addCardsValue();
            }
            printAll():
            checkResult();

            System.out.println("Would you like to play another round? (type 'yes' or 'no')");
            String userInput2 = kb.nextLine().toLowerCase();
            
            if(userInput2.equals("no") {
                System.out.println("Thank you for playing!");
                break;
            }
        }
    }
}
