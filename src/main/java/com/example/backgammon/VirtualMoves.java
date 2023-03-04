package com.example.backgammon;

import static java.lang.Math.abs;

public class VirtualMoves extends Board{

    public boolean testMove(int []board, int initIndex, int size){
        int isWhite = 0 ;
        int isBlack = 0 ;
        if(board[initIndex]== 0) return false ;
        else {
            if(board[initIndex] < 0)
                isWhite = -1;
            else
                isBlack = 1 ;
        }
        size = (size * isBlack) + (size * isWhite) ;
        if(initIndex + size < 0 || initIndex + size > 23)
            return false ;
        if(board[initIndex + size] * board[initIndex] < 0) {
            if(abs(board[initIndex + size]) > 1)
                return false;
        }
        return true ;
    }

    public boolean impossibleToMove(int []board, int die1, int die2, int playerCounter){
        if(playerCounter == 1 && board[24] != 0){
            if(die1 != 0 && board[24 - die1] <= 1)
                return false ;
            if(die2 != 0 && board[24 - die2] <= 1)
                return false ;
            return true ;
        }
        else if(playerCounter == -1 && board[25] != 0){
            if(die1 != 0 && board[die1 - 1] >= -1)
                return false ;
            if(die2 != 0 && board[die2 - 1] >= -1)
                return false ;
            return true;
        }
        for(int i = 0; i <= 23; i++){
            if(playerCounter == 1 && board[i] < 0){
                if(die1 != 0){
                    if(testMove(board, i, die1))
                        return false ;
                }
                if(die2 != 0){
                    if(testMove(board, i, die2))
                        return false ;
                }
            }
            else if(playerCounter == -1 && board[i] > 0){
                if(die1 != 0) {
                    if (testMove(board, i, die1))
                        return false ;
                }
                if(die2 != 0){
                    if(testMove(board, i, die2))
                        return false;
                }
            }
        }
        return true ;
    }

    public boolean isOut(int[] board, int playerCounter){
        if(board[24] != 0 && playerCounter == 1){
            return true;
        }
        if(board[25] != 0 && playerCounter  == -1){
            return true;
        }
        return false ;
    }

    public boolean testMoveInside(int []board, int size, int playerCounter){
        int initIndex;
        if (size == 0)
            return false;

        if(playerCounter == 1)    // white is currently out
        {
            if(board[24-size] > 1)
                return false;
        }
        if(playerCounter == -1)   // black is currently out
        {
            if(board[size-1] < -1)
                return false ;
        }
        return true;
    }

    public boolean canTakeOut(int []board, int playerCounter){
        if(isOut(board, playerCounter)) {
            return false;
        }
        if(playerCounter == 1){
            for(int i = 6; i <= 23; i++){
                if(board[i] < 0) {
                    return false;
                }
            }
        }
        else if(playerCounter == -1){
            for(int i = 0; i <= 17; i++)
                if(board[i] > 0) {
                    return false;
                }
        }
        return true ;
    }

    public boolean isAbleToTakePiece(int []board, int dice, int indexPiece, int playerCounter){
        if(dice == 0)
            return false ;
        if(playerCounter == 1){
            if(indexPiece > 5 || indexPiece < 0)
                return false;
            if(board[indexPiece] >= 0)
                return false ;
            if(indexPiece > dice - 1)
                return false ;
            else if(indexPiece < dice - 1){
                for(int i = indexPiece + 1; i <= 5; i++)
                    if(board[i] < 0)
                        return false ;
            }
        }
        else{
            if(indexPiece > 23 || indexPiece < 18)
                return false;
            if(board[indexPiece] <= 0)
                return false;
            if(indexPiece < 24 - dice)
                return false ;
            else if(indexPiece > 24 - dice){
                for(int i = indexPiece - 1; i >= 18; i--)
                    if(board[i] > 0)
                        return false ;
            }

        }
        return true;
    }
}
