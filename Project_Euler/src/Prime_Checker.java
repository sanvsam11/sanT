/**
 * Created by SanthoshVarathan on 17/12/16.
 */
public class Prime_Checker {

    public static boolean primeCheck(long number){
        for(int i=2;(i*i)<number;i++) if(number%i==0) return false;
        return true;
    }
}
