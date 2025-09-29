package com.tic_tac_toe;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Board board = new Board();
        char currentPlayer = 'X';

        System.out.println("\n\n" + Style.titleStyle("    Bienvenid@ a nuestro juego!    "));
        System.out.println();

        board.printBoard();

        while (true) {
            String playerDisplay = Style.playerToken(currentPlayer);
            System.out.println(Style.colorPink("\n\nTurno de jugador: " + Style.colorBold(playerDisplay)));
            System.out.println();

            int row, column;

            while (true) {
                try {
                    System.out.print(Style.colorOrange("\nIngresa fila (0 al 2): "));
                    row = sc.nextInt();
                    System.out.print(Style.colorOrange("\nIngresa columna (0 al 2): "));
                    column = sc.nextInt();

                    if (row < 0 || row > 2 || column < 0 || column > 2) {
                        System.out.println("\n" + Style.colorYellow("Tienes que ingresar números del 0 al 2. Vuelve a intentarlo"));
                        continue;
                    }
                    Coordinate move = new Coordinate(row, column);
                    if (!board.makeMove(move, currentPlayer)) {
                        System.out.println(Style.colorYellow("\nEsa casilla ya está ocupada, vuelve a intentarlo"));
                        continue;
                    }
                    break;
                } catch (java.util.InputMismatchException e) {
                    System.out.println("\n" + Style.colorYellow("Solo son válidos números de 0 al 2. Vuelve a intentarlo"));
                    sc.nextLine();
                }
            }

            board.printBoard();

            if (board.checkWinner(currentPlayer)) {
                System.out.println();
                System.out.println(Style.colorBlueBold("Jugador " + currentPlayer + " ha ganado!!\n"));
                break;
            }

            if (board.isFull()) {
                System.out.println(Style.colorYellow("\n\n¡Empate! No hay más movimientos posibles."));
                board = new Board();
                currentPlayer = 'X';
                System.out.println("\n\n" + Style.titleStyle("\n¡Nueva partida!\n"));
                board.printBoard();
                continue;
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        sc.close();
    }
}
