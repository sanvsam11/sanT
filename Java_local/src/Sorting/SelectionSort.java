package Sorting;

/**
 * Created by SanthoshVarathan on 04/07/17.
 */
public class SelectionSort extends Sort implements sorter {
    public int[] sort(int a[]){
        for(int i=0;i<a.length;i++){
            int minIndex = i;
            for(int j=i+1;j<a.length;j++)
                if(a[minIndex]>a[j]) minIndex = j;
            int x = a[i];
            a[i] = a[minIndex];
            a[minIndex] = x;
        }
        return a;
    }
}
