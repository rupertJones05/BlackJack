//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Card {
    private int suit;
    private int cardValue;

    Card(int suit, int cardValue) {
        this.suit = suit;
        this.cardValue = cardValue;
    }

    public void setCardValue(int cardValue) {
        this.cardValue = cardValue;
    }

    public int getSuit() {
        return suit;
    }

    public int getCardValue() {
        if (cardValue < 11) {
            return cardValue;
        }
        else if (cardValue  == 14) {
            return 11;
        }
        else {
            return 10;
        }

    }

    public String toString() {
        String[] suits = {"♥", "♦", "♣", "♠"};
        String[] values = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
        return values[this.cardValue - 2] + " of " + suits[this.suit];
    }

}