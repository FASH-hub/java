package g53854.luckynumbers.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    private Board board;

    @BeforeEach     // Exécutée avant chaque test
    public void setUp() {
        board = new Board();
    }

    /* === Tests for isInside === */
    @Test
    public void isInside_true_when_really_inside() {
        Position pos = new Position(1, 2);
        assertTrue(board.isInside(pos));
    }

    @Test
    public void isInside_true_when_first_row() {
        Position pos = new Position(0, 2);
        assertTrue(board.isInside(pos));
    }

    @Test
    public void isInside_true_when_last_row() {
        Position pos = new Position(1, board.getSize()-1);
        assertTrue(board.isInside(pos));
    }

    @Test
    public void isInside_position_when_row_too_small() {
        Position pos = new Position(-1, 1);
        assertFalse(board.isInside(pos));
    }

    @Test
    public void isInside_position_when_row_too_big() {
        Position pos = new Position(board.getSize(), 1);
        assertFalse(board.isInside(pos));
    }

    @Test
    public void isInside_true_when_first_col() {
        Position pos = new Position(2, 0);
        assertTrue(board.isInside(pos));
    }

    @Test
    public void isInside_true_when_last_col() {
        Position pos = new Position(board.getSize()-1, 1);
        assertTrue(board.isInside(pos));
    }

    @Test
    public void isInside_position_when_col_too_small() {
        Position pos = new Position(1, -1);
        assertFalse(board.isInside(pos));
    }

    @Test
    public void isInside_position_when_col_too_big() {
        Position pos = new Position(2, board.getSize());
        assertFalse(board.isInside(pos));
    }

    /* === Tests for put === */
    @Test
    public void put() {
        Tile tile = new Tile(1);
        Position pos = new Position(1, 2);
        board.put(tile, pos);
        assertTrue(board.getTile(pos) == tile);
    }

    /* === Tests for canBePut === */
    @Test
    public void canBePut_true_when_empty_spots() {
        assertTrue(board.canBePut(new Tile(1), new Position(1, 2)));
    }

    @Test
    public void canBePut_true_when_no_violated_rule_pos_free() {
        board.put(new Tile(1), new Position(0, 1));
        board.put(new Tile(1), new Position(1, 0));
        board.put(new Tile(20), new Position(3, 1));
        board.put(new Tile(20), new Position(1, 3));
        assertTrue(board.canBePut(new Tile(5), new Position(1, 1)));
    }

    @Test
    public void canBePut_true_when_no_violated_rule_pos_occupied() {
        board.put(new Tile(1), new Position(0, 1));
        board.put(new Tile(1), new Position(1, 0));
        board.put(new Tile(20), new Position(3, 1));
        board.put(new Tile(20), new Position(1, 3));
        board.put(new Tile(5), new Position(1, 1));
        assertTrue(board.canBePut(new Tile(5), new Position(1, 1)));
    }

    @Test
    public void canBePut_false_when_bigger_value_at_left() {
        board.put(new Tile(1), new Position(0, 1));
        board.put(new Tile(10), new Position(1, 0));
        board.put(new Tile(20), new Position(3, 1));
        board.put(new Tile(20), new Position(1, 3));
        assertFalse(board.canBePut(new Tile(5), new Position(1, 1)));
    }

    @Test
    public void canBePut_false_when_same_value_at_left() {
        board.put(new Tile(1), new Position(0, 1));
        board.put(new Tile(5), new Position(1, 0));
        board.put(new Tile(20), new Position(3, 1));
        board.put(new Tile(20), new Position(1, 3));
        assertFalse(board.canBePut(new Tile(5), new Position(1, 1)));
    }

    @Test
    public void canBePut_false_when_bigger_value_up() {
        board.put(new Tile(10), new Position(0, 1));
        board.put(new Tile(1), new Position(1, 0));
        board.put(new Tile(20), new Position(3, 1));
        board.put(new Tile(20), new Position(1, 3));
        assertFalse(board.canBePut(new Tile(5), new Position(1, 1)));
    }

    @Test
    public void canBePut_false_when_same_value_up() {
        board.put(new Tile(5), new Position(0, 1));
        board.put(new Tile(1), new Position(1, 0));
        board.put(new Tile(20), new Position(3, 1));
        board.put(new Tile(20), new Position(1, 3));
        assertFalse(board.canBePut(new Tile(5), new Position(1, 1)));
    }

    @Test
    public void canBePut_false_when_smaller_value_right() {
        board.put(new Tile(1), new Position(0, 1));
        board.put(new Tile(1), new Position(1, 0));
        board.put(new Tile(20), new Position(3, 1));
        board.put(new Tile(5), new Position(1, 3));
        assertFalse(board.canBePut(new Tile(10), new Position(1, 1)));
    }

    @Test
    public void canBePut_false_when_same_value_right() {
        board.put(new Tile(1), new Position(0, 1));
        board.put(new Tile(1), new Position(1, 0));
        board.put(new Tile(10), new Position(3, 1));
        board.put(new Tile(5), new Position(1, 3));
        assertFalse(board.canBePut(new Tile(10), new Position(1, 1)));
    }

    @Test
    public void canBePut_false_when_smaller_value_down() {
        board.put(new Tile(1), new Position(0, 1));
        board.put(new Tile(1), new Position(1, 0));
        board.put(new Tile(5), new Position(3, 1));
        board.put(new Tile(20), new Position(1, 3));
        assertFalse(board.canBePut(new Tile(10), new Position(1, 1)));
    }

    @Test
    public void canBePut_false_when_same_value_down() {
        board.put(new Tile(1), new Position(0, 1));
        board.put(new Tile(1), new Position(1, 0));
        board.put(new Tile(10), new Position(3, 1));
        board.put(new Tile(20), new Position(1, 3));
        assertFalse(board.canBePut(new Tile(10), new Position(1, 1)));
    }

    /* === Tests for isFull === */
    @Test
    public void isFull_false_when_empty() {
        assertFalse(board.isFull());
    }

    @Test
    public void isFull_false_when_a_few_tiles() {
        board.put(new Tile(1), new Position(1, 1));
        board.put(new Tile(1), new Position(2, 1));
        board.put(new Tile(1), new Position(0, 2));
        board.put(new Tile(1), new Position(3, 3));
        assertFalse(board.isFull());
    }

    @Test
    public void isFull_true_when_full() {
        /* We fill the board */
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                board.put(new Tile(1), new Position(i, j));
            }
        }
        assertTrue(board.isFull());
    }

}