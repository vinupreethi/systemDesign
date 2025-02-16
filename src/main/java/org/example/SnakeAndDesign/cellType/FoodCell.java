package org.example.SnakeAndDesign.cellType;

import org.example.SnakeAndDesign.Position;

public class FoodCell implements Cell {
    private Position position;

    @Override
    public Position GetPosition() {
        return position;
    }

    @Override
    public void SetPosition(Position position) {
        this.position=position;
    }
}
