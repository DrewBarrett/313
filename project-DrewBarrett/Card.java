/**
 * Card
 */
public class Card {
    private String m_suite;
    private String m_value;
    private String m_color;

    private boolean matched = false;
    private boolean flipped = false;

    public Card(String suite, String value) {
        m_suite = suite;
        switch (suite) {
            case "D":
            case "H":
                m_color = "r";
                break;
            case "S":
            case "C":
                m_color = "b";
                break;
            default:
                break;
        }
        m_value = value;
    }

    public String getColor() {
        return m_color;
    }
    public String getValue() {
        return m_value;
    }

    public void flip() {
        flipped = !flipped;
    }

    public void match() {
        matched = true;
    }

    public boolean isMatch(Card other) {
        if (other.getColor().equals(m_color)) {
            if (other.getValue().equals(m_value)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        if (matched) {
            return "XX";
        }
        if (flipped) {
            return m_value + m_suite;
        }
        return "OO";
    }
}