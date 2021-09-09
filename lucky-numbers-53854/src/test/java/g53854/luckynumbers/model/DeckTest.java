
package g53854.luckynumbers.model;

import java.util.List;

import g53854.luckynumbers.utils.CodesUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author leonfashingabo
 */
public class DeckTest {


    /**
     * Test of faceDownCount method, of class Deck.
     */
    @Test
    public void testFaceDownCount() {
        System.out.println("faceDownCount in general case");
        Deck deck = new Deck(2);
        List<Tile> invisible = deck.getHiddenFaces();
        int expResult = invisible.size();
        int result = deck.faceDownCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of faceDownCount method, of class Deck.
     */
    @Test
    public void testFaceDownCount_tile_picked() {
        System.out.println("faceDownCount when a face down tile is picked");
        Deck deck = new Deck(2);
        List<Tile> invisible = deck.getHiddenFaces();
        deck.pickFaceDown();
        int expResult = invisible.size()-1 ;
        int result = deck.faceDownCount()-1 ;
        assertEquals(expResult, result);
    }

    /**
     * Test of faceUpCount method, of class Deck.
     */
    @Test
    public void testFaceUpCount() {
        System.out.println("faceUpCount in general case");
        Deck deck = new Deck(3);
        List<Tile> visible = deck.getAllFaceUp();
        int expResult = visible.size();
        int result = deck.faceUpCount();
        assertEquals(expResult, result);

    }

    /**
     * Test of faceUpCount method, of class Deck.
     */
    @Test
    public void testFaceUpCount_tile_picked() {
        System.out.println("faceUpCount when a face up tile is picked");
        Deck deck = new Deck(3);
        List<Tile> visible = deck.getAllFaceUp();
        int val = CodesUtils.hasard(20, 1);
        Tile tile = new Tile(val);
        deck.pickFaceUp(tile);
        int expResult = visible.size();
        int result = deck.faceUpCount();
        assertEquals(expResult, result);

    }


    @Test
    public void testHasFaceUp() {
        System.out.println("Has tile face up after being picked picked ?");
        Deck deck = new Deck(3);
        Tile tile = deck.pickFaceDown();
        assertTrue(deck.hasFaceUp(tile));
    }
    @Test
    public void testHasFaceUp_() {                  // ????
        System.out.println("hasFaceUp");
        Deck deck = new Deck(3);
        List<Tile> invisible = deck.getHiddenFaces();
        int lastIndex = invisible.size()-1;
        Tile tile = invisible.get(lastIndex);
        assertFalse(deck.hasFaceUp(tile));
    }


    @Test
    public void testPickFaceUp() {
        System.out.println("pickFaceUp");
        Deck deck = new Deck(4);
        List<Tile> visible = deck.getAllFaceUp();
        Tile tile = new Tile(4);
        visible.remove(tile);
        deck.pickFaceUp(tile);

    }

    /**
     * Test of putBack method, of class Deck.
     */
    @Test
    public void testPutBack() {
        System.out.println("putBack");
        Tile tile = null;
        Deck deck = null;
        deck.putBack(tile);

    }

    /**
     * Test of areFaceDownOver method, of class Deck.
     */
    @Test
    public void testAreFaceDownOver() {
        System.out.println("areFaceDownOver");
        Deck deck = new Deck(3);
        boolean result = deck.areFaceDownOver();
        assertFalse(result);

    }
    /**
     * Test of areFaceDownOver method, of class Deck.
     */
    @Test
    public void testAreFaceDownOver_() {
        System.out.println("areFaceDownOver when the count equals to zero");
        Deck deck = new Deck(3);
        int count = deck.faceDownCount();
        boolean expect = count == 0;
        boolean result = deck.areFaceDownOver();
       assertEquals(expect, result);

    }


}
