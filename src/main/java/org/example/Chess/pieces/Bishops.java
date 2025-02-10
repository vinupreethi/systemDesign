package org.example.Chess.pieces;

import org.example.Chess.Board;
import org.example.Chess.Color;
import org.example.Chess.Position;

public class Bishops implements Piece {

    private Color color;

    public Bishops(Color color) {
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
        Position[][] position = board.getPositions();
        Bishops bishops1 = (Bishops) current.getPiece();
        int currentdifference = currentCol - currentRow;
        int currentAddition = currentCol + currentRow;

        int targetdifference = targetCol - targetRow;
        int targetAddition = targetCol + targetRow;

        if (currentdifference != targetdifference && targetAddition != currentAddition)
            return false;
        if (currentRow < targetRow && currentCol < targetCol) {
            while (currentRow < targetRow && currentCol < targetCol) {
                currentRow++;
                currentCol++;
                if (position[currentRow][currentCol] != null) {
                    return false;
                }

            }

        } else if (currentRow > targetRow && currentCol < targetCol) {
            while (currentRow > targetRow && currentCol < targetCol) {
                currentRow--;
                currentCol++;
                if (position[currentRow][currentCol] != null) {
                    return false;
                }

            }

        } else if (currentRow > targetRow && currentCol > targetCol) {
            while (currentRow > targetRow && currentCol > targetCol) {
                currentRow--;
                currentCol--;
                if (position[currentRow][currentCol] != null) {
                    return false;
                }

            }

        } else if (currentRow < targetRow && currentCol > targetCol) {
            while (currentRow < targetRow && currentCol > targetCol) {
                currentRow++;
                currentCol--;
                if (position[currentRow][currentCol] != null) {
                    return false;
                }

            }
        } else {
            return true;
        }
        if (bishops1.getColor() == position[targetRow][targetCol].getPiece().getColor())
            return false;
        return true;


    }
}
