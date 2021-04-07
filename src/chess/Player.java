package chess;
import javafx.scene.Group;
import javafx.scene.paint.Color;


/**
 * Represent player in the chess game it has own pieces and have
 * ability to access pieces
 * @author sungminjin
 * @version 1.0
 */
public class Player extends Group {
    /**
     * Represent color of the team.
     */
    Color teamColor;
    
    /**
     * Pawns array.
     */
    Piece pawns[];
    
    Piece[] pieces = new Piece[16];
    
    /**
     * Construct player object with generating pieces.
     * @param teamColor color of the team
     * @param boardSize size of the square
     */
    public Player(Color teamColor, int boardSize) {
        this.teamColor = teamColor;
        System.out.println(teamColor);
        System.out.println(Color.WHITE);
        System.out.println(Color.BLUE);
        if (teamColor == Color.BLACK) {
            makeBlackPieces(boardSize);
        } else {
            makeWhitePieces(boardSize);
        }
    }
    
    /**
     * Return pawns array
     * @return pawns
     */
    public Piece[] getPawns() {
        return pawns;
    }
    
    /**
     * Make all the black pieces' objects.
     * @param boardSize size of the square
     */
    public void makeBlackPieces(int boardSize) {
        makeBlackPawns(boardSize);
        makeBlackRook(boardSize);
        makeBlackBishop(boardSize);
        makeBlackKnights(boardSize);
        makeBlackKingandQueen(boardSize);
    }
    
    /**
     * Make all the white pieces' objects
     * @param boardSize size of the square
     */
    public void makeWhitePieces(int boardSize) {
        makeWhitePawns(boardSize);
        makeWhiteRook(boardSize);
        makeWhiteBishop(boardSize);
        makeWhiteKnights(boardSize);
        makeWhiteKingandQueen(boardSize);
    }
    
    /**
     * Generate pawns by using pawn constructor
     * @param boardSize size of the square
     */
    public void makeBlackPawns(int boardSize) {
        pawns = new Pawn[8];
        for(int i = 0; i < 8; i++) {
            pawns[i] = new Pawn(Color.BLACK, i , 1, boardSize);
            pieces[i] = pawns[i];
            getChildren().addAll(pawns[i]);
        }
    }
    
    /**
     * make black Rook objects.
     * @param boardSize size of the square
     */
    public void makeBlackRook(int boardSize) {
        Piece rook = new Rook(Color.BLACK, 0, 0, boardSize);
        Piece rook2 = new Rook(Color.BLACK, 7, 0, boardSize);
        getChildren().addAll(rook);
        getChildren().addAll(rook2);
        pieces[8] = rook;
        pieces[9] = rook2;
    }

    /**
     * make black Bishop objects
     * @param boardSize size of the square
     */
    public void makeBlackBishop(int boardSize) {
        Piece bishop = new Bishop(Color.BLACK, 2, 0, boardSize);
        Piece bishop2 = new Bishop(Color.BLACK, 5, 0, boardSize);
        getChildren().addAll(bishop);
        getChildren().addAll(bishop2);
        pieces[10] = bishop;
        pieces[11] = bishop2;
    }
    
    /**
     * make black Knights objects.
     * @param boardSize size of the square
     */
    public void makeBlackKnights(int boardSize) {
        Piece knight = new Knight(Color.BLACK, 1, 0, boardSize);
        Piece knight2 = new Knight(Color.BLACK, 6, 0, boardSize);
        getChildren().addAll(knight);
        getChildren().addAll(knight2);
        pieces[12] = knight;
        pieces[13] = knight2;
    }
    
    /**
     * make black King and Queen objects.
     * @param boardSize size of the square
     */
    public void makeBlackKingandQueen(int boardSize) {
        Piece queen = new Queen(Color.BLACK, 3, 0, boardSize);
        Piece king = new King(Color.BLACK, 4, 0, boardSize);
        getChildren().addAll(king);
        getChildren().addAll(queen);
        pieces[14] = queen;
        pieces[15] = king;
    }
    
    /**
     * make white pawn objects.
     * @param boardSize size of the square
     */
    public void makeWhitePawns(int boardSize) {
        pawns = new Pawn[8];
        for(int i = 0; i < 8; i++) {
            pawns[i] = new Pawn(i , 6, boardSize, Color.WHITE);
            pieces[i] = pawns[i];
            getChildren().addAll(pawns[i]);
        }
    }
    
    /**
     * make white Rook objects.
     * @param boardSize size of the square
     */
    public void makeWhiteRook(int boardSize) {
        Piece rook = new Rook(0, 7, boardSize, Color.WHITE);
        Piece rook2 = new Rook(7, 7, boardSize, Color.WHITE);
        getChildren().addAll(rook);
        getChildren().addAll(rook2);
        pieces[8] = rook;
        pieces[9] = rook2;
    }

    /**
     * make white Bishop objects.
     * @param boardSize size of the square
     */
    public void makeWhiteBishop(int boardSize) {
        Piece bishop = new Bishop(2, 7, boardSize, Color.WHITE);
        Piece bishop2 = new Bishop(5, 7, boardSize, Color.WHITE);
        getChildren().addAll(bishop);
        getChildren().addAll(bishop2);
        pieces[10] = bishop;
        pieces[11] = bishop2;
    }
    
    /**
     * make white Knight objects
     * @param boardSize size of the square
     */
    public void makeWhiteKnights(int boardSize) {
        Piece knight = new Knight(1, 7, boardSize, Color.WHITE);
        Piece knight2 = new Knight(6, 7, boardSize, Color.WHITE);
        getChildren().addAll(knight);
        getChildren().addAll(knight2);
        pieces[12] = knight;
        pieces[13] = knight2;
    }
    
    /**
     * make white King and Queen objects
     * @param boardSize size of the square
     */
    public void makeWhiteKingandQueen(int boardSize) {
        Piece queen = new Queen(4, 7, boardSize, Color.WHITE);
        Piece king = new King(3, 7, boardSize, Color.WHITE);
        getChildren().addAll(king);
        getChildren().addAll(queen);
        pieces[14] = queen;
        pieces[15] = king;
    }
    
    
    
    /**
     * Check any piece is in same position.
     * @param x x coordinate of the board
     * @param y y coordinate of the board
     * @return true if there is one piece that is in same position at last
     * return false.
     */
    public boolean isAnySamePos(int x, int y) {
        for(Piece piece: pieces) {
            if(piece.isSamePosition(x, y)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * return pieces array which has all the pieces
     * @return pieces array
     */
    public Piece[] getPieces() {
        return pieces;
    }
}
