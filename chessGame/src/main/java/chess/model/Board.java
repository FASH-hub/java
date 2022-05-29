package chess.model;


import java.util.ArrayList;
import java.util.List;

/**
 * Represents the game board.
 *
 * @author leonfashingabo <fashingaboleon@gmail.com>
 */
public class Board {
    private Square[][] squares;

    /**
     * Instantiates the board with 8 squares.
     */
    public Board() {
        this.squares = new Square[][]{
                {new Square(null), new Square(null), new Square(null), new Square(null), new Square(null), new Square(null), new Square(null), new Square(null)},
                {new Square(null), new Square(null), new Square(null), new Square(null), new Square(null), new Square(null), new Square(null), new Square(null)},
                {new Square(null), new Square(null), new Square(null), new Square(null), new Square(null), new Square(null), new Square(null), new Square(null)},
                {new Square(null), new Square(null), new Square(null), new Square(null), new Square(null), new Square(null), new Square(null), new Square(null)},
                {new Square(null), new Square(null), new Square(null), new Square(null), new Square(null), new Square(null), new Square(null), new Square(null)},
                {new Square(null), new Square(null), new Square(null), new Square(null), new Square(null), new Square(null), new Square(null), new Square(null)},
                {new Square(null), new Square(null), new Square(null), new Square(null), new Square(null), new Square(null), new Square(null), new Square(null)},
                {new Square(null), new Square(null), new Square(null), new Square(null), new Square(null), new Square(null), new Square(null), new Square(null)}
        };
    }

    /**
     * Checks if the received position is on game board.
     *
     * @param pos position to be checked
     * @return true
     */
    public boolean contains(Position pos) {
        return pos.getRow() >= 0 && pos.getRow() < 8
                && pos.getColumn() >= 0 && pos.getColumn() < 8;
    }

    /**
     * Gives the number according to the received color.
     * The serves to set the pawn on the board and to determine if it moved from its initial position
     *
     * @param color received color
     * @return 1 for white color or 6 for black color
     */
    public int getInitialPawnRow(Color color) {
        return switch (color) {
            case WHITE -> 1;
            case BLACK -> 6;
        };
    }

    /**
     * Gives the pawn standing at the specified position.
     *
     * @param pos received position containing the pawn
     * @return the pawn (piece)
     */
    public Piece getPiece(Position pos) {

        if (!contains(pos)) {
            throw new IllegalArgumentException("Received position is out of board");
        }
        return squares[pos.getRow()][pos.getColumn()].getPiece();
    }

    /**
     * Puts the received pawn on the specified square and right position.
     *
     * @param piece the pawn to be placed
     * @param pos   the square's position on the board
     */
    public void setPiece(Piece piece, Position pos) {

        if (!contains(pos)) {
            throw new IllegalArgumentException("Received position is out of board");
        }
        squares[pos.getRow()][pos.getColumn()].setPiece(piece);
    }

    /**
     * Removes the pawn contained on the specified square's position.
     *
     * @param pos square's position
     */
    public void dropPiece(Position pos) {

        if (!contains(pos)) {
            throw new IllegalArgumentException("Received position is out of board");
        }
        squares[pos.getRow()][pos.getColumn()] = new Square(null);
    }

    /**
     * Checks if the square at the received position is not occupied.
     *
     * @param pos received square's position
     * @return true
     */
    public boolean isFree(Position pos) {

        if (!contains(pos)) {
            throw new IllegalArgumentException("Received position is out of board");
        }
        return squares[pos.getRow()][pos.getColumn()].isFree();
    }

    /**
     * Checks if the pawn contained at the received square's position
     * has the opposite color from the one received
     *
     * @param pos   square's received position
     * @param color received color to be checked
     * @return true
     */
    public boolean containsOppositeColor(Position pos, Color color) {

        if (!contains(pos)) {
            throw new IllegalArgumentException("Received position is out of board");
        }
        return squares[pos.getRow()][pos.getColumn()].getPiece().getColor() != color;
    }

    /**
     * Gives the list of occupied positions by the specified player.
     * @param player specified player
     * @return list of positions
     */
    public List<Position> getPositionsOccupiedBy(Player player){

        List<Position> occupied = new ArrayList<>();
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[i].length; j++) {
                if (squares[i][j] != null && squares[i][j].getPiece().getColor() == player.getColor()) {
                    occupied.add(new Position(i, j));
                }
            }
        }
        return occupied;

    }
}
