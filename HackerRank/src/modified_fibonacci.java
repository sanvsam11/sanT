/**
 * Created by SanthoshVarathan on 01/08/16.
 */
//import sun.security.util.BigInt;

import java.math.BigInteger;
import java.util.Scanner;
public class modified_fibonacci {
    BigInteger t1,t2;
    BigInteger m[];

    public void get_first_terms(int a,int b){
        t1=BigInteger.valueOf((long)a);t2=BigInteger.valueOf((long)b);
    }
    public BigInteger mod_fib_cal_fn_call(int n){
        m=new BigInteger[n];m[0]=t1;m[1]=t2;int i=2;
        while(i<n){m[i]=BigInteger.ZERO;i++;}
        return mod_fib_cal_fn(n-1);
    }
    public BigInteger mod_fib_cal_fn(int i){
        if(m[i]==BigInteger.ZERO)
            m[i]=mod_fib_cal_fn(i-2).add(
                    (mod_fib_cal_fn(i-1).multiply(mod_fib_cal_fn(i-1))));
        return m[i];
    }
    public static void main(String ar[]){
        modified_fibonacci mo = new modified_fibonacci();
        Scanner in = new Scanner(System.in);
        mo.get_first_terms(in.nextInt(),in.nextInt());
        //mo.get_n(in.nextInt());
        System.out.println(mo.mod_fib_cal_fn_call(in.nextInt()));
    }
}
