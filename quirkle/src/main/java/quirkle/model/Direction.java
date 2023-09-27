package quirkle.model;

/**
 * Represents 4 possible directions where a player can put tiles.
 */
public enum Direction {

    DOWN(-1, 0), UP(1, 0), RIGHT(0, 1), LEFT(0, -1);

    private int deltaRow;
    private int deltaColumn;

    Direction(int row, int column) {
        this.deltaRow = row;
        this.deltaColumn = column;
    }

    public int getDeltaRow() {
        return this.deltaRow;
    }

    public int getDeltaColumn() {
        return this.deltaColumn;
    }

    /**
     * Gives the opposite direction according to the specified direction.
     * @param direction received direction
     * @return opposite direction
     */
    public Direction opposite(Direction direction) {

       return switch (direction) {
           case UP -> Direction.DOWN;
           case DOWN -> Direction.UP;
           case LEFT -> Direction.RIGHT;
           case RIGHT -> Direction.LEFT;
           default -> throw new IllegalArgumentException("Invalid direction");
       };
   }
}