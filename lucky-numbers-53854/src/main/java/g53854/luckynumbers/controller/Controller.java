package g53854.luckynumbers.controller;

import g53854.luckynumbers.model.Model;
import g53854.luckynumbers.model.Position;
import g53854.luckynumbers.view.InterfaceView;

/**
 * Manages the game's dynamic and updates the view as the game progresses.
 *
 * @author leonfashingabo
 */
public class Controller {

    private Model game;
    private InterfaceView view;

    /**
     * Defines the game and it's view by the received instances.
     *
     * @param lGame received instance of the game
     * @param lView received instance the view
     */
    public Controller(Model lGame, InterfaceView lView) {
        this.game = lGame;
        this.view = lView;
    }

    /**
     * Manages the game from the beginning to the end.
     * It's based on the state of the game
     */
    public void play() {
        view.displayWelcome();
        while (true) {
            try {
                switch (game.getState()) {
                    case NOT_STARTED -> {
                        int playerCount = view.askPlayerCount();
                        game.start(playerCount);
                        view.tilesDisplay();
                    }
                    case PICK_TILE -> {
                        view.displayGame();
                        view.tileFaceChoice();
                        }

                    case PLACE_TILE -> {
                        view.tilesDisplay();
                        view.displayGame();
                        Position position = view.askPosition();
                        game.putTile(position);
                    }
                    case PLACE_OR_DROP_TILE -> {
                        view.tilesDisplay();
                        view.displayGame();
                        view.actionChoice();
                    }
                    case TURN_END -> {
                        view.tilesDisplay();
                        view.displayGame();
                        game.nextPlayer();
                    }
                    case GAME_OVER -> {
                        view.tilesDisplay();
                        view.displayWinner();
                        return;
                    }
                }
            } catch (IllegalStateException | IllegalArgumentException excep) {
                view.displayError(excep.getMessage());
            }
        }


    }
}
