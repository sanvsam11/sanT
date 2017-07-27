package Interview_questions;

/**
 * Created by SanthoshVarathan on 12/12/16.
 */
public class mergeSort {
    void swap(int a[],int i,int j){
        int x=a[i];a[i]=a[j];a[j]=x;
    }
    void merge(int leftA[],int rightA[],int a[]){
        int il=0,ir=0;
        for(int i=0;i<a.length;i++){
                if(ir>=rightA.length||(il<leftA.length&&leftA[il]<rightA[il]))
                a[i]=leftA[il++];
            else a[i]=rightA[ir++];
        }
    }
    int[] mergeSortMethod(int[] a){int l=a.length;boolean isEvenLength = l%2==0;
        if(l<2) return a;
        else if(l==2){
            if(a[0]>a[1]) swap(a,0,1);
        }
        else{
            int m = l / 2 , leftSize, rightSize;
            if(isEvenLength) {
                leftSize = m; rightSize = m ;
            }
            else{
                 leftSize = m+1 ; rightSize = m;
            }
            int leftArray[] = new int[leftSize], rightArray[] = new int[rightSize];
            int split = (isEvenLength)?m:m+1;
            for(int i=0;i<split;i++) leftArray[i] = a[i];
            for(int i=split,j=0;i<l;i++,j++) rightArray[j] = a[i];
            leftArray=mergeSortMethod(leftArray);rightArray=mergeSortMethod(rightArray);
            merge(leftArray,rightArray,a);
        }
        return a;
    }
    public static void main(String ar[]){
        int a[]={10,9,8,7,6,5,4,3,2,1};
        mergeSort m = new mergeSort();
        a=m.mergeSortMethod(a);
        for(int i:a)System.out.print(i+" ");
    }
}
