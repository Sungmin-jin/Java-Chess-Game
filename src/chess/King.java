
package chess;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
/**
 * Represent King in chess
 * @author sungminjin
 * @version 1.0
 */

public class King extends Piece{
    
    /**
     * black king image with url.
     */
    static Image blackKing = new Image("https://upload.wikimedia.org/wikipedia/commons/e/e3/Chess_kdt60.png");
    /**
     * white king image with url.
     */
    static Image whiteKing = new Image("https://upload.wikimedia.org/wikipedia/commons/3/3b/Chess_klt60.png");
    
    /**
     * Construct black king piece.
     * @param teamColor color of the team
     * @param x x coordinate of the piece
     * @param y y coordinate of the piece
     * @param boardSize square size of the board
     * @param teamColor color of the team.
     */
    public King(Color teamColor, int x, int y, int boardSize) {
        super(teamColor, blackKing, x, y, boardSize);
    }
    
    /**
     * Construct white king piece.
     * @param x x coordinate of the piece
     * @param y y coordinate of the piece
     * @param boardSize square size of the board
     * @param teamColor color of the team.
     */
    public King(int x, int y, int boardSize, Color teamColor) {
        super(teamColor, whiteKing, x, y, boardSize);
    }

    /**
     * Check the move is valid or not.
     * @param x x coordinate where user clicked
     * @param y y coordinate where user clicked
     * @currentPlayer player who is in turn
     * @enemyPlayer enemy player
     * @return return true if the movement is 1 space
     */
    public boolean isValidMove(int x, int y, Player currentPlayer, Player enemyPlayer) {
        if(currentPlayer.isAnySamePos(x, y)) {
            return false;
        }
        
        if(x - 1 == xPosition || x + 1 == xPosition || x == xPosition) {
            if(y -1 == yPosition || y + 1 == yPosition || y == yPosition) {
                return true;
            }
        }
        return false;
    }
}
