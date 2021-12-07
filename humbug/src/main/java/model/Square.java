package model;

/**
 * Square on the board. A square has a type grass or star and it’s all.
 * A square doesn’t know where it is on the board
 *
 * @author Léon FASHINGABO <fashingaboleon@gmail.com>
 */
public class Square {

    private SquareType type;

    /**
     * Constructor of Square on board.
     * It creates new square on board
     *
     * @param type received square's type, grass or star.
     */
    public Square(SquareType type) {
        this.type = type;
    }

    /**
     * Simple getter of type
     *
     * @return the square's type
     */
    public SquareType getType() {
        return type;
    }
}
