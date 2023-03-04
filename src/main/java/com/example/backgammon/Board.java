package com.example.backgammon;

public class Board {
    protected int [] board;
    protected int [][] grid;


    public int[][] getGrid() {
        return grid;
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }

    public int[] getBoard() {
        return board;
    }

    public void setBoard(int[] board) {
        this.board = board;
    }

    public void initBoard(){
        board[0] = 2;
        board[5] = -5;
        board[7] = -3;
        board[11] = 5;
        board[12] = -5;
        board[16] = 3;
        board[18] = 5;
        board[23] = -2;
    }
    // the gridpane interpreter
    public void matching(){
        grid[0][12] = 0;
        grid[0][11]= 1;
        grid[0][10] = 2;
        grid[0][9] = 3;
        grid[0][8] = 4;
        grid[0][7] = 5;
        grid[0][5] = 6;
        grid[0][4] = 7;
        grid[0][3] = 8;
        grid[0][2] = 9;
        grid[0][1] = 10;
        grid[0][0] = 11;
        grid[2][0] = 12;
        grid[2][1] = 13;
        grid[2][2] = 14;
        grid[2][3] = 15;
        grid[2][4] = 16;
        grid[2][5] = 17;
        grid[2][7] = 18;
        grid[2][8] = 19;
        grid[2][9] = 20;
        grid[2][10] = 21;
        grid[2][11] = 22;
        grid[2][12] = 23;
        grid[2][6] = 24;  // white out
        grid[0][6] = 25;  // black out
    }
}