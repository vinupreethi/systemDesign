package org.example.SnakeAndDesign;

import org.example.SnakeAndDesign.cellType.EmptyCell;

public class Board {
    Position position[][];
    int height;
    int width;

    public Board( int height, int width) {
        this.position=new Position[height][width];
        for(int i=0;i<height;i++)
        {
            for(int j=0;j<height;j++)
            {
                this.position[i][j]=new Position(i,j);
            }
        }
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void initializeBoard(int height, int width) {
        setHeight(height);
        setWidth(width);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                this.position[i][j].setCell(new EmptyCell());
            }
        }
    }

    public Position[][] getPosition() {
        return position;
    }

    public void setPosition(Position[][] position) {
        this.position = position;
    }
}
