package com.tic_tac_toe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void makeMove_places_token_when_empty_and_returns_true() {
        Board board = new Board();
        boolean result = board.makeMove(new Coordinate(0, 0), 'X');
        assertTrue(result);
        assertTrue(board.checkWinner('X') == false); 
    }

    @Test
    void makeMove_on_occupied_cell_returns_false() {
        Board board = new Board();
        assertTrue(board.makeMove(new Coordinate(1, 1), 'X'));
        assertFalse(board.makeMove(new Coordinate(1, 1), 'O'));
    }

    @Test
    void checkWinner_detects_row_win() {
        Board board = new Board();
        board.makeMove(new Coordinate(0, 0), 'X');
        board.makeMove(new Coordinate(0, 1), 'X');
        board.makeMove(new Coordinate(0, 2), 'X');
        assertTrue(board.checkWinner('X'));
    }

    @Test
    void checkWinner_detects_column_win() {
        Board board = new Board();
        board.makeMove(new Coordinate(0, 0), 'O');
        board.makeMove(new Coordinate(1, 0), 'O');
        board.makeMove(new Coordinate(2, 0), 'O');
        assertTrue(board.checkWinner('O'));
    }

    @Test
    void checkWinner_detects_diagonal_win() {
        Board board = new Board();
        board.makeMove(new Coordinate(0, 0), 'X');
        board.makeMove(new Coordinate(1, 1), 'X');
        board.makeMove(new Coordinate(2, 2), 'X');
        assertTrue(board.checkWinner('X'));
    }

    @Test
    void isFull_true_when_all_cells_filled() {
        Board board = new Board();
        char current = 'X';
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                board.makeMove(new Coordinate(r, c), current);
                current = (current == 'X') ? 'O' : 'X';
            }
        }
        assertTrue(board.isFull());
    }


}


