package g53854.luckynumbers.view;

import g53854.luckynumbers.model.Board;
import g53854.luckynumbers.model.Position;
import g53854.luckynumbers.model.Tile;

/**
 * Interface for the Game's view
 *
 * @author leonfashingabo
 */
public interface InterfaceView {

    /**
     * Displays the welcome message.
     * The game's name , game's author, player's name are mentioned
     */
    void displayWelcome();

    /**
     * Displays the current state of the game.
     * Likely the current player, the current player's board and the tile to be put
     * on his board
     */
    void displayGame();

    /**
     * Displays the number of the winning player.
     */
    void displayWinner();

    /**
     * Displays the error message.
     *
     * @param message message to be displayed
     */
    void displayError(String message);

    /**
     * Asks how many players do want to play.
     * The count must be between 2 and 4 players
     */
    int askPlayerCount();

    /**
     * Asks to the user which position on board to put tile.
     * The user will be asked a number of rows and number columns which form a valid position
     *
     * @return valid position entered by the user
     */
    Position askPosition();

    /**
     * Describes the choice made by the player after picking the tile.
     * He chooses either to put it on the board, or to put it back on the deck
     *
     */
    void actionChoice();

    /**
     * Determines witch tile the player does want to pick.
     * Tile with a face up or tile with a face down
     *
     */
    void tileFaceChoice();

    /**
     * Displays the number of face down tiles.
     * It also displays the list of face up tiles
     */
    void tilesDisplay();

}


