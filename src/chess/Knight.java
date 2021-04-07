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
public class Knight extends Piece{
    static Image blackKnight = new Image("https://upload.wikimedia.org/wikipedia/commons/f/f1/Chess_ndt60.png");
    static Image whiteKnight = new Image("https://upload.wikimedia.org/wikipedia/commons/2/28/Chess_nlt60.png");
    public Knight(Color teamColor, int x, int y, int boardSize) {
        super(teamColor, blackKnight, x, y, boardSize);
    }
    
    public Knight(int x, int y, int boardSize, Color teamColor) {
        super(teamColor, whiteKnight, x, y, boardSize);
    }
    
    public boolean isValidMove(int x, int y, Player currentPlayer, Player enemyPlayer) {
        if(currentPlayer.isAnySamePos(x, y)) {
            return false;
        }
        
        if(xPosition + 2 == x && yPosition + 1 == y) {
            return true;
        } else if (xPosition + 2 == x && yPosition - 1 == y) {
            return true;
        } else if (xPosition - 2 == x && yPosition + 1 == y) {
            return true;
        } else if (xPosition - 2 == x && yPosition - 1 == y) {
            return true;
        } 
        
        else if (xPosition - 1 == x && yPosition - 2 == y) {
            return true;
        } 
        else if (xPosition - 1 == x && yPosition + 2 == y) {
            return true;
        } 
        else if (xPosition + 1 == x && yPosition - 2 == y) {
            return true;
        } 
        else if (xPosition + 1 == x && yPosition + 2 == y) {
            return true;
        } 
        
        return false;
    }
}
