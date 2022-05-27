package chess.model;

/**
 * Represents one of the 64 squares composing the game's board.
 *
 * @author leonfashingabo <fashingaboleon@gmail.com>
 */
public class Square {
    private Piece piece;

    /**
     * Instantiates the square with received pawn.
     *
     * @param piece received pawn to instantiate the square
     */
    public Square(Piece piece) {
        this.piece = piece;
    }

    /**
     * Simple getter of the pawn.
     *
     * @return the pawn
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     * Updates the current pawn by the received one.
     *
     * @param pawn received pawn update the current one
     */
    public void setPiece(Piece pawn) {
        this.piece = pawn;
    }

    /**
     * Checks if the square is free.
     *
     * @return true
     */
    public boolean isFree() {
        return this.piece == null;
    }
}
