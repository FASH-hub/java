
package g53854.solitaire.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author leonfashingabo
 */
public class BoardTest {
    
    public BoardTest() {
    }

    /**
     * Test of canBePut method, of class Board.
     */
    @Test
    public void testCanBePut() {
        System.out.println("canBePut, position on the board");
        Card card = new Card(3);
        int pos = 1;
        Board instance = new Board();
        boolean result = instance.canBePut(card, pos);
        assertTrue(result);

    }
    /**
     * Test of canBePut method, of class Board.
     */
    @Test
    public void testCanBePut_pickedValue_greater() {
        System.out.println("canBePut, picked card's value is greater than the current card's value");
        Card pickedCard = new Card(15);
        int pos = 3;
        Board board = new Board();
        board.getCards()[pos] = new Card(5);
        boolean result = board.canBePut(pickedCard, pos);
        assertTrue(result);

    }
    /**
     * Test of canBePut method, of class Board.
     */
    @Test
    public void testCanBePut_pickedValue_smaller() {
        System.out.println("canBePut, picked card's value is smaller than the current card's value");
        Card pickedCard = new Card(1);
        int pos = 2;
        Board board = new Board();
        board.getCards()[pos] = new Card(10);
        boolean result = board.canBePut(pickedCard, pos);
        assertFalse(result);

    }


    
}
