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
public class Rook extends Piece{
    
    /**
     * black Rook image with the url.
     */
    static Image blackRook = new Image("https://upload.wikimedia.org/wikipedia/commons/5/5c/Chess_rlt60.png");
    
    /**
     * white Rook image with the url.
     */
    static Image whiteRook = new Image("https://upload.wikimedia.org/wikipedia/commons/a/a0/Chess_rdt60.png");
    
    /**
     * Construct Black Rook with parent object, Piece
     * @param x x coordinate of the piece
     * @param y y coordinate of the piece
     * @param boardSize square size of the board
     * @param teamColor color of the team.
     */
    Rook(int x, int y, int boardSize, Color teamColor){
        super(teamColor, blackRook, x, y, boardSize);
    }
    
    /**
     * Construct white Rook with parent object, Piece
     * @param x x coordinate of the piece
     * @param y y coordinate of the piece
     * @param boardSize square size of the board
     * @param teamColor color of the team.
     */
    Rook(Color teamColor, int x, int y, int boardSize){
        super(teamColor, whiteRook, x, y, boardSize);
    }
    
    /**
     * Check the x coordinate and y coordinate where user clicked are valid
     * @param x x coordinate where user clicked
     * @param y y coordinate where user clicked
     * @currentPlayer player who is in turn
     * @enemyPlayer enemy player
     * @return return true if there is no piece in the way and it is straight move otherwise
     * false.
     */
    public boolean isValidMove(int x, int y, Player currentPlayer, Player enemyPlayer) {
        if(currentPlayer.isAnySamePos(x, y)) {
            return false;
        }
        
        if(x != xPosition && y != yPosition) {
            return false;
        }
        return isAnyBlock(x, y, currentPlayer, enemyPlayer);
    }
    
    /**
     * Check whether there is any obstacle in the way
     * @param x x coordinate where user clicked
     * @param y y coordinate where user clicked
     * @param currentPlayer who is in turn
     * @param enemyPlayer enemy player 
     * @return true if there is no piece in the way.
     */
    public boolean isAnyBlock(int x, int y, Player currentPlayer, Player enemyPlayer) {
        if(xPosition > x) {
            for(int i = xPosition -1; i > x; i--) {
                  if(currentPlayer.isAnySamePos(i, y) || enemyPlayer.isAnySamePos(i, y)) {
                  System.out.println("qwer");
                  return false;
              }
            }
        }
        else if(xPosition < x) {
            for(int i = x -1; i > xPosition; i--) {
                if(currentPlayer.isAnySamePos(i, y) || enemyPlayer.isAnySamePos(i,y)) {
                    System.out.println("qwer2");
                    return false;
                }
            }
        }
        else if(yPosition > y) {
            for(int i = yPosition -1 ; i > y; i--) {
                if(currentPlayer.isAnySamePos(x, i) || enemyPlayer.isAnySamePos(x, i)) {
                    System.out.println("qwer3");
                    return false;
                }
            }
        } else if(yPosition < y) {
            System.out.println("ySmall");
            for(int i = y - 1; i > yPosition; i--) {
                if(currentPlayer.isAnySamePos(x, i) || enemyPlayer.isAnySamePos(x, i)) {
                    System.out.println("qwer4");
                    return false;
                }
            }
        }
        
        return true;
    }
}
