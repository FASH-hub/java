package quirkle.model;

/**
 * Represents the board of the game.
 */
public class Grid {

    private Tile [][] tiles;
    private boolean isEmpty;

    /**
     * Instantiates the grid with listed tiles when the grid is empty.
     * @param pieces array of tiles to be added to the grid
     * @param empty checks if the grid is empty before adding tiles
     */
    public Grid(Tile[][] pieces, boolean empty) {
        this.tiles = pieces;
        this.isEmpty = empty;
    }

    /**
     * Gives array of tiles to be added to the grid.
      * @return array of tiles
     */
    public Tile[][] getTiles() {
        return tiles;
    }
}
