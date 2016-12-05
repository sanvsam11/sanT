package Threads;

/**
 * Created by SanthoshVarathan on 05/12/16.
 */
public class MergeSort_Thread implements Runnable{
    int a[],s=0,e=0,l=0;
    MergeSort_Thread(int[] a){
        this.a = a;l=a.length;e=l-1;
    }
    boolean compare(int i,int j){
        return (a[i]>a[j])?true:false;
    }
    void swap(int i,int j){
        int x=a[i];
        a[i]=a[j];
        a[j]=x;
    }
    void mergeSort(){
        if(l<2) return;
        else if(l==3){

        }
    }
    public void run(){
        mergeSort();
    }
    public static void main(String ar[]){
        int a[]={10,9,8,7,6,5,4,3,2,1};
        Thread t = new Thread(new MergeSort_Thread(a));
        t.start();
        try {
            t.join();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        for(int i:a)System.out.print(i+" ");
    }
}
