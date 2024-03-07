import java.util.Scanner;
import java.util.ArrayList;
public class BlackJack {

    private CardDeck deck;
    private ArrayList<Card> player;
    private ArrayList<Card> dealer;
    private Scanner kb;
    int playerValue, dealerValue;

    public BlackJack() {
        deck = new CardDeck();
        player = new ArrayList<>();
        dealer = new ArrayList<>();
        kb = new Scanner(System.in);

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
        addPlayerValues();
        System.out.println();
    }

    public void calculateAces() {
        int numAces = 0;
        playerValue = 0;
        for (int i = 0; i < player.size(); i++) {
            playerValue += player.get(i).getCardValue();
            if(player.get(i).getCardValue() == 11) {
                numAces += 1;
            }
        }

        while(playerValue > 21 && numAces > 0) {
            playerValue -= 10;
            numAces --;
        }

        int dealerAces = 0;
        dealerValue = 0;
        for(int i = 0; i < dealer.size(); i++) {
            dealerValue += dealer.get(i).getCardValue();
            if(dealer.get(i).getCardValue() == 11) {
                dealerAces += 1;
            }
        }

        while (numAces > 0 && dealerValue > 21) {
            dealerValue -= 10;
            dealerAces -= 1;
        }
    }

    public void printAll() {
        System.out.print("Dealer's Hand: ");
        for (int i = 0; i < dealer.toArray().length; i++) {
            System.out.print(dealer.get(i) + " ");
        }
        System.out.println();

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
        System.out.println();
    }


    boolean done = false;
    boolean lost = false;

    public void hitOrStand() {
        while(true) {
            System.out.println("Would you like to hit or stand?");
            String userInput = kb.nextLine().toLowerCase();
                if(userInput.equals("hit")) {
                player.add(deck.getCard());
                printPlayer();
                calculateAces();


                    if(playerValue > 21) {
                        System.out.println("You've lost");
                        lost = true;
                        break;
                    }

            } else if(userInput.equals("stand")) {
                    done = true;

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


    public void addPlayerValues() {
        playerValue = 0;
        for (int i = 0; i < player.size(); i++) {
            playerValue += player.get(i).getCardValue();
        }
        System.out.println("PLayer's total value = " + playerValue);
        System.out.println();
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
        System.out.println();

    }

    boolean dealerEndTurn = false;

    private void run() {
        while(true) {
            deck.shuffle();
            player.clear();
            dealer.clear();
            dealCards();

            if(playerValue != 21 && dealerValue != 21) {
                hitOrStand();
            }

            if(done) {
                calculateAces();
                while(dealerValue < 17) {
                    dealer.add(deck.getCard());
                    calculateAces();
                    printDealer();
                    printPlayer();
                    dealerEndTurn = true;
                }
                if (dealerEndTurn) {
                    checkResult();
                    dealerEndTurn = false;
                }
            } else {
                printPlayer();
                printDealer();
                addCardsValue();
                checkResult();
            }

            System.out.println("Would you like to play another round? (type 'yes' or 'no')");
            String userInput2 = kb.nextLine().toLowerCase();

            if(userInput2.equals("no")) {
                System.out.println("Thank you for playing!");
                break;
            }
        }
    }
}