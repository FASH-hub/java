package g53854.solitaire.model;

/**
 * Represents the game's facade
 *
 * @author leonfashingabo
 */
public class Game {
    private Deck deck;
    private Board board;
    private Card pickedCard;
    private int score;

    /**
     * Creates a game with received values.
     */
    public Game() {
        this.deck = new Deck();
        this.board = new Board();
        this.pickedCard = null;
        this.score = 0;
    }

    /**
     * Gives the deck
     *
     * @return the deck
     */
    public Deck getDeck() {
        return deck;
    }

    /**
     * gives the board
     *
     * @return board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Gives the picked card
     *
     * @return picked card
     */
    public Card getPickedCard() {
        return pickedCard;
    }

    /**
     * Gives the score
     *
     * @return score
     */
    public int getScore() {
        return score;
    }

    /**
     * Picks the card from the deck.
     */
    public void pick() {
        this.pickedCard = deck.pick();
    }

    /**
     * Put the picked card on the the board
     *
     * @param pos specified position to be put the card
     */
    public void put(int pos) {
        if (!board.canBePut(pickedCard, pos)) {
            throw new IllegalArgumentException(" Error, card can't be put");
        }
        board.put(pickedCard, pos);
        pickedCard = null;
        this.score++;
    }

    /**
     * Informs that the player doesn't want to pick a card.
     */
    public Card drop() {
        this.pickedCard = null;
        return pickedCard;
    }

    /**
     * Informs that the game is over.
     *
     * @return true
     */
    public boolean isOver() {
        return this.deck.isEmpty();
    }

}
