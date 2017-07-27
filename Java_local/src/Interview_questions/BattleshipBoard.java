package Interview_questions;

import java.util.Random;

/**
 * Created by SanthoshVarathan on 18/12/16.
 */
public class BattleshipBoard {
    boolean board[] = new boolean[5];
    Random r = new Random();
    int hitCount=0,shotCount=0;
    BattleshipBoard(){int randomInput = r.nextInt(3);
        board[randomInput]=true;
        board[randomInput+1]=true;
        board[randomInput+2]=true;
    }
    public void attack(int attackCoordinates){
        if(board[attackCoordinates]) {
            System.out.println("Hit");board[attackCoordinates]=false;hitCount++;shotCount++;
        }
        else {System.out.println("Miss");shotCount++;}
        if(hitCount==3) System.out.println("Kill !");
    }
    public boolean targetStatus(){boolean output = false;
        for(boolean b:board){
            output = output || b;
        }
        return output;
    }
    public void printGameResult(){
        System.out.println("BattleShip\n Shots fired: "+shotCount+"\n Game "+((targetStatus())?"Lost.":"Won !"));
    }
}
