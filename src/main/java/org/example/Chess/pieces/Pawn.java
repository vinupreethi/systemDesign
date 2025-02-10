package org.example.Chess.pieces;

import org.example.Chess.Board;
import org.example.Chess.Color;
import org.example.Chess.Position;

public class Pawn implements Piece {
    private Color color;
    private int startPosition;


    public Pawn(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(int startPosition) {
        this.startPosition = startPosition;
    }

    @Override
    public boolean Move(Position current, Position target, Board board) {
        int currentRow = current.getRow();
        int currentCol = current.getColumn();

        int targetRow = target.getRow();
        int targetCol = target.getColumn();

        Position[][] positions = board.getPositions();
        if (targetRow < 0 || targetRow > 7 || targetCol < 0 || targetCol > 7)
            return false;
        if (currentCol == targetCol) {
            int diff = Math.abs(targetRow - currentRow);
            if ((currentRow == 1 || currentRow == 6)) {
                if (diff <= 2)
                    return true;
                else
                    return false;

            } else {
                if (diff <= 1)
                    return true;
                else
                    return false;
            }
        }
        int differenceinCol = currentCol - targetCol;
        Pawn pawns = (Pawn) positions[currentRow][currentCol].getPiece();
        if (differenceinCol == 1 && pawns.getStartPosition() == 1) {
            if (targetRow - currentRow == 1 && positions[currentRow][currentCol].getPiece().getColor() != positions[targetRow][targetCol].getPiece().getColor()) {
                return true;
            } else
                return false;

        } else if (differenceinCol == -1 && pawns.getStartPosition() == 6) {
            if (targetRow - currentRow == 1 && positions[currentRow][currentCol].getPiece().getColor() != positions[targetRow][targetCol].getPiece().getColor()) {
                return true;
            } else
                return false;
        }

        return false;
    }


}
