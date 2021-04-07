package chess;


import javafx.scene.Group;

/**
 * 
 * @author sungminjin
 *
 */
public class Board extends Group {
    /**
     * tiles of chess board
     */
    private final Square[][] groupSquare = new Square[8][8];
    
    /**
     * Construct the board in chess game
     * @param squareSize
     */
    public Board(int squareSize) {
       for(int i = 0; i < 8; i++) {
           for(int j = 0; j < 8; j++) {
               groupSquare[i][j] = new Square(i, j, squareSize);
           }
       }
       
       for(int i = 0; i < 8; i++) {
           for(int j = 0; j < 8; j++) {
               getChildren().addAll(groupSquare[i][j]);
           }
       }
       
    }
    
    
    /**
     * Return squares of the board
     * @return groupSquare
     */
    public Square[][] getSquares() {
        return groupSquare;
    }
    
}
