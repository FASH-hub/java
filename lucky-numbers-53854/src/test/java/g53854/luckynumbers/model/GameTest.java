package g53854.luckynumbers.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author MCD <mcodutti@he2b.be>
 */
class GameTest {

    private Game game;

    @BeforeEach
    public void setUp() {
        game = new Game();
    }

    /* =====================
         Tests for start()
       ===================== */

    /* --- test related to the state --- */
    @Test
    public void start_when_game_not_started_ok() {
        game.start(4);
    }

    @Test
    public void start_when_game_over_ok() {
        fullPlay();
        game.start(2);
    }

    /* Play a game till the end */
    private void fullPlay() {
        game.start(2);
        int value = 1;
        int line = 0;
        int col = 0;
        for (int turn = 1; turn < game.getBoardSize() * game.getBoardSize(); turn++) {
            for (int player = 0; player < game.getPlayerCount(); player++) {
                game.pickTile(value);
                game.putTile(new Position(line, col));
                game.nextPlayer();
            }
            value++;
            col++;
            if (col == game.getBoardSize()) {
                col = 0;
                line++;
            }
        }
        game.pickTile(20);
        game.putTile(new Position(line, col));
    }

    @Test
    public void start_when_game_in_progress_ISE() {
        game.start(4);
        assertThrows(IllegalStateException.class,
                () -> game.start(1));
    }

    @Test
    public void start_state_changed_to_PICK_TILE() {
        game.start(3);
        assertEquals(State.PICK_TILE, game.getState());
    }

    /* --- tests related to the parameter --- */
    @Test
    public void start_playerCount_too_small_Exception() {
        assertThrows(IllegalArgumentException.class,
                () -> game.start(1));
    }

    @Test
    public void start_playerCount_minimum_accepted() {
        game.start(2);
    }

    @Test
    public void start_playerCount_maximum_accepted() {
        game.start(4);
    }

    @Test
    public void start_playerCount_too_big_Exception() {
        assertThrows(IllegalArgumentException.class,
                () -> game.start(5));
    }

    /* -- tests related to fields initialization --- */
    @Test
    public void start_playerCount_initialized() {
        game.start(4);
        assertEquals(4, game.getPlayerCount());
    }

    @Test
    public void start_current_player_is_player_0() {
        game.start(4);
        assertEquals(0, game.getCurrentPlayerNumber());
    }


    //========================================================== //
    //              @author 53854@etu.he2b.be                    //
    // ===========================================================//

    /**
     * Test of pickTile method, of class Game.
     */
    @Test
    public void testPickTile_PICK_TILE_ok() {
        System.out.println("When state is PICK_TILE");
        game.start(3);
        game.pickTile(4);
    }

    /**
     * Test of pickTile method, of class Game.
     */
    @Test
    public void testPickTile_state_changedTo_NOT_STARTED() {
        System.out.println("When state is NOT_STARTED");
        int value = 7;
        assertThrows(IllegalStateException.class, () -> game.pickTile(value));
    }


    /**
     * Test of getBoardSize method, of class Game.
     */
    @Test
    public void testGetBoardSize() {
        System.out.println("The size of boards");
        int expResult = 4;
        game.start(2);
        int result = game.getBoardSize();
        assertEquals(expResult, result);

    }

    /**
     * Test of putTile method, of class Game.
     */
    @Test
    public void testPutTile_when_pos_isInside_PLACE_TILE_ok() {
        System.out.println("When the position is on board ");
        Position pos = new Position(1, 2);
        game.start(3);
        game.pickTile(8);
        game.putTile(pos);
        assertEquals(State.TURN_END, game.getState());

    }

    /**
     * Test of putTile method, of class Game.
     */
    @Test
    public void testPutTile_when_State_PLACE_TILE_not() {
        System.out.println("When state is not PLACE_TILE");
        Position pos = new Position(1, 2);
        game.start(3);
        assertThrows(IllegalStateException.class, () -> game.putTile(pos));

    }

    /**
     * Test of putTile method, of class Game.
     */
    @Test
    public void testPutTile_when_pos_isInside_not() {
        System.out.println("When the position is not on board");
        Position pos = new Position(-1, 2);
        game.start(3);
        game.pickTile(5);
        assertThrows(IllegalArgumentException.class, () -> game.putTile(pos));

    }

    /**
     * Test of nextPlayer method, of class Game.
     */
    @Test
    public void testNextPlayer_when_TURN_END_ok() {
        System.out.println("Next player when state is TURN_END");
        game.start(4);
        game.pickTile(7);
        game.putTile(new Position(0, 1));
        game.nextPlayer();
        assertEquals(State.PICK_TILE, game.getState());

    }

    /**
     * Test of nextPlayer method, of class Game.
     */
    @Test
    public void testNextPlayer_when_State_changeTo_PLACE_TILE() {
        System.out.println("Next player when state is PLACE_TILE");
        game.start(4);
        game.pickTile(7);
        assertThrows(IllegalStateException.class, () -> game.nextPlayer());

    }

    /**
     * Test of nextPlayer method, of class Game.
     */
    @Test
    public void testNextPlayer_() {
        System.out.println("Next player when state is TURN_END, player 0 to player 1");
        int expPlayer = 1;
        game.start(4);
        game.pickTile(7);
        game.putTile(new Position(0, 1));
        game.nextPlayer();
        assertEquals(expPlayer, game.getCurrentPlayerNumber());

    }

    /**
     * Test of getPlayerCount method, of class Game.
     */
    @Test
    public void testGetPlayerCount() {
        System.out.println("The number of players when the game did start");
        int expResult = 3;
        game.start(3);
        int result = game.getPlayerCount();
        assertEquals(expResult, result);

    }

    /**
     * Test of getPlayerCount method, of class Game.
     */
    @Test
    public void testGetPlayerCount_when_NOT_STARTED_ok() {
        System.out.println("The number of players when the game didn't start yet");
        assertThrows(IllegalStateException.class, () -> game.getPlayerCount());

    }

    /**
     * Test of getCurrentPlayerNumber method, of class Game.
     */
    @Test
    public void testGetCurrentPlayerNumber_ok() {
        System.out.println("The current player when the did start");
        int expPlayer = 0;
        game.start(2);
        game.pickTile(9);
        game.putTile(new Position(2, 2));
        assertEquals(expPlayer, game.getCurrentPlayerNumber());

    }

    /**
     * Test of getCurrentPlayerNumber method, of class Game.
     */
    @Test
    public void testGetCurrentPlayerNumber_when_NOT_STARTED_ok() {
        System.out.println("The current player when game didn't start yet");
        assertThrows(IllegalStateException.class, () -> game.getCurrentPlayerNumber());

    }

    /**
     * Test of getPickedTile method, of class Game.
     */
    @Test
    public void testGetPickedTile_PLACE_TILE_ok() {
        System.out.println("The picked tile when state is PLACE_TILE");
        game.start(3);
        int tileValue = (int) ((Math.random() * 20) + 1);
        int expResult = game.pickTile(tileValue).getValue();
        assertEquals(expResult, game.getPickedTile().getValue());

    }

    /**
     * Test of getPickedTile method, of class Game.
     */
    @Test
    public void testGetPickedTile_when_State_changeTo_PICK_TILE() {
        System.out.println("The picked tile when state is PICK_TILE");
        game.start(3);
        assertThrows(IllegalStateException.class, () -> game.getPickedTile());

    }

    /**
     * Test of isInside method, of class Game.
     */
    @Test
    public void testIsInside_first_row_first_column() {
        System.out.println("Position is top left corner");
        game.start(2);
        Position pos = new Position(0, 0);
        assertTrue(game.isInside(pos));

    }

    /**
     * Test of isInside method, of class Game.
     */
    @Test
    public void testIsInside_last_row_last_column() {
        System.out.println("Position is bottom right corner");
        game.start(2);
        Position pos = new Position(3, 3);
        assertTrue(game.isInside(pos));

    }

    /**
     * Test of isInside method, of class Game.
     */
    @Test
    public void testIsInside_first_row_last_column() {
        System.out.println("Position is bottom left corner");
        game.start(2);
        Position pos = new Position(0, 3);
        assertTrue(game.isInside(pos));

    }

    /**
     * Test of isInside method, of class Game.
     */
    @Test
    public void testIsInside_last_row_first_column() {
        System.out.println("Position is top right corner");
        game.start(2);
        Position pos = new Position(3, 0);
        assertTrue(game.isInside(pos));

    }

    /**
     * Test of isInside method, of class Game.
     */
    @Test
    public void testIsInside_row_bigValue() {
        System.out.println("Position with greater row's value");
        game.start(2);
        Position pos = new Position(4, 0);
        assertFalse(game.isInside(pos));

    }

    /**
     * Test of isInside method, of class Game.
     */
    @Test
    public void testIsInside_row_negative_value() {
        System.out.println("Position with smaller row's value");
        game.start(2);
        Position pos = new Position(-1, 3);
        assertFalse(game.isInside(pos));

    }

    /**
     * Test of isInside method, of class Game.
     */
    @Test
    public void testIsInside_column_bigValue() {
        System.out.println("Position with greater column's value");
        game.start(2);
        Position pos = new Position(2, 4);
        assertFalse(game.isInside(pos));

    }

    /**
     * Test of isInside method, of class Game.
     */
    @Test
    public void testIsInside_column_negativeValue() {
        System.out.println("Position with smaller column's value");
        game.start(2);
        Position pos = new Position(-1, 1);
        assertFalse(game.isInside(pos));

    }

    /**
     * Test of canTileBePut method, of class Game.
     */
    @Test
    public void testCanTileBePut_position_inside() {
        System.out.println("When position is on board and rules respected");
        Position pos = new Position(0, 0);
        game.start(2);
        game.pickTile(5);
        boolean result = game.canTileBePut(pos);
        assertTrue(result);

    }

    /**
     * Test of canTileBePut method, of class Game.
     */
    @Test
    public void testCanTileBePut_when_State_changeTo_PICK_TILE() {
        System.out.println("When state changed to PICK_TILE");
        Position pos = new Position(0, 3);
        game.start(2);
        assertThrows(IllegalStateException.class, () -> game.canTileBePut(pos));

    }

    /**
     * Test of canTileBePut method, of class Game.
     */
    @Test
    public void testCanTileBePut_position_outside() {
        System.out.println("When position is not on board");
        Position pos = new Position(5, 7);
        game.start(2);
        game.pickTile(5);
        assertThrows(IllegalArgumentException.class, () -> game.canTileBePut(pos));

    }

    /**
     * Test of getTile method, of class Game.
     */
    @Test
    public void testGetTile_position_outside() {
        System.out.println("When position is not on board");
        int playerNumber = 3;
        game.start(4);
        Position pos = new Position(2, -3);
        assertThrows(IllegalArgumentException.class, () -> game.getTile(playerNumber, pos));

    }

    /**
     * Test of canTileBePut method, of class Game.
     */
    @Test
    public void testCanTileBePut_PLACE_TILE_ok() {
        System.out.println("When state is correctly PLACE_TILE");
        Position pos = new Position(0, 0);
        game.start(2);
        game.pickTile(5);
        game.canTileBePut(pos);
        assertEquals(State.PLACE_TILE, game.getState());

    }

    /**
     * Test of canTileBePut method, of class Game.
     */
    @Test
    public void testCanTileBePut_State_changeTo_PICK_TILE() {
        System.out.println("When state is wrongly PICK_TILE");
        Position pos = new Position(0, 0);
        game.start(2);
        assertThrows(IllegalStateException.class, () -> game.canTileBePut(pos));

    }

    /**
     * Test of getWinner method, of class Game.
     */
    @Test
    public void testGetWinner_state_changeTo_PICK_TILE() {
        System.out.println("Winner state changed to PICK_TILE");
        game.start(3);
        assertThrows(IllegalStateException.class, () -> game.getWinners());

    }

    /**
     * Test of getWinner method, of class Game.
     */
    @Test
    public void testGetWinner_state_changeTo_PLACE_TILE() {
        System.out.println("Winner state changed to PLACE_TILE");
        game.start(3);
        game.pickTile(15);
        assertThrows(IllegalStateException.class, () -> game.getWinners());

    }


}