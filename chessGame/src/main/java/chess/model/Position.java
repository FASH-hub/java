package chess.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position position)) return false;
        return getRow() == position.getRow() && getColumn() == position.getColumn();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRow(), getColumn());
    }

    /**
     * Gives the new position according to the received direction
     *
     * @param direction received direction
     * @return new position
     */
    public Position next(Direction direction) {
        return new Position(row + direction.getDeltaRow(), column + direction.getDeltaColumn());
    }
}
