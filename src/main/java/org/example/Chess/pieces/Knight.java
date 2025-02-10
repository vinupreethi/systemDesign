package org.example.Chess.pieces;

import org.example.Chess.Board;
import org.example.Chess.Color;
import org.example.Chess.Position;

public class Knight implements Piece {
    private Color color;

    public Knight(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public boolean Move(Position current, Position target, Board board) {
        int currentRow = current.getRow();
        int currentCol = current.getColumn();

        int targetRow = target.getRow();
        int targetCol = target.getColumn();
        if (targetRow < 0 || targetRow > 7 || targetCol < 0 || targetCol > 7)
            return false;

        Position[][] positions = board.getPositions();
        if ((currentRow - 2 == targetRow || currentRow - 1 == targetRow || currentRow + 1 == targetRow || currentRow + 2 == targetRow) &&
                (currentCol - 2 == targetCol || currentCol - 1 == targetCol || currentCol + 1 == targetCol || currentCol + 2 == targetCol)) {

            if (positions[targetRow][targetCol].getPiece().getColor() != positions[currentRow][currentCol].getPiece().getColor()) {
                return true;
            }
        }
        return false;

    }
}
