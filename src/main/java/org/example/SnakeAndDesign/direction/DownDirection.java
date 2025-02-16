package org.example.SnakeAndDesign.direction;

import org.example.SnakeAndDesign.Position;

public class DownDirection  implements Direction {
    @Override
    public Position move(Position  currentposition) {
        int x=currentposition.getRow();
        int y=currentposition.getColumn();
        Position target=new Position(x+1,y);
        return target;
    }
}