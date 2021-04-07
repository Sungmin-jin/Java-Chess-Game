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
public class Queen extends Piece{
    
    /**
     * Black Queen Image with url.
     */
    static Image blackQueen = new Image("https://upload.wikimedia.org/wikipedia/commons/a/af/Chess_qdt60.png");
    
    /**
     * White Queen Image with url.
     */
    static Image whiteQueen = new Image("https://upload.wikimedia.org/wikipedia/commons/4/49/Chess_qlt60.png");
    
    /**
     * Construct black Queen with parent object, Piece
     * @param x x coordinate of the piece
     * @param y y coordinate of the piece
     * @param boardSize square size of the board
     * @param teamColor color of the team.
     */
    public Queen(Color teamColor, int x, int y, int boardSize) {
        super(teamColor, blackQueen, x, y, boardSize);
    }
    
    /**
     * Construct white bishop with parent object, Piece
     * @param x x coordinate of the piece
     * @param y y coordinate of the piece
     * @param boardSize square size of the board
     * @param teamColor color of the team.
     */
    public Queen(int x, int y, int boardSize, Color teamColor) {
        super(teamColor, whiteQueen, x, y, boardSize);
    }
    
    /**
     * Check the x coordinate and y coordinate where user clicked are valid
     * @param x x coordinate where user clicked
     * @param y y coordinate where user clicked
     * @currentPlayer player who is in turn
     * @enemyPlayer enemy player
     * @return return true if there is no piece in the way and it is diagonal move or straight
     * otherwise false
     */
    public boolean isValidMove(int x, int y, Player currentPlayer, Player enemyPlayer) {
        if(currentPlayer.isAnySamePos(x, y)) {
            return false;
        }

        if((x == xPosition || y == yPosition)){
            return (isAnyBlockVertical(x, y, currentPlayer, enemyPlayer));
        }
        
        if(!isAnyBlockDiagonal(x, y, currentPlayer, enemyPlayer)) {
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
        
        if(x != xPosition && y != yPosition) {
            return false;
        }
        
        return true;
    }
    
    /**
     * Check whether there is any obstacle in the way.
     * @param x x coordinate where user clicked
     * @param y y coordinate where user clicked
     * @currentPlayer player who is in turn
     * @enemyPlayer enemy player
     * @return return true if there is no piece in the strainght way otherwise false
     */
    public boolean isAnyBlockVertical(int x, int y, Player currentPlayer, Player enemyPlayer) {
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
    
    /**
     * @param x x coordinate where user clicked
     * @param y y coordinate where user clicked
     * @currentPlayer player who is in turn
     * @enemyPlayer enemy player
     * @return return true if there is no piece in the diagonal way otherwise false
     */
    public boolean isAnyBlockDiagonal(int x, int y, Player currentPlayer, Player enemyPlayer) {
        if(xPosition < x && yPosition < y) {
            System.out.println("both greater");
            for(int i = 1; i < x - xPosition; i ++) {
                if(currentPlayer.isAnySamePos(xPosition + i, yPosition + i) || enemyPlayer.isAnySamePos(xPosition + i, yPosition + i)) {
                    return false;
                }
            }
        } else if(xPosition < x && yPosition > y) {
            System.out.println("y greater");
            for(int i = 1; i < x - xPosition; i++) {
                if(currentPlayer.isAnySamePos(xPosition + i, yPosition - i) || enemyPlayer.isAnySamePos(xPosition + i, yPosition - i)) {
                    return false;
                }
            }
            
        } else if(xPosition > x && yPosition < y) {
            System.out.println("x greater");
            for(int i = 1; i < xPosition - x; i++) {
                if(currentPlayer.isAnySamePos(xPosition - i, yPosition + i) || enemyPlayer.isAnySamePos(xPosition - i, yPosition + i)) {
                    return false;
                }
            }
            
        } else if(xPosition > x && yPosition > y) {
            System.out.println("both smaller");
            for(int i = 1; i < xPosition - x; i++) {
                if(currentPlayer.isAnySamePos(xPosition - i, yPosition - i) || enemyPlayer.isAnySamePos(xPosition - i, yPosition - i)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
}
