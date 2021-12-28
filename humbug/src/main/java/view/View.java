package view;

import model.Board;
import model.Direction;
import model.Position;

public class View implements InterfaceView{
    /**
     * Displays the game's board and the required information for the game.
     * Animals on the board are also displayed
     *
     * @param board game's board
     */
    @Override
    public void displayBoard(Board board) {

    }

    /**
     * Asks the user to enter a certain position.
     *
     * @return position entered by the user
     */
    @Override
    public Position askPosition() {
        return null;
    }

    /**
     * Asks the user to enter a certain direction.
     *
     * @return direction given by the user
     */
    @Override
    public Direction askDirection() {
        return null;
    }

    /**
     * Displays the error message.
     *
     * @param message error message to be displayed
     */
    @Override
    public void displayError(String message) {

    }
}
