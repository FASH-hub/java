
package g53854.solitaire.model;

/**
 * Represents a game card.
 *
 * @author leonfashingabo
 */


public class Card {
    private int value;

    /**
     * Creates a new card with the received value.
     *
     * @param value received value to initialize the card's value
     */
    public Card(int value) {
        this.value = value;
    }

    /**
     * Gives the card's value.
     *
     * @return card's value
     */
    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "(" +
                +value +
                ")";
    }
}
