package org.example.Chess.pieces;

import org.example.Chess.Board;
import org.example.Chess.Color;
import org.example.Chess.Position;

public class Rook implements Piece {
    private Color color;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Rook(Color color) {
        this.color = color;
    }


    @Override
    public boolean Move(Position current, Position target, Board board) {
        int currentRow = current.getRow();
        int currentCol = current.getColumn();
        int targetRow = target.getRow();
        int targetCol = target.getColumn();
        Rook rook1 = (Rook) current.getPiece();
        Position[][] position = board.getPositions();
        if (targetRow < 0 || targetRow > 7 || targetCol < 0 || targetCol > 7)
            return false;
        if (currentRow == targetRow) {
            for (int i = currentCol; i < targetCol; i++) {
                if (position[i][targetRow].getPiece() != null) {
                    return false;
                }
            }
        }
        if (currentCol == targetCol) {
            for (int i = currentRow; i < targetRow; i++) {
                Position[][] positions = board.getPositions();
                if (positions[currentRow][i].getPiece() != null)
                    return false;

            }
        }
        if (rook1.getColor() == position[targetRow][targetCol].getPiece().getColor())
            return false;
        return true;
    }
}
