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
    List<Tile> tiles;
     Bag() {

        List<Tile> tileList;
        tileList = Stream.iterate(1, j->j+1)
                .map(Tile -> new Tile(Color.values()[new Random().nextInt(Color.values().length)], Shape.values()[new Random().nextInt(Color.values().length)]))
                .limit(108)
                .collect(Collectors.toList());
        List<Tile> tiles = new ArrayList<>();
        for (int i = 0; i < tileList.size(); i++){
            tiles.addAll(0, tileList);
        }
       // Collections.shuffle(tiles);

    }

    /**
     * Retrieves the random tile from the bag.
     * @return tile
     */
    public  Tile getRandomTile(){
        Random randomTile = new Random();
        return tiles.get(randomTile.nextInt());
    }

    /**
     * Returns the only instance of the bag of tiles.
     * @return bag of tiles
     */
    public Bag getInstance(){
      return new Bag();
    }

    /**
     * Gives the size of the bag.
     * @return size of the bag
     */
    public  int size(){
        return this.tiles.size();
    }
}
