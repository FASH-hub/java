package chess.model;

/**
 * Represents a position on the game's board.
 * The position is formed with row and column values
 *
 * @author leonfashingabo <fashingaboleon@gmail.com>
 */
public class Position {

    private int row, column;

    /**
     * Creates a new position with the received values.
     *
     * @param row    received row's value
     * @param column received column's value
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Simple getter of row's value
     *
     * @return row's value
     */
    public int getRow() {
        return row;
    }

    /**
     * Simple getter of column's value
     *
     * @return column's value
     */
    public int getColumn() {
        return column;
    }
}
