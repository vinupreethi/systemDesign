package org.example.Chess.pieces;

import org.example.Chess.Board;
import org.example.Chess.Color;
import org.example.Chess.Position;

public interface Piece {
    boolean Move(Position current, Position target, Board board);
    Color getColor();
}
