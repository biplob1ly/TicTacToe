/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author USER
 */
public class TttGame {

    private char mBoard[];
    private final static int BOARD_SIZE = 9;
    public static final char YOU = '0';
    public static final char AGENT = 'X';
    public static final char EMPTY_SPACE = ' ';
    private ArrayList<Integer> blankPositions;
    private static int best=-1;
    //private Random mRand;

    public static int getBOARD_SIZE() {
        return BOARD_SIZE;
    }

    public TttGame() {

        mBoard = new char[BOARD_SIZE];

        for (int i = 0; i < BOARD_SIZE; i++) {
            mBoard[i] = EMPTY_SPACE;
        }

    }

    public void clearBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            mBoard[i] = EMPTY_SPACE;
        }
    }

    public ArrayList<Integer> getBlankPositions() {
        blankPositions = new ArrayList<Integer>();
        for (int i = 0; i < 9; i++) {
            if (mBoard[i] == EMPTY_SPACE) {
                blankPositions.add(i);
            }
        }
        return blankPositions;
    }

    public void setMove(char player, int location) {
        mBoard[location] = player;
    }


    public int alphabeta(){
        MAX_VALUE(0,Integer.MIN_VALUE,Integer.MAX_VALUE);
        int choice=best;
        best=-1;
        return choice;
    }
    

     public int MAX_VALUE(int state,int alpha,int beta){
        if(isGameOver()){
            return checkForWinner();
        }
        int v=Integer.MIN_VALUE;
        ArrayList<Integer> positions = getBlankPositions();
        for(int i=0; i<positions.size(); i++){
                int pos = positions.get(i);
                setMove(AGENT, pos);
                int currentChildResult = MIN_VALUE(state+1, alpha, beta);
                if(currentChildResult > v){
                    v=currentChildResult;
                    if(state==0)best=pos;
                }
                mBoard[pos] = EMPTY_SPACE;
                if(v >= beta)return v;
                alpha = Math.max(alpha, v);   
        }
        return v;
    }
    public int MIN_VALUE(int state,int alpha,int beta){
        if(isGameOver()){
            return checkForWinner();
        }
        int v=Integer.MAX_VALUE;
        ArrayList<Integer> positions = getBlankPositions();
        for(int i=0; i<positions.size(); i++){
                int pos = positions.get(i);
                setMove(YOU, pos);
                int currentChildResult = MAX_VALUE(state+1, alpha, beta);

                v = Math.min(v, currentChildResult);
               
                mBoard[pos] = EMPTY_SPACE;
                if(v <= alpha)return v;
                beta = Math.min(beta, v);
                
                 
           
        }
        return v;
    }  
    
    public int checkForWinner() {
        for (int i = 0; i <= 6; i += 3) {
            if (mBoard[i] == YOU
                    && mBoard[i + 1] == YOU
                    && mBoard[i + 2] == YOU) {
                return -1;
            }
            if (mBoard[i] == AGENT
                    && mBoard[i + 1] == AGENT
                    && mBoard[i + 2] == AGENT) {
                return 1;
            }
        }

        for (int i = 0; i <= 2; i++) {
            if (mBoard[i] == YOU
                    && mBoard[i + 3] == YOU
                    && mBoard[i + 6] == YOU) {
                return -1;
            }
            if (mBoard[i] == AGENT
                    && mBoard[i + 3] == AGENT
                    && mBoard[i + 6] == AGENT) {
                return 1;
            }
        }

        if ((mBoard[0] == YOU
                && mBoard[4] == YOU
                && mBoard[8] == YOU)
                || mBoard[2] == YOU
                && mBoard[4] == YOU
                && mBoard[6] == YOU) {
            return -1;
        }
        if ((mBoard[0] == AGENT
                && mBoard[4] == AGENT
                && mBoard[8] == AGENT)
                || mBoard[2] == AGENT
                && mBoard[4] == AGENT
                && mBoard[6] == AGENT) {
            return 1;
        }

        for (int i = 0; i < getBOARD_SIZE(); i++) {
            if (mBoard[i] != YOU && mBoard[i] != AGENT) {
                return 2;  //still playing
            }
        }

        return 0;   //tie
    }


    public boolean isGameOver() {
        if (checkForWinner() == 1 || checkForWinner() == 0 || checkForWinner() == -1) {
            return true;
        } else {
            return false;
        }
    }

}
