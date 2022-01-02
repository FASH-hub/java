package view;

import model.Board;
import model.Direction;
import model.Position;

import java.util.Locale;

import static usefulCodes.Useful.readInt;
import static usefulCodes.Useful.readString;

public class View implements InterfaceView {
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

        int row = readInt("Please enter the row value", 1, 3) - 1;
        int col = readInt("Please enter the column value", 1, 3) - 1;

        return new Position(row, col);
    }

    /**
     * Asks the user to enter a certain direction.
     *
     * @return direction given by the user
     */
    @Override
    public Direction askDirection() {

        String dir = readString("Enter Direction: 'N' for (North), 'S' for (South), 'E' for (East), 'W' for (West): ")
                .toUpperCase();
        Direction direction = null;

        switch (dir) {
            case "N" -> direction = Direction.NORTH;
            case "S" -> direction = Direction.SOUTH;
            case "E" -> direction = Direction.EAST;
            case "W" -> direction = Direction.WEST;
            default -> displayError("Please enter a valid direction (N, S, E, W)");
        }
        return direction;
    }

    /**
     * Displays the error message.
     *
     * @param message error message to be displayed
     */
    @Override
    public void displayError(String message) {
        System.err.println(message);
    }
}
