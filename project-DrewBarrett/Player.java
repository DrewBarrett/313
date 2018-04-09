/**
 * Player
 */
public class Player {

    private String m_name;
    private int matched;
    private boolean m_smart; // if smart then not random

    public Player(String name, boolean smart) {
        m_name = name;
        m_smart = smart;
        matched = 0;
    }

    public void doTurn(Deck deck) {
        System.out.println(m_name + "'s turn!");
        // if we're smart call deck getTwoSmart
        // if we're dumb call deck getTwoRandom
        while (!deck.isEmpty() && deck.getTwo(m_smart)) {
            matched++;
        }
        //call deck.flip so deck knows who has been seen
        
    }

    public int getMatched() {
        return matched;
    }

    public String toString() {
        return m_name + " found " + matched + " matches!";
    }
    
}