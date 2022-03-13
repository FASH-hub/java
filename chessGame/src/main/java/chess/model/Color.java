package chess.model;

public enum Color {
    WHITE, BLACK;

    public Color opposite(Color c) {
        return (c.equals(WHITE)) ? BLACK : WHITE;
    }
}
