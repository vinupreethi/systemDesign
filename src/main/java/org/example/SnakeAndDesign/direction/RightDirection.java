package org.example.SnakeAndDesign.direction;

import org.example.SnakeAndDesign.Position;

public class RightDirection implements Direction {
    @Override
    public Position move(Position currentposition) {
        int x=currentposition.getRow();
        int y=currentposition.getColumn();
        Position target=new Position(x,y+1);
        return target;
    }
}
