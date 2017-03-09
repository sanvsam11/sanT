/**
 * Created by SanthoshVarathan on 17/12/16.
 */
public class Largest_Prime_Factor {
    //long a = 600851475143L,n=a;
    public long LargestPrimeFactorMethod(long a){long n=a;boolean found = false;
        while(!found){
            if(Prime_Checker.primeCheck(n)) found = (a%n==0)?true:false;
        n--;}
        return n;
    }
    public static void main(String ar[]){
        long a = 600851475143L;
        Largest_Prime_Factor l = new Largest_Prime_Factor();
        System.out.println("Output: "+l.LargestPrimeFactorMethod(a));
    }
}
