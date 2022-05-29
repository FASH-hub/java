package chess.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Board board;

    @BeforeEach

    public void setUp() {
        board = new Board();
    }

    @Test
    public void containsOnCorner() {
        // A corner of the board
        Position pos = new Position(0, 0);
        assertTrue(board.contains(pos));
    }

    @Test
    public void containsMiddleBoard() {
        // A point on the midle of the board
        Position pos = new Position(4, 4);
        assertTrue(board.contains(pos));
    }

    @Test
    public void containsRowOutOfRange() {
        // Row out of range
        Position pos = new Position(-1, 3);
        assertFalse(board.contains(pos));
    }

    @Test
    public void containsColOutOfRange() {
        // Col. out of range
        Position pos = new Position(1, 8);
        assertFalse(board.contains(pos));
    }

    @Test
    public void containsColAndRowOutOfRange() {
        // Row and col. out of range
        Position pos = new Position(10, 10);
        assertFalse(board.contains(pos));
    }

    @Test
    public void isFreeNot() {
        // When a piece is on the given positon
        Position pos = new Position(1, 1);
        board.setPiece(new Piece(Color.BLACK), pos);

        assertFalse(board.isFree(pos));
    }

    @Test
    public void IsFreeYes() {
        // When a piece is NOT on the given positon
        Position pos = new Position(3, 2);

        assertTrue(board.isFree(pos));
    }

     @Test
    public void containsOppositeColor() {
}

   @Test
    public void getPositionsOccupiedBy() {
       Color color = Color.WHITE;
       Player player = new Player(color);
       List<Position> positions;
       List<Position> expected = new ArrayList<>();

       for (int i = 0; i < 8; i++){
           board.setPiece(new Piece(color), new Position(1,i));
           expected.add(new Position(1,i));
       }

       positions = board.getPositionsOccupiedBy(player);
       assertEquals(expected, positions);
   }
}