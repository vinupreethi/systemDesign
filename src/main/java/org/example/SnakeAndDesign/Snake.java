package org.example.SnakeAndDesign;

import org.example.SnakeAndDesign.cellType.Cell;
import org.example.SnakeAndDesign.cellType.EmptyCell;
import org.example.SnakeAndDesign.cellType.SnakeCell;
import org.example.SnakeAndDesign.direction.Direction;
import org.example.SnakeAndDesign.direction.RightDirection;

import java.util.LinkedList;

public class Snake {
    private LinkedList<SnakeCell> cells;
    private Direction direction;

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    Snake() {
        this.cells = new LinkedList<>();
        this.direction = new RightDirection();
    }

    public LinkedList<SnakeCell> getCells() {
        return cells;
    }

    public void setCells(LinkedList<SnakeCell> cells) {
        this.cells = cells;
    }


    public void move(Position position, Board board) {
        Position position1[][] = board.getPosition();

        Position lastposition = cells.getLast().GetPosition();
        position1[lastposition.getRow()][lastposition.getColumn()].setCell(new EmptyCell());

        SnakeCell snakeCell = new SnakeCell();
        snakeCell.SetPosition(position);

        cells.addFirst(snakeCell);
        cells.removeLast();

        position1[position.getRow()][position.getColumn()].setCell(snakeCell);
    }

    public void grow(Position target,Board board) {
        Position position1[][] = board.getPosition();
        SnakeCell snakeCell = new SnakeCell();
        snakeCell.SetPosition(target);
        cells.add(new SnakeCell());
        position1[target.getRow()][target.getColumn()].setCell(snakeCell);
    }
}
