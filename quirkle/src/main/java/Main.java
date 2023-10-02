import quirkle.model.Grid;
import quirkle.model.Position;

import static quirkle.model.Bag.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(bag.getRandomTile());
        Grid grid = new Grid();
        System.out.println("Count of remaining : " + bag.size() + " tiles ");
        System.out.println("The grid displays as follow" + grid);
    }
}