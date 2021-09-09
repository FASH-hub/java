package g53854.solitaire.view;

import codeUtils.TerminalColor;
import codeUtils.Utils;
import g53854.solitaire.model.Card;
import g53854.solitaire.model.Game;

/**
 * @author leonfashingabo
 */
public class View {
    private Game game;

    public View(Game game) {
        this.game = game;
    }

    public void displayWelcome() {
        System.out.println(TerminalColor.GREEN_BOLD.color("Solitaire by Léon FASHINGABO"));
    }

    public void displayGame() {
        System.out.print(TerminalColor.BLUE_BOLD.color("\n Your heap : "));
        for (Card card : game.getBoard().getCards()) {

            System.out.print(TerminalColor.BLUE_BOLD.color(Integer.toString(card.getValue())) + " ");
        }
        System.out.println("");
        if (game.getPickedCard() != null) {
            System.out.println(TerminalColor.YELLOW_BOLD.color("\n Card to be placed : ") + game.getPickedCard());

        }
    }

    public void displayScore() {
        System.out.println(TerminalColor.GREEN.color("Your score : ") +
                TerminalColor.YELLOW_BOLD.color(Integer.toString(game.getScore())) );
    }

    public int askPosition() {
        final int min = 1;
        final int max = 4;

        return Utils.readInt(TerminalColor.LIGHT_CYAN.color("Enter the position please"), min, max) - 1;
    }

    public void actionChoice() {
        String answer = Utils.readString("\n Would you like to put the card on the board ?");
        if (answer.equalsIgnoreCase("Y")) {
            game.put(this.askPosition());
        } else {
            game.drop();
        }
    }

}
