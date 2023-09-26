package quirkle.model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Represents a bag of tiles.
 * As we have 6 different colors and 6 different shapes, the is supposed to contain 36 different tiles
 */
public class Bag {
    public static final Bag bag = new Bag();
    List<Tile> tileList;
    private Bag() {


        tileList = Stream.iterate(1, j->j+1)
                .map(Tile -> new Tile(Color.values()[new Random().nextInt(Color.values().length)], Shape.values()[new Random().nextInt(Color.values().length)]))
                .limit(108)
                .collect(Collectors.toList());
        Collections.shuffle(tileList);
    }

    /**
     * Retrieves the random tile from the bag.
     * @return tile
     */
    public  Tile getRandomTile(){
        int lastIndex = this.tileList.size() - 1;
        return this.tileList.remove(lastIndex);
    }

    /**
     * Returns the only instance of the bag of tiles.
     * @return bag of tiles
     */
    public Bag getInstance(){
      return bag;
    }

    /**
     * Gives the size of the bag.
     * @return size of the bag
     */
    public  int size(){
        return this.tileList.size();
    }

}

