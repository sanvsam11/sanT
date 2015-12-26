/**
 * Created by sant on 26/12/15.
 */
import java.util.*;
public class mergeSort {

    public int[] mergeSortFunction(int[] a,int n){
        if(n%2==0&&n>2){

        }
        return a;}
    public void printlist(int[] a,int n){
        for(int i=0;i<n;i++)System.out.println(a[i]);
    }
    public static void main(String ar[]){
        mergeSort ob = new mergeSort();
        Scanner in = new Scanner (System.in);
        System.out.println("Enter the number of elements to be sorted");
        int n = in.nextInt(),a[]=new int[n];
        for(int i=0;i<n;i++)a[i]=in.nextInt();
        ob.printlist(ob.mergeSortFunction(a,n),n);
    }
}
