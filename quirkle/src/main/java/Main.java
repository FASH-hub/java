import static quirkle.model.Bag.bag;

public class Main {

    public static void main(String[] args) {
        System.out.println(bag.getRandomTile());
        System.out.println("Count of remaining : " + bag.size() + " tiles ");
    }
}