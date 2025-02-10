package org.example.Chess;


import org.example.Chess.pieces.*;

import java.util.Scanner;

public class ChessGame {
    private Board board;
    private Player player1;
    private Player player2;
    private ChessGameStatus chessGameStatus;

    ChessGame(int size, Player player1, Player player2) {
        board = new Board(size, size);
        this.player1 = player1;
        this.player2 = player2;

    }

    public void start() {
        initializeBoard(board);
        player1.setTurn(true);
        player2.setTurn(false);
        chessGameStatus = ChessGameStatus.ACTIVE;
        playGame(player1, player2);
    }

    private void playGame(Player player1, Player player2) {
        while (chessGameStatus == ChessGameStatus.ACTIVE) {
            if (player1.getTurn() == true) {
                Position position = getPlayerMove(player1);
                player2.setTurn(true);
                player1.setTurn(false);
                if (position != null) {
                    if (position.getPiece() instanceof King) {
                        chessGameStatus = ChessGameStatus.WHITE_WIN;
                    }
                    if (position.getPiece() instanceof Bishops) {
                        System.out.println("Defeated bishop ");
                    } else if (position.getPiece() instanceof Knight) {
                        System.out.println("Defeated Knight");
                    } else if (position.getPiece() instanceof Pawn) {
                        System.out.println("Defeated Pawn ");
                    } else if (position.getPiece() instanceof Queen) {
                        System.out.println("Defeated Queen");
                    } else if (position.getPiece() instanceof Rook) {
                        System.out.println("Defeated Rook ");
                    }
                }
                if (CheckKingsMate(position, board)) {
                    Piece piece = position.getPiece();
                    Color color = piece.getColor();
                    Position position1 = FindKingsPosition(color);
                    if (piece.Move(position1, position1, board)) {
                        System.out.println("King is in checkmate");
                    } else {
                        System.out.println("Its not a checkmate");
                    }
                }


            } else if (player2.getTurn() == true) {

                Position position = getPlayerMove(player1);
                player2.setTurn(false);
                player1.setTurn(true);
                if (position != null) {
                    if (position.getPiece() instanceof King) {
                        chessGameStatus = ChessGameStatus.BLACK_WIN;
                    }
                    if (position.getPiece() instanceof Bishops) {
                        System.out.println("Defeated bishop ");
                    } else if (position.getPiece() instanceof Knight) {
                        System.out.println("Defeated Knight");
                    } else if (position.getPiece() instanceof Pawn) {
                        System.out.println("Defeated Pawn ");
                    } else if (position.getPiece() instanceof Queen) {
                        System.out.println("Defeated Queen");
                    } else if (position.getPiece() instanceof Rook) {
                        System.out.println("Defeated Rook ");
                    }
                }
            }


        }


    }

    private Position FindKingsPosition(Color color) {
        Position[][] kings = board.getPositions();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (kings[i][j].getPiece() instanceof King && kings[i][j].getPiece().getColor() != color)
                    return kings[i][j];

            }
        }
        return null;
    }

    private boolean CheckKingsMate(Position position, Board board) {
        Position[][] positions = board.getPositions();
        Piece piece = position.getPiece();
        Color color = piece.getColor();
        Position position1 = FindKingsPosition(color);
        if (piece.Move(position1, position1, board)) {
            System.out.println("King is in checkmate");
            return true;
        }
        return false;
    }

    private Position getPlayerMove(Player player) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter source row: ");
        int sourceRow = scanner.nextInt();
        System.out.print("Enter source column: ");
        int sourceCol = scanner.nextInt();
        System.out.print("Enter destination row: ");
        int destRow = scanner.nextInt();
        System.out.print("Enter destination column: ");
        int destCol = scanner.nextInt();
        Piece piece = board.getPiece(sourceRow, sourceCol);
        if (piece == null || piece.getColor() != player.getColor()) {
            throw new IllegalArgumentException("Invalid piece selection!");
        }
        Position source = new Position(piece, sourceRow, sourceCol);
        Position destination = new Position(piece, destRow, destCol);
        if (source.getPiece() instanceof King && sourceRow == 0) {
            Piece piece1 = board.getPiece(0, 7);
            board.setPiece(0, 7, null);
            board.setPiece(0, 5, piece1);
            System.out.println("Castling is done");

        } else if (source.getPiece() instanceof King && sourceRow == 7) {
            Piece piece1 = board.getPiece(7, 0);
            board.setPiece(7, 0, null);
            board.setPiece(7, 5, piece1);
            System.out.println("Castling is done");
        }
        if (piece.Move(source, destination, board)) {
            return destination;
        }

        return null;
    }


    private void initializeBoard(Board board) {
        Position[][] positions = board.getPositions();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                positions[i][j] = new Position(null, 0, 0);
            }
        }
        Piece rook = new Rook(Color.BLACK);
        positions[0][0] = new Position(rook, 0, 0);
        Piece knight = new Knight(Color.BLACK);
        positions[0][1] = new Position(knight, 0, 1);
        Piece bishop = new Bishops(Color.BLACK);
        positions[0][2] = new Position(bishop, 0, 2);
        Piece queen = new Queen(Color.BLACK);
        positions[0][3] = new Position(queen, 0, 3);
        Piece king = new King(Color.BLACK);
        positions[0][4] = new Position(king, 0, 4);
        Piece bishop1 = new Bishops(Color.BLACK);
        positions[0][5] = new Position(bishop1, 0, 5);
        Piece knight1 = new Knight(Color.BLACK);
        positions[0][6] = new Position(knight1, 0, 6);
        Piece rook1 = new Rook(Color.BLACK);
        positions[0][7] = new Position(rook1, 0, 7);


        for (int i = 0; i < 8; i++) {
            Pawn pawn = new Pawn(Color.BLACK);
            positions[0][i] = new Position(pawn, 1, i);
        }

        Piece rook11 = new Rook(Color.WHITE);
        positions[7][0] = new Position(rook11, 7, 0);
        Piece knight11 = new Knight(Color.WHITE);
        positions[7][1] = new Position(knight11, 7, 1);
        Piece bishop11 = new Bishops(Color.WHITE);
        positions[7][2] = new Position(bishop11, 7, 2);
        Piece queen11 = new Queen(Color.WHITE);
        positions[7][3] = new Position(queen11, 7, 3);
        Piece king11 = new King(Color.WHITE);
        positions[7][4] = new Position(king11, 7, 4);
        Piece bishop12 = new Bishops(Color.WHITE);
        positions[7][5] = new Position(bishop12, 7, 5);
        Piece knight12 = new Knight(Color.WHITE);
        positions[7][6] = new Position(knight12, 7, 6);
        Piece rook12 = new Rook(Color.WHITE);
        positions[7][7] = new Position(rook12, 7, 7);

        for (int i = 0; i < 8; i++) {
            Pawn pawn = new Pawn(Color.WHITE);
            positions[7][i] = new Position(pawn, 7, i);
        }


    }
}
