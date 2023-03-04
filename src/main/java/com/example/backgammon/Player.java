package com.example.backgammon;

public class Player extends VirtualMoves{

    public int[] makeMove(int [] board, int initIndex, int size){
        if(testMove(board,initIndex, size)){
            if(board[initIndex] < 0){
                size = -1 * size ;
                board[initIndex] ++ ;
                if(board[initIndex + size] == 1){
                    board[25] ++ ;    // black out
                    board[initIndex + size] = -1;
                }
                else {
                    board[initIndex + size]--;
                }
            }
            else {
                board[initIndex] -- ;
                if(board[initIndex + size] == -1){
                    board[24] --;      // white out
                    board[initIndex + size] = 1 ;
                }
                else {
                    board[initIndex + size] ++ ;
                }
            }
        }
        return board ;
    }
    public int[] makeMoveInside(int[] board, int size, int playerCounter){
        if(testMoveInside(board, size, playerCounter)){
            if(playerCounter == 1){
                if(board[24 - size] == 1){
                    board[24 - size] = -1 ;
                    board[25]++ ;
                }
                else {
                    board[24 - size] -- ;
                }
                board[24] ++ ;
            }
            else {
                size = size * playerCounter * (-1) ;
                if(board[size-1] == -1){
                    board[size-1] = 1;
                    board[24] -- ;
                }
                else{
                    board[size-1] ++ ;
                }
                board[25] -- ;
            }
        }
        return board;
    }

    public int[] takePieceOut2(int []board, int size, int playerCounter){
        if(playerCounter == 1){
            if(board[size - 1] < 0)
                board[size - 1] ++ ;
            else{
                for(int i=size-1; i>=0; i--){
                    if(board[i] < 0)
                    {
                        board[i] ++;
                        break;
                    }
                }
            }
        }
        else {
            if(board[24 - size] > 0)
                board[24 - size] -- ;
            else {
                for(int i=24-size; i<=23; i++)
                    if(board[i] > 0){
                        board[i]--;
                        break;
                    }
            }
        }
        return board;
    }
}