package Interview_questions;

import java.util.Scanner;

/**
 * Created by SanthoshVarathan on 18/12/16.
 */
public class BattleShipTester {
    public static void main(String ar[]){
        int userInput;
        Scanner in = new Scanner(System.in);
        BattleshipBoard b = new BattleshipBoard();
        for(int i=0;i<3;i++)
        {
            userInput=in.nextInt();
            b.attack(userInput);
        }
        b.printGameResult();
    }
}
