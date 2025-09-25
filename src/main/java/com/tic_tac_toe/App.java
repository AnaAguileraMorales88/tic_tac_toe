package com.tic_tac_toe;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Board board = new Board();
        char currentPlayer = 'X';

        System.out.println("Bienvenid@ a nuestro juego!");
  
        board.printBoard();

        while (true) {
            System.out.println("Turno de jugad@r: " + currentPlayer);
            System.out.print("Ingresa fila (0-2): ");
            int row = sc.nextInt();
            System.out.print("Ingresa columna (0-2): ");
            int column = sc.nextInt();

            Coordinate move = new Coordinate(row, column);
            if(!board.makeMove(move, currentPlayer)){
                System.out.println("Esa casilla ya está ocupada, intentálo de nuevo");
                continue;
            }
            board.printBoard();

            if(board.checkWinner(currentPlayer)){
                System.out.println(currentPlayer + " ha ganado!!");
                break;
            }

            if(board.isFull()){
                System.out.println("Empate. No hay más movimientos posibles.");
                break;
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';

        }
            sc.close();
     
    }
}
