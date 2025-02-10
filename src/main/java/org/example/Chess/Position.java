package org.example.Chess;

import org.example.Chess.pieces.Piece;

public class Position {
    private Piece piece;
    private int row;
    private int column;


    public Position(Piece piece, int row, int column) {
        this.piece=piece;
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
