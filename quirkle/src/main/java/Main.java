import quirkle.model.Color;
import quirkle.model.Shape;
import quirkle.model.Tile;

public class Main {
    public static void main(String[] args) {

        Tile tile = new Tile(Color.BLUE, Shape.DIAMOND);
        System.out.println("Created tile is " + tile);
    }
}