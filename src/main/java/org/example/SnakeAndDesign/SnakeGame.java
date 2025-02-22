package org.example.SnakeAndDesign;

import org.example.LinkedIn.Post;
import org.example.SnakeAndDesign.cellType.EmptyCell;
import org.example.SnakeAndDesign.cellType.FoodCell;
import org.example.SnakeAndDesign.cellType.SnakeCell;
import org.example.SnakeAndDesign.direction.*;

import java.lang.annotation.Target;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SnakeGame {
    private Board board;
    private GameStatus gameStatus;
    private Snake snake;

    public SnakeGame(Board board, GameStatus gameStatus, Snake snake) {
        this.board = board;
        this.gameStatus = gameStatus;
        this.snake = snake;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public void start() {
        int height = 10;
        int width = 10;
        board.initializeBoard(height, width);
        generateFood(board);
        initializeSnake(snake);
        setGameStatus(GameStatus.ACTIVE);
        while (getGameStatus() != GameStatus.END) {
            printBoard();
            Position target = getUserInputDirectionOfMove(snake.getCells().get(0).GetPosition());
            int row = target.getRow() % 10;
            if (row < 0)
                row += 10;
            int column = target.getColumn() % 10;
            if (column < 0)
                column += 10;

            target.setRow(row);
            target.setColumn(column);


            if (checkIfFoodisEaten(target)) {
                generateFood(board);
                snake.grow(target, board);
            } else if (checkIfSnakeCrashed(snake, target)) {
                setGameStatus(GameStatus.END);
            } else {
                snake.move(target, board);

            }

        }
    }

    private void printBoard() {
        Position pos[][] = board.getPosition();
        for (int i = 0; i < board.getHeight(); i++) {
            for (int j = 0; j < board.getWidth(); j++) {
                if (pos[i][j].getCell() instanceof EmptyCell)
                    System.out.print(".");
                else if (pos[i][j].getCell() instanceof SnakeCell)
                    System.out.print("-");
                else
                    System.out.print("*");
            }
            System.out.println();
        }

    }

    private Position getUserInputDirectionOfMove(Position position) {
        Scanner scanner = new Scanner(System.in);
        String dir = scanner.next();
        Position target = null;
        switch (dir) {
            case "UP": {
                Direction upDirection = new UpDirection();
                target = upDirection.move(position);
                break;
            }
            case "DOWN": {
                Direction downDirection = new DownDirection();
                target = downDirection.move(position);
                break;
            }
            case "LEFT": {
                Direction leftDirection = new LeftDirection();
                target = leftDirection.move(position);
                break;
            }
            case "RIGHT": {
                Direction rightDirection = new RightDirection();
                target = rightDirection.move(position);
                break;
            }

        }
        return target;


    }


    private boolean checkIfFoodisEaten(Position target) {
        Food food = Food.getInstance();
        if (target.getRow() == food.getPosition().getRow() && target.getColumn() == food.getPosition().getColumn())
            return true;
        return false;
    }

    private boolean checkIfSnakeCrashed(Snake snake, Position target) {
        if (target.getCell() instanceof SnakeCell)
            return true;

        return false;


    }

    public void initializeSnake(Snake snake) {
        // Initialize the snake's head (Position (0, 0))
        SnakeCell snakeCell = new SnakeCell();
        Position body = new Position(0, 0);
        body.setCell(snakeCell);
        snakeCell.SetPosition(body);
        Position positions[][] = board.getPosition();
        positions[0][0] = body;

        SnakeCell snakeCell1 = new SnakeCell();
        Position head = new Position(0, 1);
        head.setCell(snakeCell1);
        snakeCell1.SetPosition(head);

        positions[0][1] = head;
        LinkedList<SnakeCell> snakeCellList = snake.getCells();
        snakeCellList.add(snakeCell);
        snakeCellList.add(snakeCell1);


        snake.setCells(snakeCellList);

    }

    private void generateFood(Board board) {
        Position positions[][] = board.getPosition();
        Food food = Food.getInstance();
        if (food.getPosition() != null) {
            Position currentPosition = food.getPosition();
            positions[currentPosition.getRow()][currentPosition.getColumn()].setCell(new EmptyCell());
        }
        while (true) {
            int foodpos1 = new Random().nextInt(board.getWidth());
            int foodpos2 = new Random().nextInt(board.getHeight());
            FoodCell foodCell = new FoodCell();
            if ((positions[foodpos1][foodpos2].getCell() instanceof EmptyCell)) {
                positions[foodpos1][foodpos2].setCell(new FoodCell());
                Position position = new Position(foodpos1, foodpos2);
                position.setCell(foodCell);
                food.setPosition(position);
                break;
            }
        }
    }
}
