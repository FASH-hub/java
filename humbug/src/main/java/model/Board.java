package model;

/**
 * Represents the game's board.
 *
 * @author Léon FASHINGABO <fashingaboleon@gmail.com>
 */

public class Board {

    private Square squares[][];


    /**
     * Creates new board with received squares.
     *
     * @param tiles received tiles represeneting squares
     */
    Board(Square[][] tiles) {
        this.squares = tiles;
    }

    /**
     * Gives the initial board at level 1 of the game
     *
     * @return board
     */
    public static Board getInitialBoard() {

        Square[][] gameTiles = {
                {new Square(SquareType.GRASS), new Square(SquareType.GRASS), new Square(null)},
                {new Square(null), new Square(SquareType.GRASS), new Square(SquareType.GRASS)},
                {new Square(null), new Square(null), new Square(SquareType.STAR)}
        };

        return new Board(gameTiles);
    }

    /**
     * Defines if the received position is on the board
     *
     * @param pos received position to be checked
     * @return true if the position is on board, false otherwise
     */
    public boolean isInside(Position pos) {
        if (pos == null) {
            throw new IllegalArgumentException("Position cannot be null");
        }

        return ((pos.getRow() >= 0 && pos.getColumn() >= 0)
                && (pos.getRow() <= this.getNbRow() - 1 && pos.getColumn() <= this.getNbColumn() - 1)
                && this.squares[pos.getRow()][pos.getColumn()] != null);
    }

    /**
     * Gives the number of board's rows
     *
     * @return number of rows
     */
    public int getNbRow() {
        return this.squares.length;
    }

    /**
     * Gives the number of board's columns
     *
     * @return number of columns
     */
    public int getNbColumn() {
        return this.squares[0].length;
    }

    /**
     * Gives the square's type according to the received position.
     *
     * @param position received position
     * @return type of square
     */
    public SquareType getSquareType(Position position) {
        return this.squares[position.getRow()][position.getColumn()].getType();
    }

}