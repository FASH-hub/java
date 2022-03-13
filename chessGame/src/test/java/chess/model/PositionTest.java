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

}