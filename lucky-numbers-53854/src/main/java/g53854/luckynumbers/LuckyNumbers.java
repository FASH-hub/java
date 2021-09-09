package g53854.luckynumbers;

import g53854.luckynumbers.controller.Controller;
import g53854.luckynumbers.model.Game;
import g53854.luckynumbers.model.Model;
import g53854.luckynumbers.view.View;

/**
 * Calls the Controller to manage and launch the game.
 *
 * @author leonfashingabo
 */
public class LuckyNumbers {
    public static void main(String[] args) {
        Model game = new Game();
        Controller controller = new Controller(game, new View(game));
        controller.play();
    }
}
