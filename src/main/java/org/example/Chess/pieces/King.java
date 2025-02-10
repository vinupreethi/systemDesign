package org.example.Chess.pieces;

import org.example.Chess.Board;
import org.example.Chess.Color;
import org.example.Chess.Position;

public class King implements Piece {
    private Color color;
    private boolean isKingMoved;

    public King(Color color) {
        this.color = color;
        this.isKingMoved = false;
    }

    @Override
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isKingMoved() {
        return isKingMoved;
    }

    public void setKingMoved(boolean kingMoved) {
        isKingMoved = kingMoved;
    }

    @Override
    public boolean Move(Position current, Position target, Board board) {
        int currentRow = current.getRow();
        int currentCol = current.getColumn();

        int targetRow = target.getRow();
        int targetCol = target.getColumn();
        Position[][] position = board.getPositions();
        if (targetRow < 0 || targetRow > 7 || targetCol < 0 || targetCol > 7)
            return false;

        if (Math.abs(targetRow - currentRow) == 1 && Math.abs(targetCol - currentCol) == 1) {
            return true;
        }
        if (isKingMoved == false) {
            if (currentRow == targetRow && currentRow == 0) {
                for (int i = currentCol; i <= targetCol; i++) {
                    if (position[currentRow][currentCol] != null) {
                        return false;
                    }
                    if (position[targetRow][targetCol + 1].getPiece() instanceof Rook)
                        return true;
                }

            } else if (currentRow == targetRow && currentCol == 7) {
                for (int i = currentCol; i <= targetCol; i++) {
                    if (position[currentRow][currentCol] != null) {
                        isKingMoved=true;
                        return false;
                    }

                }
                if (position[targetRow][targetCol - 1].getPiece() instanceof Rook) {
                    return true;
                }
            }

        }
        return false;
    }
}
