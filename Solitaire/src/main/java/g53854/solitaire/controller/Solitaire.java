package g53854.solitaire.controller;

import g53854.solitaire.model.Game;
import g53854.solitaire.view.View;

/**
 * Controls the game and it's view.
 *
 * @author leonfashingabo
 */
public class Solitaire {
    private Game game;
    private View view;

    public Solitaire(Game sGame, View sView) {
        this.game = sGame;
        this.view = sView;
    }

    /**
     * Manages the game from the beginning to the end.
     */
    public void play() {
        view.displayWelcome();
        while (!game.isOver()) {
            try {
                game.pick();
                view.displayGame();
                view.actionChoice();
                view.displayScore();
            } catch (IllegalArgumentException exp) {
                System.err.println(exp.getMessage());
            }
        }
    }
}
