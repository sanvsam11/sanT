/**
 * Created by sant on 26/12/15.
 */
import java.util.*;
public class mergeSort {

    public int[] mergeSortFunction(int[] a,int n,int l,int r){
        if(n==2&&a[l]>a[r]){int x=0;
            x=a[l];a[l]=a[r];a[r]=x;
        }
        else if(n%2==0){
            a=mergeSortFunction(a,n/2,0,(n/2)-1);
            a=mergeSortFunction(a,n/2,n/2,n-1);
        }
        else {
            a=mergeSortFunction(a,n/2,0,(n/2)-1);
            a=mergeSortFunction(a,n/2,(n/2+1),n-1);
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
        ob.printlist(ob.mergeSortFunction(a,n,0,n-1),n);
    }
}
