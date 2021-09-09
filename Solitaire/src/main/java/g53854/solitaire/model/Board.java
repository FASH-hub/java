package g53854.solitaire.model;


/**
 * Represents a game board where picked cards are placed.
 *
 * @author leonfashingabo
 */
public class Board {
    private Card[] cards;

    /**
     * Creates a board of 4 cards.
     * Each card equals to 0
     */
    public Board() {
        this.cards = new Card[4];
        for (int i = 0; i < cards.length; i++){
            cards[i] = new Card(0);
        }
    }

    public Card[] getCards() {
        return cards;
    }

    /**
     * Checks if the received card can be put on the specified board's position.
     *
     * @param card received card to be checked
     * @param pos  received position to be put the position
     * @return true
     */
    public boolean canBePut(Card card, int pos) {

        return cards[pos].getValue() < card.getValue();
    }

    /**
     * Puts the received card on specified bord's position.
     *
     * @param card received card to put on the board
     * @param pos  specified position
     */
    public void put(Card card, int pos) {
        cards[pos] = card;
    }
}
