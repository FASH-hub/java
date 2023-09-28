package quirkle.model;

/**
 * Represents the board of the game.
 */
public class Grid {

    private Tile[][] tiles;


    public Grid() {
        this.tiles = new Tile[27][27];
    }

    /**
     * Gives array of tiles to be added to the grid.
     *
     * @return array of tiles
     */
    public Tile getTiles(int row, int column) {
        return null;
    }

    public void addFirst(Position position, Direction direction, Tile... tile) {

    }
}
