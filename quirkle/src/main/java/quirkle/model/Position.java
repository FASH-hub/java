package quirkle.model;

/**
 * Represents a position on the grid (composed by a row and column), on which the tile will be put.
 * @param row row on the grid
 * @param column column on the grid
 */
public record Position (int row, int column){
}
