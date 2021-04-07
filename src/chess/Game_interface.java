/**
 * 
 */
package chess;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * @author sungminjin
 * @version 1.0
 */
public class Game_interface extends Application{
    
    /**
     * Board in chess game
     */
    private Board board;
    /**
     * root of the gui.
     */
    private Group root;
    /**
     * Players in chess game
     */
    Player[] players = new Player[2];
    /**
     * chosen piece by user mouse clicked
     */
    Piece clickedPiece;
    
    /**
     * chose piece's square.
     */
    Square clickedSquare;
    
    /**
     * player who is in turn.
     */
    Player currentPlayer;
    
    /**
     * enemy player.
     */
    Player enemyPlayer;
    
    /**
     * enemey player's piece
     */
    Piece enemyPiece;
    /**
     * square size of the board
     */
    final int boardSize = 100;
    
    public void start(Stage stage) {
        board = new Board(boardSize);
        players[0] = new Player(Color.BLACK, boardSize);
        players[1] = new Player(Color.WHITE, boardSize);
        currentPlayer = players[1];
        enemyPlayer = players[0];
        root = new Group(board, players[0], players[1]);
        Scene scene = new Scene(root, 800, 800);
        scene.setOnMousePressed(this::movePiece);
        stage.setTitle("Chess");
        stage.setScene(scene);
        stage.show();
    }
   
    /**
     * Eventhandler that handles movemetns of the pieces
     * @param event mouse click
     */
    public void movePiece(MouseEvent event) {
        int choiceXPosition = (int) event.getX() / boardSize;
        int choiceYPosition = (int) event.getY() / boardSize;
        Square[][] squareGroup = board.getSquares();
        System.out.println(choiceXPosition + " " + choiceYPosition);
        if(clickedSquare != null) {
            clickedSquare.backToOwn();
            clearSquare(squareGroup);
        }
        if(currentPlayer.isAnySamePos(choiceXPosition, choiceYPosition)) {
            clickedPiece = null;
            clickedSquare = squareGroup[choiceXPosition][choiceYPosition];
            clickedSquare.clickedSquare();
            for(Piece piece : currentPlayer.getPieces()) {
                if(piece.isSamePosition(choiceXPosition, choiceYPosition)) {
                    clickedPiece = piece;
                    showValidMove(clickedPiece, currentPlayer, enemyPlayer, squareGroup);
                }
            }
        } else if (clickedPiece != null && clickedPiece.isValidMove(choiceXPosition, choiceYPosition, currentPlayer, enemyPlayer)) {
            System.out.println(choiceXPosition + " " + choiceYPosition);
            if(enemyPlayer.isAnySamePos(choiceXPosition, choiceYPosition)) {
                for(Piece piece : enemyPlayer.getPieces()) {
                    if(piece.isSamePosition(choiceXPosition, choiceYPosition)) {
                        piece.killPiece();
                    }
                }
            }
            clickedPiece.setxPosition(choiceXPosition);
            clickedPiece.setyPosition(choiceYPosition);
            clickedSquare.backToOwn();
            clickedSquare = null;
            clickedPiece = null;
            turnChange(currentPlayer);
        }
    }
    
    /**
     * Change the current user so that turn changes
     * @param player who was in turn
     */
    public void turnChange(Player player) {
        if(player == players[0]) {
            currentPlayer = players[1];
            enemyPlayer = players[0];
        } else {
            currentPlayer = players[0];
            enemyPlayer = players[1];
        }
    }
    
    /**
     * Check whether there is enemy piece in the certain point
     * @param x x coordinate 
     * @param y y coordinate
     */
    public void checkEnemy(int x, int y){
        enemyPlayer.isAnySamePos(x, y);
    }
    
    /**
     * Show the square where piece can go.
     * @param piece clicked Piece
     * @param currentPlayer player who is in turn
     * @param enemyPlayer enemy player
     * @param squareGroup board in chess game
     */
    public void showValidMove(Piece piece, Player currentPlayer, Player enemyPlayer, Square[][] squareGroup) {
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(piece.isValidMove(i, j, currentPlayer, enemyPlayer)) {
                    squareGroup[i][j].validSquare();
                }
            }
        }
    }
    
    /**
     * Get back the board to its own color.
     * @param squareGroup board in chess game.
     */
    public void clearSquare(Square[][] squareGroup) {
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                squareGroup[i][j].backToOwn();
            }
        }
    }
    
}










