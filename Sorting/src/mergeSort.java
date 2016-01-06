/**
 * Created by sant on 26/12/15.
 */
import java.util.*;
public class mergeSort {

    public int[] mergeSortFunction(int[] a,int l,int r){
        int x=0,d=r-l,m=(l+r)/2;
        if(d==1&&a[l]>a[r]){x=a[l];a[l]=a[r];a[r]=x;}
        else if(d==2&&(a[l]>a[l+1]||a[l+1]>a[r])){
            for(int i=l;i<=r;i++)
                for(int j=i+1;j<=r;j++)
                    if(a[i]>a[j]){x=a[i];a[i]=a[j];a[j]=x;}
        }
        else {
            a=mergeSortFunction(a,l,m);
            a=mergeSortFunction(a,m+1,r);
            if(a[m]>a[m+1])
                for(int i=m+1;i<=r;i++)
                    for(int j=m;j>=l;j--){  int k=j+1;
                        x=a[k];a[k]=a[j];a[j]=x;
                    }
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
        ob.printlist(ob.mergeSortFunction(a,0,n-1),n);
    }
}
