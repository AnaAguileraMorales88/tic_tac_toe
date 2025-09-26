package com.tic_tac_toe;

public class Board {
    private Box[][] grid;

    public Board() {
        grid = new Box[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = new Box();
            }
        }

    }

    public void printBoard() {
        System.out.println("    0    1    2  ");
        System.out.println("  -----+----+-----");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " | ");
            for (int j = 0; j < 3; j++) {
                char val = grid[i][j].getValue();
                String token = (val == ' ') ? " " : Style.playerToken(val);
                System.out.print(" " + token + " | ");
            }
            System.out.println();
            if (i < 2)
                System.out.println("  -----+----+-----");
        }
    }

    public boolean makeMove(Coordinate coor, char player) {
        if (grid[coor.getRow()][coor.getColumn()].isEmpty()) {
            grid[coor.getRow()][coor.getColumn()].setValue(player);

            return true;
        }
        return false;
    }

    public boolean checkWinner(char player) {
        // rows and columns
        for (int i = 0; i < 3; i++) {
            if (lineMatch(player, grid[i][0], grid[i][1], grid[i][2])) return true;
            if (lineMatch(player, grid[0][i], grid[1][i], grid[2][i])) return true;
        }
        // diagonals
        if (lineMatch(player, grid[0][0], grid[1][1], grid[2][2])) return true;
        if (lineMatch(player, grid[0][2], grid[1][1], grid[2][0])) return true;
        return false;
    }

    private boolean lineMatch(char player, Box a, Box b, Box c) {
        return a.getValue() == player && b.getValue() == player && c.getValue() == player;
    }

    public boolean isFull() {
        for (int i=0; i <3; i++)
        for (int j=0; j <3; j++)
        if (grid[i][j].isEmpty()) return false;
        return true;
    }

}
