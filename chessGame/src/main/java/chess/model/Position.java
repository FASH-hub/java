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
     * @param xRow    received row's value
     * @param xColumn received column's value
     */
    public Position(int xRow, int xColumn) {
        this.row = xRow;
        this.column = xColumn;
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
