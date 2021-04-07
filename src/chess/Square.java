package chess;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Represent a square in the chess board
 * @author sungminjin
 * @version 1.0
 */
public class Square extends Rectangle {
    
    Color color;
    
    /**
     * Construct a sqaure
     * @param row row of the chess board
     * @param column column of the chess board
     * @param squareSize square size of the chess board
     */
    public Square(int row, int column, int squareSize) {
        setWidth(squareSize);
        setHeight(squareSize);
        setX(row * squareSize);
        setY(column * squareSize);
        if(row % 2 == column % 2) {
            setFill(Color.rgb(223,188, 150) );
            color = Color.rgb(223, 188, 150);
        } else {
            setFill(Color.rgb(140, 52, 42));
            color = Color.rgb(140, 52, 42);
        }
    }
    
    /**
     * Fill the square with blue color.
     */
    public void clickedSquare() {
        super.setFill(Color.rgb(79, 123, 229));
    }
    
    /**
     * Change color of square.
     */
    public void validSquare() {
        super.setFill(Color.rgb(255,255,204));
    }
    
    /**
     * Get back to its own color
     */
    public void backToOwn() {
        super.setFill(color);
    }
}
