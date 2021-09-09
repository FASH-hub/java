package g53854.luckynumbers.model;

/**
 * Represents the tile's position on the game's board.
 * It's made of the combination of the row and column
 *
 * @author leonfashingabo
 */
public class Position {

    private int row;
    private int column;

    /**
     * Initialises the position and it's instances using the received values.
     *
     * @param line received value to initialize the row
     * @param col  received value to intialize the column
     */
    public Position(int line, int col) {
        this.row = line;
        this.column = col;
    }

    /**
     * Gives the row's value.
     *
     * @return row's value
     */
    public int getRow() {
        return row;
    }

    /**
     * Gives the column's value
     *
     * @return column's value
     */
    public int getColumn() {
        return column;
    }
}
