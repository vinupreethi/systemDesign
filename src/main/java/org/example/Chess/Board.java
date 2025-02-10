package org.example.Chess;


import org.example.Chess.pieces.Piece;

public class Board {
    private int totalrow;
    private int totalcol;
    Position[][] positions;

    public Position[][] getPositions() {
        return positions;
    }

    public void setPositions(Position[][] positions) {
        this.positions = positions;
    }

    public Board(int totalrow, int totalcol) {
        this.totalrow = totalrow;
        this.totalcol = totalcol;
        this.positions=new Position[8][8];

    }

    public int getTotalrow() {
        return totalrow;
    }

    public void setTotalrow(int totalrow) {
        this.totalrow = totalrow;
    }

    public int getTotalcol() {
        return totalcol;
    }

    public void setTotalcol(int totalcol) {
        this.totalcol = totalcol;
    }


    public Piece getPiece(int sourceRow, int sourceCol) {
        return positions[sourceRow][sourceCol].getPiece();
    }

    public void setPiece(int sourceRow, int sourceCol,Piece piece) {
         positions[sourceRow][sourceCol].setPiece(piece);
    }
}
