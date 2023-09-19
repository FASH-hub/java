package chess.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PositionTest {


    @Test
  public void next_north() {
        System.out.println(" next position north");
        Position position = new Position(3, 3);
        Position expected = new Position(4, 3);
        Position result = position.next(Direction.N);
        assertEquals(expected, result);
    }

    @Test
    public void next_south() {
        System.out.println(" next position south");
        Position position = new Position(-1, 3);
        Position expected = new Position(-2, 3);
        Position result = position.next(Direction.S);
        assertEquals(expected, result);
    }

    @Test
    public void next_east() {
        System.out.println(" next position east");
        Position position = new Position(-1, 3);
        Position expected = new Position(-1, 4);
        Position result = position.next(Direction.E);
        assertEquals(expected, result);
    }

    @Test
    public void next_west() {
        System.out.println(" next position west");
        Position position = new Position(-1, 3);
        Position expected = new Position(-1, 2);
        Position result = position.next(Direction.W);
        assertEquals(expected, result);
    }

}