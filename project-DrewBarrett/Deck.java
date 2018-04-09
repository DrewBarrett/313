/**
 * Deck
 */
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> deck;
    private ArrayList<Card> seen;
    private ArrayList<Card> remaining;
    
    public Deck() {
        deck = new ArrayList();
        seen = new ArrayList();
        remaining = new ArrayList();
        for (int i = 0; i < 4; i++) {
            String suite = "ERROR";
            switch (i) {
                case 0:
                    suite = "D";
                    break;
                case 1:
                    suite = "H";
                    break;
                case 2:
                    suite = "C";
                    break;
                case 3:
                    suite = "S";
                default:
                    break;
            }

            for (int j = 1; j <= 13; j++) {
                String value;
                if (j < 10) {
                    value = String.valueOf(j);
                } else if (j == 10) {
                    value = "T";
                } else if (j == 11) {
                    value = "J";
                } else if (j == 12) {
                    value = "Q";
                } else {
                    value = "K";
                }
                Card c = new Card(suite, value);
                deck.add(c);
                remaining.add(c);
            }
        }
        Collections.shuffle(deck);
    }

    public boolean isEmpty() {
        return remaining.size() == 0;
    }

    public void print() {
        int pos = 0;
        for (Card card : deck) {
            if (pos == 13) {
                pos = 0;
                System.out.println();
            }
            System.out.print(card.toString());
            pos++;
        }
        System.out.println();
    }

    // Select 2 cards
    public boolean getTwo(boolean smart) {

        // PART 1
        // Select 2 cards
        Card c1 = selectRandom();
        Card c2;
        do {
            c2 = selectRandom();
        } while (c2 == c1);

        if (smart) {
            for (Card card : seen) {
                if (c1 != card && card.isMatch(c1)) {
                    c2 = card;
                    break;
                }
            }
        }
        // PART 2
        // Flip the cards
        c1.flip();
        c2.flip();
        if (!seen.contains(c1)) {
            seen.add(c1);
        }
        if (!seen.contains(c2)) {
            seen.add(c2);
        }

        print();
        if (c1.isMatch(c2)) {
            System.out.println("Congrats! You matched the cards " + c1 + " and " + c2 + "!");
            c1.match();
            c2.match();
            remaining.remove(c1);
            seen.remove(c1);
            remaining.remove(c2);
            seen.remove(c2);
            return true;
        }
        else {
            System.out.println("Not a match.");
            c1.flip();
            c2.flip();
            return false;
        }
    }


    private Card selectRandom() {
        int index = (int) (Math.random() * remaining.size());
        Card c = remaining.get(index);
        return c;
    }
       
}