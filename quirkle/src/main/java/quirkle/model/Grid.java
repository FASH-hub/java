package quirkle.model;

import static quirkle.utils.CodesUtils.*;


/**
 * Represents the board of the game.
 */
public class Grid {

    private final Tile[][] tiles;


    public Grid() {
        this.tiles = new Tile[27][27];

    }

    /**
     * Gives tile located at a specific position.
     *
     * @return tile
     */
    public Tile getTile(Position pos) {
        return tiles[pos.row()][pos.column()];
    }

    /**
     * Checks if received position is on the board.
     *
     * @param position received position to be checked
     * @return true
     */
    public boolean isInside(Position position) {
        return position.row() >= 0 && position.row() < this.getSize()
                && position.column() >= 0 && position.column() < this.getSize();
    }

    /**
     * Puts a tile on the grid.
     * The first player first specifies the number of tiles he has and proceeds by putting them on the grid on specified position and in specified direction
     *
     * @param position  specified direction in which tiles will be put
     * @param direction specified position on which tiles are being put
     * @param tile      tile to be put on the grid
     */
    public void putTile(Position position, Direction direction, Tile tile) {
        if (isInside(position)) {
            int nbTiles = readInt("How many tiles do you have? ");
            for (int i = 0; i < nbTiles; i++) {
                tiles[position.row() + direction.getDeltaRow()][position.column() + direction.getDeltaColumn()] = tile;
            }
        }
    }

    /**
     * Gives the number of grid's rows or columns.
     *
     * @return number of rows/columns
     */
    public int getSize() {
        return this.tiles.length;
    }
}
