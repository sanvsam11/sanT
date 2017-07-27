package Sorting;

/**
 * Created by SanthoshVarathan on 04/07/17.
 */
public class BubbleSort extends Sort implements sorter {
    public int[] sort(int a[]){
        boolean sortedFlag = true;
        for(int i=0;i<a.length;i++){
            sortedFlag = true;
            for(int j=a.length-1;j>0;j--)
                if(a[j-1]>a[j]){
                    sortedFlag = false;
                    int x = a[j-1];
                    a[j-1] = a[j];
                    a[j] = x;
                }
                if(sortedFlag) return a;
        }
        return a;
    }
}
