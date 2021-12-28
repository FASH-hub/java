package view;

import model.*;


public interface InterfaceView {

    /**
     * Displays the game's board and the required information for the game.
     * Animals on the board are also displayed
     *
     * @param board game's board
     */
    void displayBoard(Board board);

    /**
     * Asks the user to enter a certain position.
     *
     * @return position entered by the user
     */
    Position askPosition();

    /**
     *  Asks the user to enter a certain direction.
     *
     * @return direction given by the user
     */
    Direction askDirection();

    /**
     * Displays the error message.
     *
     * @param message error message to be displayed
     */
    void displayError(String message);


}
