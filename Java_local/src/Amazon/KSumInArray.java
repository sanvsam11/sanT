package Amazon;

import java.util.*;

/**
 * Created by SanthoshVarathan on 20/07/17.
 */

public class KSumInArray {
    public void isKSuminArray(int a[],int k){
        for(int i=0;i<a.length;i++)
            for(int j=0;j<a.length;j++){
                if(a[i]+a[j]==k)
                    System.out.print(a[i]+" "+a[j]+",");
            }
    }
    public boolean isKSuminArrayMemoized(int a[],int k){
        int rejectedPairs[][] = new int[a.length][a.length];
        for(int i=0;i<a.length;i++)
            for(int j=0;j<a.length;j++){
                if(rejectedPairs[i][j]==0){
                    if(a[i]+a[j]==k)
                        System.out.print(a[i]+" "+a[j]+",");
                    else
                        rejectedPairs[i][j]=1;
                }
            }
        return false;
    }
    public int[] generateArray(int n){
        int a[] = new int[n];
        Random r = new Random();
        for(int i=0;i<n;i++)
            a[i] = i+1;
        return a;
    }
    public int generateK(int n){
        return new Random().nextInt(2*n-1);
    }
    public static void main(String ar[]){
        KSumInArray instance = new KSumInArray();
        int n = new Scanner(System.in).nextInt();
        int a[] = instance.generateArray(n),k = instance.generateK(n);
        long startBrute = System.currentTimeMillis();
        instance.isKSuminArray(a,k);System.out.println();
        long endBruteStartMemo = System.currentTimeMillis();
        instance.isKSuminArrayMemoized(a,k);System.out.println();
        long endMemo = System.currentTimeMillis();
        System.out.println("Brute force runtime: "+(endBruteStartMemo-startBrute)+"\nMemoized Runtime:"+(endMemo-endBruteStartMemo));
    }
}
