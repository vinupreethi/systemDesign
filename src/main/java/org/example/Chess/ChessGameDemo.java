package org.example.Chess;

public class ChessGameDemo {
    public static void main(String args[])
    {
        Player player1=new Player();
        Player player2=new Player();
        player2.setColor(Color.BLACK);
        player1.setColor(Color.WHITE);
        ChessGame chessGame=new ChessGame(8,player1,player2);
        chessGame.start();
    }
}
