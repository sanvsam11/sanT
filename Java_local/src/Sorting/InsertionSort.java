package Sorting;

/**
 * Created by SanthoshVarathan on 04/07/17.
 */
public class InsertionSort extends Sort implements sorter {
    public int[] sort(int a[]){
        for(int i=0;i<a.length-1;i++)
            for(int j=i+1;j>0;j--)
                if(a[j-1]>a[j]){
                    int x = a[j-1];
                    a[j-1] = a[j];
                    a[j] = x;
                }
        return a;
    }
}
