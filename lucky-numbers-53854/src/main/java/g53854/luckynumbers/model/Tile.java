package g53854.luckynumbers.model;

import java.util.Objects;

/**
 * Represents one of the objects used for Lucky Numbers game. Tiles are mainly
 * used to fill the board as game proceeds
 *
 * @author leonfashingabo
 */
public class Tile {

    private int value;
    private boolean faceUp;

    /**
     * Initialises the tile by the received value. Initialises also
     * the class' instance
     *
     * @param val received value to initialize the tile's value
     */
    public Tile(int val) {
        this.value = val;
        this.faceUp = false;
    }

    /**
     * Gives the tile's value.
     *
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * Provides information about the tile's visibility.
     * By the default, the tile's face is down
     *
     * @return true if the face is up, false otherwise
     */
    public boolean isFaceUp() {
        return this.faceUp;
    }

    /**
     * Makes the tile's face up.
     * No action intended when the tile's face is already up
     */
    void flipFaceUp() {
        this.faceUp = true;
    }

    /**
     * Gives the string value of the tile.
      * @return tile's value
     */
    @Override
    public String toString() {
        return Integer.toString(this.getValue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tile)) return false;
        Tile tile = (Tile) o;
        return getValue() == tile.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue(), isFaceUp());
    }
}
