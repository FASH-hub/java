package g53854.luckynumbers.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * Represents a table that contains different tiles.
 * The tiles contained on table are mixed, some with face up and others face down
 * Different methods are used to separate the revealed and the hidden ones
 *
 * @author leonfashingabo
 */
public class Deck {

    private List<Tile> hiddenFaces;
    private List<Tile> revealedFaces;


    /**
     * Creates new Deck.
     * The new Deck contains tiles of values from 1 to 20 according to the player count
     * The tiles with face down on new Deck are mixed
     *
     * @param playerCount received number of players ready to play
     */
    public Deck(int playerCount) {

        List<Tile> streamed;
        streamed = Stream.iterate(1, j -> j + 1)
                .map(Tile::new)
                .limit(20)
                .collect(Collectors.toList());

        this.hiddenFaces = new ArrayList<>();
        for (int i = 0; i < playerCount; i++) {
            this.hiddenFaces.addAll(0, streamed);
        }

        Collections.shuffle(this.hiddenFaces);
        this.revealedFaces = new ArrayList<>();

    }

    /**
     * Gets the tile with a hidden value.
     *
     * @return hidden tile
     */
    public Tile pickFaceDown() {
        int lastIndex = hiddenFaces.size() - 1;
        Tile tile = hiddenFaces.remove(lastIndex);
        tile.flipFaceUp();
        return tile;
    }

    /**
     * Gives the number of tiles with face down.
     *
     * @return the number of tiles hidden
     */
    public int faceDownCount() {
        return hiddenFaces.size();
    }

    /**
     * Gives the number of tiles with face up.
     *
     * @return the number of tiles revealed
     */
    public int faceUpCount() {
        return revealedFaces.size();
    }

    /**
     * Gives the list of tiles with the face up
     *
     * @return list of revealed tiles
     */
    public List<Tile> getAllFaceUp() {
        return revealedFaces;
    }

    /**
     * Checks if the received tile exists on deck.
     * It checks also if it is revealed
     *
     * @param tile received tile to be checked
     * @return true if the tile exists and revealed, false otherwise
     */
    public boolean hasFaceUp(Tile tile) {
        for (int i = 0; i < revealedFaces.size(); i++) {
            if (!revealedFaces.contains(tile) && !tile.isFaceUp()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Removes the revealed tile from the deck.
     *
     * @param tile received tile to be revealed and removed from the deck
     */
    public void pickFaceUp(Tile tile) {
        this.revealedFaces.remove(tile);
    }

    /**
     * Reset the revealed tile on deck.
     *
     * @param tile received tile to be revealed and put back on deck
     */
    public void putBack(Tile tile) {
        this.revealedFaces.add(tile);
    }

    /**
     * Checks if the tiles with face down are all picked.
     *
     * @return true if tiles with face down are all picked
     */
    public boolean areFaceDownOver() {
        return faceDownCount() == 0;
    }


    /**
     * Gives the list of tiles with face down.
     * It's exclusively used for tests
     *
     * @return list of tiles
     */
    List<Tile> getHiddenFaces() {
        return this.hiddenFaces;
    }


}
