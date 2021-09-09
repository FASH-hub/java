package g53854.luckynumbers.model;

import java.util.List;

/**
 * Represents the place where player puts the tiles.
 * The board's size is 4x4
 *
 * @author leonfashingabo
 */
public class Board {

    private final Tile[][] tiles;

    /**
     * Creates an empty board (with no tiles).
     */
    public Board() {
        this.tiles = new Tile[4][4];

    }

    /**
     * Gives the number of board's rows or columns.
     *
     * @return number of rows
     */
    public int getSize() {
        return this.tiles.length;
    }

    /**
     * Checks if the received position is located on the board.
     *
     * @param pos received position to be checked
     * @return true if the position is on the board
     */
    public boolean isInside(Position pos) {
        return pos.getRow() >= 0 && pos.getRow() < this.getSize()
                && pos.getColumn() >= 0 && pos.getColumn() < this.getSize();
    }

    /**
     * Gives the tile from the board according to the received position.
     * The position is surely on the board
     *
     * @param pos received position
     * @return the tile at specified position or null if there's no tile
     */
    public Tile getTile(Position pos) {
        return tiles[pos.getRow()][pos.getColumn()];
    }

    /**
     * Defines if the received tile can be put at the received position.
     * The position is surely on the board
     *
     * @param pos  received position
     * @param tile received tile
     * @return true if the tile can be put at the specified position
     */
    public boolean canBePut(Tile tile, Position pos) {
        return validityInRow(tile, pos) && validityInColumn(tile, pos);
    }


    /**
     * Checks if the tile can be put in a row.
     * The tile's value at given position  must be greater than the tile's value at previous position
     * The tile's value at given position  must be smaller than the tile's value at next position
     *
     * @param tile received tile to be put at specified position on board
     * @param pos  received position on which the tile must be put
     * @return true if the tile can be put
     */
    private boolean validityInRow(Tile tile, Position pos) {

        for (int col = 0; col < pos.getColumn(); col++) {
            Tile tile1 = getTile(new Position(pos.getRow(), col));
            if (tile1 != null && tile1.getValue() >= tile.getValue()) {
                return false;
            }

        }
        for (int col = pos.getColumn() + 1; col < tiles.length; col++) {
            Tile tile1 = getTile(new Position(pos.getRow(), col));
            if (tile1 != null && tile1.getValue() <= tile.getValue()) {
                return false;
            }

        }
        return true;
    }

    /**
     * Checks if the tile can be put in a column.
     * The tile's value at given position  must be greater than the tile's value at position up
     * The tile's value at given position  must be smaller than the tile's value  at position down
     *
     * @param tile received tile to be put at specified position on board
     * @param pos  received position on which the tile must be put
     * @return true if the tile can be put
     */
    private boolean validityInColumn(Tile tile, Position pos) {

        for (int row = 0; row < pos.getRow(); row++) {
            Tile tile1 = getTile(new Position(row, pos.getColumn()));
            if (tile1 != null && tile1.getValue() >= tile.getValue()) {

                return false;
            }
        }
        for (int row = pos.getRow() + 1; row < tiles.length; row++) {
            Tile tile1 = getTile(new Position(row, pos.getColumn()));
            if (tile1 != null && tile1.getValue() <= tile.getValue()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Places the received tile at the received position.
     * The position is surely on the board
     * If the position is already busy, the new tile crushes the former one
     *
     * @param tile received tile to be put on the board
     * @param pos  received position on which the tile will be put
     */
    public void put(Tile tile, Position pos) {
        tiles[pos.getRow()][pos.getColumn()] = tile;
    }

    /**
     * Checks if the board is full of tiles.
     *
     * @return true if the board is full
     */
    public boolean isFull() {
        for (Tile[] tile : tiles) {
            for (Tile value : tile) {
                if (value == null) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Gives the number of tiles already put on the board.
     *
     * @return number of tiles
     */
    public int nbTiles() {

        int cpt = 0;
        for (Tile[] tile : tiles) {
            for (Tile value : tile) {
                if (value != null) {
                    cpt++;
                }
            }
        }
        return cpt;
    }

    /**
     * Puts tiles on board.
     * Tiles are put on board's diagonal in growing order
     *
     * @param tile tile to be put on board
     */
    public void fillDiagonal(List<Tile> tile) {
        for (int i = 0; i < tiles.length; i++) {
            tiles[i][i] = tile.get(i);


        }
    }


}



