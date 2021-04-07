package chess;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
/**
 * Represent pawn in the chess game.
 * @author sungminjin
 * @version 1.0
 */
public class Pawn extends Piece{
    
    /**
     * black pawn image with url
     */
    static Image blackPawn = new Image("https://upload.wikimedia.org/wikipedia/commons/c/cd/Chess_pdt60.png");
    
    /**
     * white pawn image with url
     */
    static Image whitePawn = new Image("https://upload.wikimedia.org/wikipedia/commons/0/04/Chess_plt60.png");
    /**
     * Construct black pawn object with parent class, Piece
     * @param teamColor color of the team
     * @param img image url of the pawn
     * @param x x coordinate
     * @param y y coordinate
     * @param boardSize size of the square
     */
    public Pawn(Color teamColor, int x, int y, int boardSize) {
        super(teamColor, blackPawn, x, y, boardSize);
    }
    
    /**
     * Construct white pawn object with parent class, Piece
     * @param teamColor color of the team
     * @param img image url of the pawn
     * @param x x coordinate
     * @param y y coordinate
     * @param boardSize size of the square
     */
    public Pawn(int x, int y, int boardSize, Color teamColor) {
        super(teamColor, whitePawn, x, y, boardSize);
    }
    
    /**
     * Check the x coordinate and y coordinate where user clicked are valid
     * @param x x coordinate where user clicked
     * @param y y coordinate where user clicked
     * @currentPlayer player who is in turn
     * @enemyPlayer enemy player
     * @return return true if it valid move for pawn
     */
    public boolean isValidMove(int x, int y, Player currentPlayer, Player enemyPlayer) {
        if(currentPlayer.isAnySamePos(x, y)) {
            return false;
        }
        
        if (teamColor == Color.BLACK) {
            return isBlackValidMove(x, y, currentPlayer, enemyPlayer);
        } else {
            return isWhiteValidMove(x, y, currentPlayer, enemyPlayer);
        }
    }
    
    /**
     * Check the x coordinate and y coordinate where user clicked are valid
     * @param x x coordinate where user clicked
     * @param y y coordinate where user clicked
     * @currentPlayer player who is in turn
     * @enemyPlayer enemy player
     * @return return true if it valid move for black pawn
     */
    public boolean isBlackValidMove(int x, int y, Player currentPlayer ,Player enemyPlayer) {
        if(enemyPlayer.isAnySamePos(xPosition -1, yPosition + 1) && xPosition -1 == x && yPosition + 1 == y) {
            return true;
        } else if(enemyPlayer.isAnySamePos(xPosition + 1, yPosition + 1) && xPosition + 1 == x && yPosition + 1 == y) {
            return true;
        }
        if(xPosition == x && yPosition + 2 == y && (enemyPlayer.isAnySamePos(xPosition, yPosition +1) 
                || currentPlayer.isAnySamePos(xPosition, yPosition + 1))) {
            return false;
        }
        
        if((xPosition == x && yPosition + 1 == y) ||(xPosition == x && yPosition == 1 && yPosition + 2 == y)) {
            if(enemyPlayer.isAnySamePos(x, y)) {
                return false;
            }
            return true;
        }
        return false;
    }
    

    /**
     * Check the x coordinate and y coordinate where user clicked are valid
     * @param x x coordinate where user clicked
     * @param y y coordinate where user clicked
     * @currentPlayer player who is in turn
     * @enemyPlayer enemy player
     * @return return true if it valid move for white pawn
     */
    public boolean isWhiteValidMove(int x, int y, Player currentPlayer, Player enemyPlayer) {
        if(enemyPlayer.isAnySamePos(xPosition -1, yPosition -1) && xPosition -1 == x && yPosition - 1 == y) {
            return true;
        } else if(enemyPlayer.isAnySamePos(xPosition +1, yPosition -1) && xPosition +1 == x && yPosition -1 == y) {
            return true;
        }
        if(xPosition == x && yPosition - 2 == y && (enemyPlayer.isAnySamePos(xPosition, yPosition -1)
                || currentPlayer.isAnySamePos(xPosition, yPosition - 1))) {
            return false;
        }
        
        if((xPosition == x && yPosition - 1 == y) || (xPosition == x && yPosition == 6 && yPosition - 2 == y)) {
            if(enemyPlayer.isAnySamePos(x, y)) {
                return false;
            }
            return true;
        }
        return false;
    }
}
