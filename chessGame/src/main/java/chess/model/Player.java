package chess.model;

/**
 * Represents the player
 *
 * @author leonfashingabo <fashingaboleon@gmail.com>
 */
public class Player {
    private Color color;

    /**
     * Initialises the player by the received color.
     *
     * @param color received to initialize the player
     */
    public Player(Color color) {
        this.color = color;
    }

    /**
     * Simple getter of the player's color
     *
     * @return player's color
     */
    public Color getColor() {
        return color;
    }
}
