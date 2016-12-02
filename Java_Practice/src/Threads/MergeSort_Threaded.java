package Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by SanthoshVarathan on 30/11/16.
 */
public class MergeSort_Threaded implements Runnable{
    static Lock lock = new ReentrantLock();
    ExecutorService ex;
    int a[],s=0,e=0;                                     //array to be sorted
    int l = 0;
	MergeSort_Threaded(int a[],int s,int e){            //constructor to get the array to be sorted
        this.a = a;this.s = s;this.e = e;l=e-s;
    }
    MergeSort_Threaded(int ar[]){
        MergeSort_Threaded(ar,0,a.length-1);
    }
    
    public void getExecutorService(ExecutorService ex){
        this.ex = ex;
    }
    public void swap(int i,int j){
        lock.lock();
        try {
            int x = a[i];
            a[i] = a[j];
            a[j] = x;
        }finally {
            lock.unlock();
        }
    }
    public void run(){
		//System.out.print("thread with elements:");
		//printArray();
        //System.out.println("\nM:"+((s+e)/2)+" s:"+s+"e:"+e);
        //System.out.println("l:"+l+" s:"+s+" e:"+e);
        if(l<2)if(a[s]>a[e])swap(s,e);
        else if(l<3){boolean first=a[s]>a[s+1],second=a[s+1]>a[e];

			if(first&&second)swap(a[s],a[e]);
			else for(int i=s;i<e;i++){
				if(a[i]>a[i+1]) swap(a[i],a[i+1]);
			}
		}
        else{
            int m = (s+e)/2;                                                //bisecting the array for merge sor
            MergeSort_Threaded left = new MergeSort_Threaded(a,s,m);        //new runnable instance for the left half
            //ex.submit(left);
            Thread lt = new Thread(left);
            lt.start();
            MergeSort_Threaded right = new MergeSort_Threaded(a,m+1,e);     //new runnable instance for the right half
            Thread rt = new Thread(right);
            rt.start();
            try {
                lt.join();rt.join();                                        //waiting for left and right halves to be sorted
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            //ex.submit(right);
            if(a[m]>a[m+1]){                                                //Merging sorted left and right halves
               for(int i=m;i>0;i--){int j = i;
                   while(a[j]>a[j+1]){swap(j,j+1);j++;}
               }
                System.out.println("Array after merge:");
                printArray();
            }
        }
    }
    public void printArray(){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
    public static void main(String ar[]){
        int a[] = {4,6,3,2,6,8,6,4,22,5,7,67,35,7,45,99};
        ExecutorService ex = Executors.newFixedThreadPool(10);
        MergeSort_Threaded ms = new MergeSort_Threaded(a);
        //ms.getExecutorService(ex);
        //ex.submit(ms);
        Thread t = new Thread(ms);
        t.start();
        try {
            t.join();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        //ms.printArray();
    }
}
