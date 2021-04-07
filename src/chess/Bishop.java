/**
 * 
 */
package chess;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
/**
 * @author sungminjin
 *
 */
public class Bishop extends Piece{
    /**
     * black bishop image with the url.
     */
    static Image blackBishop = new Image("https://upload.wikimedia.org/wikipedia/commons/8/81/Chess_bdt60.png");
    
    /**
     * white bishop image with the url.
     */
    static Image whiteBishop = new Image("https://upload.wikimedia.org/wikipedia/commons/9/9b/Chess_blt60.png");
    Square[][] square;
    
    /**
     * Construct black bishop with parent object, Piece
     * @param x x coordinate of the piece
     * @param y y coordinate of the piece
     * @param boardSize square size of the board
     * @param teamColor color of the team.
     */
    Bishop(Color teamColor, int x, int y, int boardSize){
        super(teamColor, blackBishop, x, y, boardSize);
    }
    
    /**
     * Construct white bishop with parent object, Piece
     * @param x x coordinate of the piece
     * @param y y coordinate of the piece
     * @param boardSize square size of the board
     * @param teamColor color of the team.
     */
    Bishop(int x, int y, int boardSize,Color teamColor){
        super(teamColor, whiteBishop, x, y, boardSize);
    }
    
    /**
     * Check the x coordinate and y coordinate where user clicked are valid
     * @param x x coordinate where user clicked
     * @param y y coordinate where user clicked
     * @currentPlayer player who is in turn
     * @enemyPlayer enemy player
     * @return return true if there is no piece in the way and it is diagonal move
     * otherwise false
     */
    public boolean isValidMove(int x, int y, Player currentPlayer, Player enemyPlayer) {
        if(currentPlayer.isAnySamePos(x, y)) {
            return false;
        }
        
        if(!isAnyBlock(x, y, currentPlayer, enemyPlayer)) {
            return false;
        }
        
        for (int i = 1; i < 8; i++) {
            
            if (xPosition + i == x && yPosition + i == y) {
                return true;
            } else if(xPosition + i == x && yPosition - i == y) {
                return true;
            } else if (xPosition - i == x && yPosition + i == y) {
                return true;
            } else if (xPosition - i == x && yPosition - i == y) {
                return true;
            }
            
        }
        
        return false;
    }
    
    /**
     * Check whether there is any obstacle in the way.
     * @param x x coordinate where user clicked
     * @param y y coordinate where user clicked
     * @currentPlayer player who is in turn
     * @enemyPlayer enemy player
     * @return return true if there is no piece in the way otherwise false
     */
    public boolean isAnyBlock(int x, int y, Player currentPlayer, Player enemyPlayer) {
        if(xPosition < x && yPosition < y) {
            for(int i = 1; i < x - xPosition; i ++) {
                if(currentPlayer.isAnySamePos(xPosition + i, yPosition + i) || enemyPlayer.isAnySamePos(xPosition + i, yPosition + i)) {
                    return false;
                }
            }
        } else if(xPosition < x && yPosition > y) {
            for(int i = 1; i < x - xPosition; i++) {
                if(currentPlayer.isAnySamePos(xPosition + i, yPosition - i) || enemyPlayer.isAnySamePos(xPosition + i, yPosition - i)) {
                    return false;
                }
            }
            
        } else if(xPosition > x && yPosition < y) {
            for(int i = 1; i < xPosition - x; i++) {
                if(currentPlayer.isAnySamePos(xPosition - i, yPosition + i) || enemyPlayer.isAnySamePos(xPosition - i, yPosition + i)) {
                    return false;
                }
            }
            
        } else if(xPosition > x && yPosition > y) {
            for(int i = 1; i < xPosition - x; i++) {
                if(currentPlayer.isAnySamePos(xPosition - i, yPosition - i) || enemyPlayer.isAnySamePos(xPosition - i, yPosition - i)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    
}
