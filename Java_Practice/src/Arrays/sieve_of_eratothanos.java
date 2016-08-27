package Arrays;

import java.io.InputStreamReader;
import java.io.*;

/**
 * Created by SanthoshVarathan on 27/08/16.
 */
public class sieve_of_eratothanos {

    public boolean isPrime(int n){boolean isprime[]=new boolean[n+1];
        for(int i=2;i<=n;i++)isprime[i]=true;
        for(int i=2;(i*i)<=n;i++){
            if(isprime[i])
            for(int div=2*i;div<=n;div+=i){
                isprime[div]=false;
            }
        }
    return isprime[n];}
    public static void main(String ar[]) throws IOException {
        sieve_of_eratothanos s = new sieve_of_eratothanos();
        //BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        //int n = Integer.parseInt(String.valueOf(input.read()));
        //System.out.println("Result:"+s.isPrime(n));
        System.out.println("Result:"+s.isPrime(Integer.parseInt(String.valueOf(new BufferedReader(new InputStreamReader(System.in)).readLine()))));
    }
}
