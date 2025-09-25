package com.tic_tac_toe;

public class Board {
    private Box [][] grid;

    public Board () {
        grid = new Box [3] [3];
        for (int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++) {
                grid [i] [j] = new Box();
            }
        }

    }
    public void printBoard() {
        System.out.println("    0    1    2  ");
        System.out.println("  -----+----+-----");
        for (int i = 0; i < 3; i++){
            System.out.print(i + " | ");
            for (int j = 0; j < 3; j++) {
                char val = grid [i][j].getValue();
                String contString = (val == ' ') ? " " : String.valueOf(val);
                System.out.print(" " + contString + " | ");
            }
            System.out.println();
            if (i < 2 ) System.out.println("  -----+----+-----");   
    }
}
    public boolean makeMove(Coordinate coor, char player){
        if (grid[coor.getRow()][coor.getColumn()].isEmpty()){
           grid[coor.getRow()][coor.getColumn()].setValue(player);
           
           return true;
        }
           return false;
    }



}

