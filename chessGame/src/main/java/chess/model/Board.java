package chess.model;

/**
 * Represents the game board.
 *
 * @author leonfashingabo <fashingaboleon@gmail.com>
 */
public class Board {
    private Square [][] squares;

    /**
     * Instantiates the board with 8 squares.
      */
    public Board() {
        this.squares = new Square[8][8];
    }

    /**
     * Checks if the received position is
     * @param pos
     * @return
     */
    public boolean contains(Position pos){
        return pos.getRow() >= 0 && pos.getRow() < 8
                && pos.getColumn() >= 0 && pos.getColumn() < 8;
    }
}
