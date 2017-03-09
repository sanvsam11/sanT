package Threads;

/**
 * Created by SanthoshVarathan on 11/12/16.
 */
public class mergeSortThreaded_copy implements Runnable{
    int a[],length;
    mergeSortThreaded_copy(int ar[]){
        a=ar;length=a.length;
    }
    synchronized boolean isGreater(int i,int j){
        return (a[i]>a[j]);
    }
    synchronized void swap(int i,int j){
        int k = a[i];
        a[i] = a[j];
        a[j]= k;
    }
    void merge(int leftArray[],int rightArray[],boolean evenLength){int i=0,l_i=0,r_i=0;
       if((leftArray.length+rightArray.length)==length)
           while(i<length){l_i++;r_i++;if(evenLength&&l_i==length/2)break;else if(l_i>length/2)break;
               int v_l=leftArray[l_i],v_r=rightArray[r_i];
               if(v_l<v_r){a[i++]=v_l;a[i++]=v_r;}
               else{a[i++]=v_r;a[i++]=v_l;}
           }
    }
    void mergesort(){
        if(length<2) return;
        else if(length==2) {if(isGreater(0,1)) swap(0,1);}
        else{
            int m = length/2;boolean evenLength = length%2==0;
            int leftArray[],rightArray[];
            if(evenLength){
            leftArray=new int[m];rightArray=new int[m];
                for(int i=0;i<m;i++) leftArray[i]=a[i];
                for(int i=m,r_i=0;i<length;i++,r_i++) rightArray[r_i]=a[i];
            }
            else{
                leftArray=new int[m+1];rightArray=new int[m];
                for(int i=0;i<=m;i++) leftArray[i]=a[i];
                for(int i=m+1,r_i=0;i<length;i++) rightArray[r_i]=a[i];
            }
            mergeSortThreaded_copy left = new mergeSortThreaded_copy(leftArray);
            mergeSortThreaded_copy right = new mergeSortThreaded_copy(rightArray);
            Thread leftThread = new Thread(left);
            Thread rightThread = new Thread(right);
            leftThread.start();
            rightThread.start();
            try {
                leftThread.join();rightThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            merge(leftArray,rightArray,evenLength);
        }
    }
    public void run(){
        mergesort();
    }
    public static void main(String ar[]){
        int a[]={10,9,8,7,6,5,4,3,2,1};
        mergeSortThreaded_copy mOb = new mergeSortThreaded_copy(a);
        Thread t = new Thread(mOb);
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i:mOb.a) System.out.print(i+" ");

    }
}
