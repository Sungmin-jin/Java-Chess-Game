package chess;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

/**
 * Represent pieces in the chess boards.
 * @author sungminjin
 * @version 1.0
 */
public class Piece extends ImageView {
    
    /**
     * X coordinate
     */
    int xPosition;
    
    /**
     * y coordinate
     */
    int yPosition;
    
    /**
     * Square size of the board
     */
    int boardSize;
    
    Color teamColor;
    
    /**
     * Construct Piece object
     * @param teamColor Color of the team
     * @param image image url of the pieces
     * @param x x coordinate
     * @param y y coordinate
     * @param boardSize size of a square in the board
     */
    Piece(Color teamColor, Image image, int x, int y, int boardSize){
        super(image);
        this.xPosition = x;
        this.yPosition = y;
        this.boardSize = boardSize;
        this.teamColor = teamColor;
        super.setX(x * boardSize + 17.5);
        super.setY(y * boardSize + 17.5);
    }
    
    /**
     * return the x position of the piece
     * @return xPosition
     */
    public int getxPosition() {
        return xPosition;
    }
    
    /**
     * return the y position of the piece
     * @return yPosition
     */
    public int getyPosition() {
        return yPosition;
    }
    
    /**
     * Set the x position of the piece and save that position
     * @param x xPosition where user want to set
     */
    public void setxPosition(int x) {
        xPosition = x;
        super.setX(x * boardSize + 17.5);
    }
    
    /**
     * Set the y position of the piece and save that position
     * @param y yPosition where user want to set
     */
    public void setyPosition(int y) {
        yPosition = y;
        super.setY(y * boardSize + 17.5);
    }
    
    /**
     * Check whether the piece is in the same position.
     * @param x position where user wants to check
     * @param y position where user wants to check
     * @return true if they are in same position else false.
     */
    public boolean isSamePosition(int x, int y) {
        return(xPosition == x && yPosition == y);
    }
    
    /**
     * if piece is killed, remove it from the board and remove image.
     */
    public void killPiece() {
        super.setImage(null);
        xPosition = 10;
        yPosition = 10;
    }
    
    /**
     * Check the x coordinate and y coordinate where user clicked are valid
     * @param x x coordinate where user clicked
     * @param y y coordinate where user clicked
     * @currentPlayer player who is in turn
     * @enemyPlayer enemy player
     * @return return true if if possible move other wise false
     */
    public boolean isValidMove(int x, int y, Player current, Player enemyPlayer) {

        return true;
    }
}
