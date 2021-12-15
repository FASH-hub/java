package model;

/**
 * Represents 4 cardinal points used to define the animals' direction while moving.
 *
 * @author Léon FASHINGABO <fashingaboleon@gmail.com>
 */
public enum Direction {

    NORTH(-1, 0), SOUTH(1, 0), EAST(0, 1), WEST(0, -1);

    private int deltaRow;
    private int deltaColumn;

    Direction(int row, int column) {
        this.deltaRow = row;
        this.deltaColumn = column;
    }

    /**
     * Simple row's getter
     *
     * @return row
     */
    public int getDeltaRow() {
        return deltaRow;
    }

    /**
     * Simple column's getter
     *
     * @return column
     */
    public int getDeltaColumn() {
        return deltaColumn;
    }
}
