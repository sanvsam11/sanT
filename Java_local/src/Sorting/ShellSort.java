package Sorting;

/**
 * Created by SanthoshVarathan on 04/07/17.
 */
public class ShellSort extends Sort implements sorter {
    public int[] ksort(int a[],int k){
        for(int i=0;i<k;i++)
            for(int j=i+k;j<a.length;j+=k){         //implement insertion sort here
                if(a[j-k]>a[j]){
                    int x = a[j-k];
                    a[j-k] = a[j];
                    a[j] = x;
                }
            }
        return a;
    }
    public int[] sort(int a[]){
        int k=  a.length/2;
        while(k>0){
            a = ksort(a,k);
            k/=2;
        }
        return  a;
    }
}
