package org.example.Chess;

import org.example.Chess.pieces.*;

import java.util.List;

public class Player {
    private Color color;
    private boolean turn;




    public boolean getTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
