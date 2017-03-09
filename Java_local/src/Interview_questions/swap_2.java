package Interview_questions;

/**
 * Created by SanthoshVarathan on 15/12/16.
 */
public class swap_2 {
    void swapMethod(Integer a,Integer b){int a_p = a, b_p = b;
        a_p = a_p ^ b_p;
        b_p = a_p ^ b_p;
        a_p = a_p ^ b_p;
        a=a_p;b=b_p;
    }
    public static void main(String ar[]){
        Integer a=2,b=3;
        //new swap_2().swapMethod(a,b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("A: "+a+" B: "+b);
    }
}
