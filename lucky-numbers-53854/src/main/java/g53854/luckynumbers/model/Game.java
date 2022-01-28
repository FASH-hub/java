package g53854.luckynumbers.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Provides the methods implemented from the model to the view.
 * The view interacts with game just have access to the model content
 *
 * @author leonfashingabo
 */

public class Game implements Model {
    private State state;
    private int playerCount;
    private int currentPlayerNumber;
    private Board[] boards;
    private Tile pickedTile;
    private Deck deck;

    /**
     * Initialises only the game's state at the beginning.
     * The state is then put to NOT_STARTED
     */
    public Game() {
        this.state = State.NOT_STARTED;
    }

    /**
     * Initialize a game.
     * <p>
     * An empty board is created for each player
     * Player number 0 starts the game
     * State becomes PICK_TILE
     * A deck containing tiles is created according to the number of players
     *
     * @param playerCount the number of players
     * @throws IllegalStateException if the number of players is not between
     *                               2 and 4 (both included).
     * @throws IllegalStateException if called when state is not NOT_STARTED nor
     *                               GAME_OVER.
     */
    @Override
    public void start(int playerCount) {

        if (this.state != State.NOT_STARTED && this.state != State.GAME_OVER) {
            throw new IllegalStateException(" The game has not yet started or a turn is being played ");
        }
        if (playerCount < 2 || playerCount > 4) {
            throw new IllegalArgumentException(" Number of players invalid ");
        }
        this.playerCount = playerCount;
        this.currentPlayerNumber = 0;
        this.boards = new Board[playerCount];
        this.deck = new Deck(playerCount);
        for (int i = 0; i < playerCount; i++) {
            this.boards[i] = new Board();
            Board board = this.boards[i];
            Tile[] diagonalTiles = new Tile[board.getSize()];
            for (int j = 0; j < board.getSize(); j++) {
                diagonalTiles[j] = deck.pickFaceDown();
            }
            List<Tile> sortedTiles = Arrays.stream(diagonalTiles)
                    .sorted(Comparator.comparingInt(Tile::getValue)).collect(Collectors.toList());
            board.fillDiagonal(sortedTiles);
        }

        this.state = State.PICK_TILE;


    }

    /**
     * Give the size of the boards.
     * We suppose that all boards are squares and of the same size.
     * So this is both number of lines and number of columns.
     * With the official rules, this should be 4
     * but this must not be assumed and this methode must be used
     * instead of hardcoding that value elsewhere in the code.
     *
     * @return the size of the board.
     */
    @Override
    public int getBoardSize() {
        return boards[getCurrentPlayerNumber()].getSize();
    }



    /**
     * Put a tile at the given position. Put the previously picked tile of the
     * current player at the given position on its board.
     * State becomes TURN_END or GAME_OVER.
     *
     * @param pos where to put the tile.
     * @throws IllegalArgumentException if the tile can't be put on that
     *                                  position (position outside of the board or position not allowed by the
     *                                  rules)
     * @throws IllegalStateException    if called when state is not PLACE_TILE or not PLACE_OR_DROP_TILE
     */
    @Override
    public void putTile(Position pos) {

        Board currentPlayerBoard = boards[getCurrentPlayerNumber()];
        if (this.state != State.PLACE_TILE && this.state != State.PLACE_OR_DROP_TILE) {
            throw new IllegalStateException(" Game's states unexpected, the tile can't be put ");

        }
        if (!isInside(pos)) {
            throw new IllegalArgumentException(" Tile can't be put on the board ");
        }
        Tile tile1 = currentPlayerBoard.getTile(new Position(pos.getRow(), pos.getColumn()));
        if (tile1 != null) {
            this.deck.putBack(tile1);
        }
        currentPlayerBoard.put(pickedTile, pos);

        if (currentPlayerBoard.isFull() || deck.areFaceDownOver()) {
            state = State.GAME_OVER;
        } else {
            state = State.TURN_END;
        }

    }

    /**
     * Change current player. The next player becomes the current one. The order
     * is : 0, 1, 2, 3 and again 0, 1, ...
     * State becomes PICK_TILE
     *
     * @throws IllegalStateException if called when state is not TURN_END
     */
    @Override
    public void nextPlayer() {
        if (this.state != State.TURN_END) {
            throw new IllegalStateException(" Unexpected game's state, the game may be over ");
        }

        int newPlayerNumber = getCurrentPlayerNumber() + 1;
        currentPlayerNumber = newPlayerNumber > getPlayerCount() - 1 ? 0 : newPlayerNumber;
        state = State.PICK_TILE;

    }

    /**
     * Give the total number of players in this game.
     *
     * @return the total number of players in this game.
     * @throws IllegalStateException if state is NOT_STARTED
     */
    @Override
    public int getPlayerCount() {
        if (this.state == State.NOT_STARTED) {
            throw new IllegalStateException(" Can't have the player count, the game has not started yet ");
        }

        return this.playerCount;
    }

    /**
     * Get the current state of the game.
     *
     * @return the current state of the game.
     */
    @Override
    public State getState() {

        return this.state;
    }

    /**
     * Give the number of the current player. Players are numeroted from 0 to
     * (count-1).
     *
     * @return the number of the current player.
     * @throws IllegalStateException if state is NOT_STARTED or GAME_OVER
     */
    @Override
    public int getCurrentPlayerNumber() {
        if (this.state == State.NOT_STARTED || this.state == State.GAME_OVER) {
            throw new IllegalStateException(" Game's state unexpected, the game has not yet started or is over ");
        }
        return this.currentPlayerNumber;
    }

    /**
     * Get the current picked tile. Get the tile picked by the current player.
     *
     * @return the current picked tile.
     * @throws IllegalStateException if state is not PLACE_TILE
     */
    @Override
    public Tile getPickedTile() {
        if (this.state != State.PLACE_TILE && this.state != State.PLACE_OR_DROP_TILE) {
            throw new IllegalStateException("Invalid state of game, the tile couldn't be picked");
        }

        return this.pickedTile;
    }

    /**
     * Check if a position is inside the board of the current player or not.
     *
     * @param pos a position
     * @return true if the given position is inside the board.
     */
    @Override
    public boolean isInside(Position pos) {
        Board currentPlayerBoard = boards[getCurrentPlayerNumber()];
        return currentPlayerBoard.isInside(pos);
    }

    /**
     * Check if a tile can be put at the given position. Check if the current
     * player is allowed to put its previously picked tile at the given position
     * on the board of the current player.
     *
     * @param pos the position to check
     * @return true if the picked tile can be put at that position.
     * @throws IllegalArgumentException if the position is outside the board.
     * @throws IllegalStateException    if state is not PLACE_TILE.
     */
    @Override
    public boolean canTileBePut(Position pos) {
        if (this.state != State.PLACE_TILE && this.state != State.PLACE_OR_DROP_TILE) {
            throw new IllegalStateException(" Unexpected game's state, the tile can't be put ");
        }
        if (!isInside(pos)) {
            throw new IllegalArgumentException(" The received position is outside the board ");
        }

        return boards[currentPlayerNumber].canBePut(pickedTile, pos);

    }

    /**
     * Give a tile at a given position of the board of a given player.
     *
     * @param playerNumber the player number
     * @param pos          a position on the board
     * @return the tile at that position for that player or <code>null</code> if
     * there is no tile there.
     * @throws IllegalArgumentException if the position is outside the board or
     *                                  if the playerNUmber is ouside of range.
     * @throws IllegalStateException    if game state is NOT_STARTED
     */
    @Override
    public Tile getTile(int playerNumber, Position pos) {
        if (playerNumber >= getBoardSize() || playerNumber < 0 || !isInside(pos)) {
            throw new IllegalArgumentException(" Player's number out of range or position outside of board");
        }
        if (this.state == State.NOT_STARTED) {
            throw new IllegalStateException(" Game has not yet started ");
        }
        return boards[playerNumber].getTile(pos);
    }

    /**
     * Give the winner/winners.
     *
     * @return list of the player number/numbers who won
     * @throws IllegalStateException if game state is not GAME_OVER
     */
    @Override
    public List<Integer> getWinners() {

        if (state != State.GAME_OVER) {
            throw new IllegalStateException("Invalid game state");
        }

        List<Integer> champion = new ArrayList<>();
        int winner = maxTiles(boards);

        if (boards[currentPlayerNumber].isFull()) {
            champion.add(currentPlayerNumber);
        }
        else {
            for (int i = 0; i < boards.length; i++) {
                if (boards[i].nbTiles() == winner) {
                    champion.add(i);
                }
            }
        }

        return champion;
    }

    /**
     * Gives the board's number with maximum of tiles already put on it.
     * Browses and checks all the boards to get that maximum.
     *
     * @param tab array of boards
     * @return the board's number
     */
    private int maxTiles(Board[] tab) {

        int playerWithMaxTiles = 0;
        int maxValue = 0;

        for (int i = 0; i < tab.length; i++) {
            if (tab[i].nbTiles() > maxValue) {
                playerWithMaxTiles = i;
                maxValue = tab[i].nbTiles();
            }
        }
        return playerWithMaxTiles;
    }

    /**
     * The current player picks the tile.
     * The picked tile's value is hidden
     *
     * @return tile with a face down
     * @throws IllegalStateException if called when state is not PICK_TILE
     */
    @Override
    public Tile pickFaceDownTile() {
        if (this.state != State.PICK_TILE) {
            throw new IllegalStateException(" The game's state unexpected, tile can't be picked ");
        }
        this.pickedTile = deck.pickFaceDown();
        this.state = State.PLACE_OR_DROP_TILE;
        return this.pickedTile;
    }

    /**
     * The current player picks a received tile.
     * The picked tile's value is revealed
     * If the tile is not revealed, it's flipped to face up
     *
     * @param tile received tile to be picked
     * @throws IllegalStateException if called when state is not PICK_TILE
     */
    @Override
    public void pickFaceUpTile(Tile tile) {
        if (this.state != State.PICK_TILE) {
            throw new IllegalStateException(" The game's state unexpected, tile can't be picked ");
        }

        this.pickedTile = tile;
        this.deck.pickFaceUp(pickedTile);
        this.state = State.PLACE_TILE;
    }

    /**
     * Drops the picked tile.
     * The current player chose not to put it on the board
     *
     * @throws IllegalStateException if called when state is not PLACE_OR_DROP_TILE
     */
    @Override
    public void dropTile() {
        if (this.state != State.PLACE_OR_DROP_TILE) {
            throw new IllegalStateException(" The game's state unexpected, tile can't be dropped ");
        }
        this.deck.putBack(this.pickedTile);
        state = (deck.areFaceDownOver() ? State.GAME_OVER : State.TURN_END);

    }

    /**
     * Gives the number of picked tiles with a face down.
     *
     * @return number of tiles, int value
     */
    @Override
    public int faceDownTileCount() {
        return this.deck.faceDownCount();
    }

    /**
     * Gives the number of picked tiles with a face up.
     *
     * @return number of tiles, int value
     */
    @Override
    public int faceUpTileCount() {
        return this.deck.faceUpCount();
    }

    /**
     * Gives the list of all picked tiles with a face up.
     *
     * @return list of tiles
     */
    @Override
    public List<Tile> getAllFaceUpTiles() {

        return new ArrayList<>(deck.getAllFaceUp());
    }

    /**
     * Pick a tile with the given value. Should be used only for the JUnit tests.
     *
     * @param value received tile's value
     * @return picked tile
     */
    Tile pickTile(int value) {
        if (state != State.PICK_TILE) {
            throw new IllegalStateException("Invalid game state");
        }

        pickedTile = new Tile(value);
        state = State.PLACE_TILE;
        return pickedTile;
    }

}
