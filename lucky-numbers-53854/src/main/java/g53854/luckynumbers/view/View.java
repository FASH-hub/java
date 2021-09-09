package g53854.luckynumbers.view;

import g53854.luckynumbers.model.Model;
import g53854.luckynumbers.model.Position;
import g53854.luckynumbers.model.Tile;
import g53854.luckynumbers.utils.CodesUtils;
import g53854.luckynumbers.utils.TerminalColor;

/**
 * Displays the game's state.
 * The current player and the game's board are displayed
 * The view manages the interaction with the user
 *
 * @author leonfashingabo
 */

public class View implements InterfaceView {

    private Model game;

    public View(Model model) {
        this.game = model;
    }

    /**
     * Displays the welcome message.
     * The game's author and player's name are mentioned
     */
    @Override
    public void displayWelcome() {
        System.out.println(TerminalColor.GREEN_BOLD.color("WELCOME ON LUCKYNUMBERS GAME by Michael SCHACHT"));
        System.out.println(TerminalColor.GREEN_BOLD.color("Version: LuckyNumbers 2.0"));
        System.out.printf(TerminalColor.GREEN_BOLD.color("Developer: %s\n"),
                TerminalColor.GREEN_BOLD.color("Léon FASHINGABO"));
        System.out.println();

    }

    /**
     * Displays the current state of the game.
     * Likely the current player, the current player's board and the tile to be put
     * on his board
     */
    @Override
    public void displayGame() {

        var player = game.getCurrentPlayerNumber();
        System.out.printf("\n" + TerminalColor.BG_LIGHT_CYAN.color("Player %s\n"),
                TerminalColor.BG_LIGHT_CYAN.color(Integer.toString(player)));
        var boardSize = game.getBoardSize();
        System.out.print("    ");
        for (int i = 1; i < boardSize + 1; i++) {
            System.out.print(i);
            System.out.print("  ");
        }
        StringBuilder line = new StringBuilder("\n---");
        line.append("---".repeat(Math.max(0, game.getBoardSize())));
        System.out.println(line);
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize + 1; j++) {
                if (j == 0) {
                    System.out.print(i + 1);
                    System.out.print("| ");
                } else {
                    Tile value = game.getTile(player, new Position(i, j - 1));
                    if (value == null) {
                        System.out.print(". ");
                    } else {
                        System.out.printf("%2d", value.getValue());
                    }
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.print(line + "\n");

    }

    /**
     * Displays the number of the winning player.
     */
    @Override
    public void displayWinner() {
        var champion = game.getWinners();
        System.out.println(" The winner is player number " + champion);
    }

    /**
     * Displays the error message.
     *
     * @param message message to be displayed
     */
    @Override
    public void displayError(String message) {
        System.err.println(message);
    }

    /**
     * Asks how many players do want to play.
     * The count must be between 2 and 4 players
     *
     * @return number of players
     */
    @Override
    public int askPlayerCount() {
        final int min = 2;
        final int max = 4;
        return CodesUtils.readInt(TerminalColor.YELLOW_BOLD.color("How many players do want to play ?"), min, max);
    }

    /**
     * Asks to the user which position on board to put tile.
     * The user will be asked a number of rows and number of columns which form a valid position
     *
     * @return valid position entered by the user
     */
    @Override
    public Position askPosition() {

        int posRow = CodesUtils.readInt(TerminalColor.YELLOW_BOLD.color("Enter the row's position please")) - 1;
        int posCol = CodesUtils.readInt(TerminalColor.YELLOW_BOLD.color("Enter the column's position please")) - 1;

        return new Position(posRow, posCol);
    }

    /**
     * Describes the choice made by the player after picking the tile.
     * He chooses either to put it on the board, or to put it back on the deck
     */
    @Override
    public void actionChoice() {

        String answer = CodesUtils.readString("Would you like to put the tile on board [Y/N] ?");
        if (answer.equalsIgnoreCase("Y")) {
            game.putTile(askPosition());
        } else if (answer.equalsIgnoreCase("N")) {
            game.dropTile();
        }
    }

    /**
     * Determines witch tile the player does want to pick.
     * Tile with a face up or tile with a face down
     */
    @Override
    public void tileFaceChoice() {


        String answer = CodesUtils.readString("\nWould you like to pick the up or down face tile [U/D] ?");

        if ((answer.equalsIgnoreCase("U"))) {
            if (game.getAllFaceUpTiles().size() > 0) {
                Tile tile =   new Tile(CodesUtils.readInt("Which value would like to pick", 1, 20));
                if(game.getAllFaceUpTiles().contains(tile)){
                game.pickFaceUpTile(tile);
                    System.out.printf(TerminalColor.LIGHT_CYAN.color("\nPicked tile: %s\n"),
                            TerminalColor.LIGHT_CYAN.color(Integer.toString(game.getPickedTile().getValue())));
                }
            }else {
                throw new IllegalArgumentException("Tile's list is empty");
            }
        } else if (answer.equalsIgnoreCase("D")) {
            game.pickFaceDownTile();
            System.out.printf(TerminalColor.LIGHT_CYAN.color("\nPicked tile: %s\n"),
                    TerminalColor.LIGHT_CYAN.color(Integer.toString(game.getPickedTile().getValue())));
        }

    }


    /**
     * Displays the number of face down tiles.
     * It also displays the list of face up tiles
     */
    @Override
    public void tilesDisplay() {
        System.out.print(TerminalColor.BG_GREEN_FG_WHITE.color(" Face down tiles' count: ") + "(" +
                game.faceDownTileCount() + ")" + "     "
                + TerminalColor.BG_YELLOW.color(" Face up tiles list : ") + game.getAllFaceUpTiles());
        System.out.println();

    }

}
