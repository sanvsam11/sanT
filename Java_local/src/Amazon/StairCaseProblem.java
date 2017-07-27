package Amazon;

import java.util.Scanner;

/**
 * Created by SanthoshVarathan on 24/07/17.
 */
public class StairCaseProblem {
    int countWaysMethod(int position,int n){
        if(position==n)
            return 1;
        else if(position>n)
            return 0;
        else
            return countWaysMethod(position+1,n)+countWaysMethod(position+2,n)+countWaysMethod(position+3,n);
    }
    public static void main(String ar[]){
        int n = new Scanner(System.in).nextInt();
        System.out.println("No:of ways of climbing "+n+" Steps is:"+new StairCaseProblem().countWaysMethod(0,n));
    }
}
