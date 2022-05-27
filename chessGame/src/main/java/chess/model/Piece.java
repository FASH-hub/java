package chess.model;

/**
 * Represents the pawn used in the game.
 *
 * @author leonfashingabo <fashingaboleon@gmail.com>
 */
public class Piece {
    private Color color;

    /**
     * Initialises the piece by the received color.
     *
     * @param color received color to initialize the piece
     */
    public Piece(Color color) {
        this.color = color;
    }

    /**
     * Simple getter of the piece's color.
     *
     * @return piece's color
     */
    public Color getColor() {
        return color;
    }
}
