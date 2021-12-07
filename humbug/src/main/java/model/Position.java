package model;

import java.util.Objects;

/**
 * Represents the position on the board.
 *
 * @author Léon FASHINGABO <fashingaboleon@gmail.com>
 */
public class Position {

    private int row, column;

    /**
     * Constructor of Position.
     * It creates a new position using the received values
     *
     * @param lg  received row's value
     * @param col received column's value
     */
    public Position(int lg, int col) {
        this.row = lg;
        this.column = col;
    }

    /**
     * Simple getter of row.
     *
     * @return row
     */
    public int getRow() {
        return row;
    }

    /**
     * Simple getter of column.
     *
     * @return column
     */
    public int getColumn() {
        return column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position = (Position) o;
        return getRow() == position.getRow() && getColumn() == position.getColumn();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRow(), getColumn());
    }
}
