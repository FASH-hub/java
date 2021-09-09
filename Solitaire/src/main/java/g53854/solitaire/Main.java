package g53854.solitaire;

import g53854.solitaire.controller.Solitaire;
import g53854.solitaire.model.Game;
import g53854.solitaire.view.View;

/**
 * Calls Solitaire to manage and launch the game.
 *
 * @author leonfashingabo
 */
public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        View view = new View(game);
        Solitaire solitaire = new Solitaire(game, view);
        solitaire.play();
    }
}
