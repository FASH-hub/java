package quirkle.model;
import static quirkle.model.Bag.*;

/**
 * Represents the board of the game.
 */
public class Grid {

    private Tile[][] tiles;


    public Grid() {
        this.tiles = new Tile[27][27];

    }

    /**
     * Gives tile located at a specific position.
     * @return tile
     */
    public Tile getTile(Position pos) {
        return tiles[pos.row()][pos.column()];
    }

    public void addFirst(Position position, Direction direction, Tile... tile) {

    }
}
