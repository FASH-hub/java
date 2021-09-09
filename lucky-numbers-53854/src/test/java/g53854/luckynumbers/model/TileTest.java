
package g53854.luckynumbers.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author leonfashingabo
 */
public class TileTest {

    public TileTest() {
    }

    /**
     * Test of isFaceUp method, of class Tile.
     */
    @Test
    public void testIsFaceUp_not() {
        System.out.println("Face not flipped to up");
        Tile instance = new Tile(5);
        boolean expResult = false;
        boolean result = instance.isFaceUp();
        assertEquals(expResult, result);
      
    }
/**
     * Test of isFaceUp method, of class Tile.
     */
    @Test
    public void testIsFaceUp_ok() {
        System.out.println("Face flipped to up");
        Tile instance = new Tile(5);
        instance.flipFaceUp();
        boolean expResult = true;
        boolean result = instance.isFaceUp();
        assertEquals(expResult, result);
      
    }
    /**
     * Test of toString method, of class Tile.
     */
    @Test
    public void testToString_faceUp() {
        System.out.println("Flipped to up");
        Tile instance = new Tile(12);
        String expResult = "12";
        String result = instance.toString();
        instance.flipFaceUp();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of flipFaceUp method, of class Tile.
     */
    @Test
    public void testFlipFaceUp_flipped() {
        System.out.println("Face down flipped to up");
        Tile instance = new Tile(19);
        instance.flipFaceUp();
        boolean expResult = true;
        boolean result = instance.isFaceUp();
        assertEquals(expResult, result);
        
    }
    /**
     * Test of flipFaceUp method, of class Tile.
     */
    @Test
    public void testFlipFaceUp_not_flipped() {
        System.out.println("Not flipped to up");
        Tile instance = new Tile(5);
        boolean expResult = false;
        boolean result = instance.isFaceUp();
        assertEquals(expResult, result);

    }
    /**
     * Test of flipFaceUp method, of class Tile.
     */
    @Test
    public void testFlipFaceUp_alreadyUp() {
        System.out.println("Face already up");
        Tile instance = new Tile(12);
        String expResult = "12";
        String result = instance.toString();
        assertEquals(expResult, result);

    }

    
}
