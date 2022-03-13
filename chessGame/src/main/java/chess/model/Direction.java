package chess.model;

/**
 * Contains constant values of given direction on game board.
 *
 * @author leonfashingabo <fashingaboleon@gmail.com>
 */
public enum Direction {

    NW(1, -1), N(1, 0), NE(1, 1), W(0, -1), E(0, 1), SW(-1, -1), S(-1, 0), SE(-1, 1);

    private int deltaRow, deltaColumn;

    /**
     * Instantiate a new direction with received deltaRow and deltaColumn values.
     *
     * @param xdeltaRow    received deltaRow's value
     * @param xdeltaColumn received deltaColumn's value
     */
    Direction(int xdeltaRow, int xdeltaColumn) {
        this.deltaRow = xdeltaRow;
        this.deltaColumn = xdeltaColumn;
    }

    /**
     * Simple getter of deltaRow's value
     *
     * @return deltaRow's value
     */
    public int getDeltaRow() {
        return deltaRow;
    }

    /**
     * Simple getter of deltaColumn value
     *
     * @return deltaColumn's value
     */
    public int getDeltaColumn() {
        return deltaColumn;
    }
}
