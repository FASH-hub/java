package quirkle.model;

/**
 * Tile represents a game's tile.
 * color represents the tile's color
 * shape represents the tile's form
 */
public final class Tile {

    final private Color color;
    final private Shape shape;


    /**
     * Creates tile's instance.
     * @param instanceColor received color tile's color
     * @param instanceShape received tile's form
     */
    public Tile(Color instanceColor, Shape instanceShape) {
        this.color = instanceColor;
        this.shape = instanceShape;
    }

    /**
     * retrieves the tile's color
     * @return tile's color
     */
    public Color getColor() {
        return color;
    }

    /**
     * retrieves the tile's form
     * @return tile's shape
     */
    public Shape getShape() {
        return shape;
    }

    @Override
    public String toString() {
        return color + " and has a shape of " + shape;
    }
}
