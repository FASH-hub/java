package g53854.luckynumbers.model;

/**
 * Describes the game's state.
 *
 * @author leonfashingabo
 */
public enum State {
    /**
     * Represents the game at it's initial state.
     * No action is yet done
     */
    NOT_STARTED,
    /**
     * Represents the starting state of the game.
     * The player chooses the tile to put on the board
     */
    PICK_TILE,
    /**
     * Represents the game's state after picking the tile.
     * The player can put the tile on the board
     */
    PLACE_TILE,
    /**
     * Represents the game's state after the player has put the tile on board.
     * It's the end of the player's round and the next player can follow
     */
    TURN_END,
    /**
     * Represents the end of the game.
     * But there's a possibility to recall the game
     * Method start () can be recalled
     */
    GAME_OVER,
    /**
     * Represents the choice made by the player after picking a tile with a face down.
     * The player may choose to put tile on the board or drop it on the deck
     * If he chooses to put it on board, putTile () is called, otherwise dropTile () is called
     */
    PLACE_OR_DROP_TILE;

}
