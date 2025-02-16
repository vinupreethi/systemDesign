package org.example.SnakeAndDesign;

public class SnakeAndDesignDemo {
    public static void main(String args[])
    {
        Board board=new Board(10,10);
        GameStatus gameStatus=GameStatus.ACTIVE;
        Snake snake=new Snake();
        SnakeGame snakeGame=new SnakeGame(board,gameStatus,snake);
        snakeGame.start();
    }

}
