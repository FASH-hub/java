package chess.model;

import java.util.Arrays;

import static chess.model.Color.WHITE;

/**
 * Represents the game board.
 *
 * @author leonfashingabo <fashingaboleon@gmail.com>
 */
public class Board {
    private Square[][] squares;

    /**
     * Instantiates the board with 8 squares.
     */
    public Board() {
        this.squares = new Square[][]{
                {new Square(null), new Square(null), new Square(null), new Square(null), new Square(null), new Square(null), new Square(null)},
                {new Square(null), new Square(null), new Square(null), new Square(null), new Square(null), new Square(null), new Square(null)},
                {new Square(null), new Square(null), new Square(null), new Square(null), new Square(null), new Square(null), new Square(null)},
                {new Square(null), new Square(null), new Square(null), new Square(null), new Square(null), new Square(null), new Square(null)},
                {new Square(null), new Square(null), new Square(null), new Square(null), new Square(null), new Square(null), new Square(null)},
                {new Square(null), new Square(null), new Square(null), new Square(null), new Square(null), new Square(null), new Square(null)},
                {new Square(null), new Square(null), new Square(null), new Square(null), new Square(null), new Square(null), new Square(null)},
                {new Square(null), new Square(null), new Square(null), new Square(null), new Square(null), new Square(null), new Square(null)}
        };
    }

    /**
     * Checks if the received position is on game board.
     *
     * @param pos position to be checked
     * @return true
     */
    public boolean contains(Position pos) {
        return pos.getRow() >= 0 && pos.getRow() < 8
                && pos.getColumn() >= 0 && pos.getColumn() < 8;
    }

    /**
     * Gives the number according to the received color.
     * The serves to set the pawn on the board and to determine if it moved from its initial position
     *
     * @param color received color
     * @return 1 for white color or 6 for black color
     */
    public int getInitialPawnRow(Color color) {
        return switch (color) {
            case WHITE -> 1;
            case BLACK -> 6;
        };
    }
    public void setPiece(Piece piece, Position pos){
        if (!contains(pos)){
            throw new IllegalArgumentException("Position is out of board");
        }
       // Arrays.stream(this.squares).filter();
    }
}
