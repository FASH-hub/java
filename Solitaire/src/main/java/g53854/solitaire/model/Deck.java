package g53854.solitaire.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Represents the table from which cards are picked.
 *
 * @author leonfashingabo
 */
public class Deck {
    List<Card> cards;

    /**
     * Creates a table of 20 cards numbered from 1 to 20.
     */
    public Deck() {
        this.cards = Stream.iterate(1, j -> j + 1)
                .map(Card::new)
                .limit(20)
                .collect(Collectors.toList());
        Collections.shuffle(cards);

    }

    /**
     * Checks if the table is empty.
     *
     * @return true if there's no more cards to pick, false otherwise
     */
    public boolean isEmpty() {
        return this.cards.size() == 0;
    }

    /**
     * Picks a card from the deck and return it's value.
     *
     * @return card
     */
    public Card pick() {
        int lastIndex = cards.size() - 1;
        return cards.remove(lastIndex);
    }
}
