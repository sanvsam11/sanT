package Interview_questions;

import java.util.Scanner;

/**
 * Created by SanthoshVarathan on 15/12/16.
 */
public class prime_checker {
    boolean checkPrime(int x){ boolean result=true;
        for(int i=2;i*i<x;i++){
            if(x%i==0){
                System.out.println("found factor at "+i);
                result=false;break;}
        }
        return result;
    }
    public static void main(String ar[]){
        prime_checker p = new prime_checker();
        int input;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number to check:");
        input = in.nextInt();
        String result_string=(p.checkPrime(input))?"Prime":"not Prime";
        System.out.println("Entered number "+input+" is "+result_string);
    }
}
