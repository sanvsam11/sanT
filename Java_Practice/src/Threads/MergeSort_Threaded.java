package Threads;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by SanthoshVarathan on 30/11/16.
 */
public class MergeSort_Threaded implements Callable<int[]> {
    static Lock lock = new ReentrantLock();
    ExecutorService ex= Executors.newFixedThreadPool(2);
    int a[],s=0,e=0;                                     //array to be sorted
    int l = 0;

	public MergeSort_Threaded(int ar[]){
        a = ar;this.s = 0;l=ar.length;this.e =l-1;
    }/*

    public MergeSort_Threaded(int ar[]){                 //constructor to get the array to be sorted
        a=ar;l=ar.length;s=0;e=l-1;
    }
    */
    public MergeSort_Threaded(){

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
    public synchronized boolean compare(int i,int j){
        return (a[i]>a[j])?true:false;
    }
    public synchronized void replace(int i,int element){
    a[i]=element;
    }
    public int[] call() {
        if (l < 2) if (compare(s, e)) {
            swap(s, e);
        } else if (l < 3) {
            boolean first = compare(s, s + 1), second = compare(s + 1, e);
            if (first && second) swap(s, e);
            else for (int i = s; i < e; i++) {
                if (compare(i, i + 1)) swap(i, i + 1);
            }
        } else {
            int m = (s + e) / 2, leftArray[] = new int[m - s], rightArray[] = new int[e - m];
            for (int i = 0; i <= m; i++) leftArray[i] = a[i];
            for (int i = m + 1; i <= e; i++) rightArray[i] = a[i];
            Future<int[]> left = ex.submit(new MergeSort_Threaded(leftArray));
            Future<int[]> right = ex.submit(new MergeSort_Threaded(rightArray));
            ex.shutdown();
            try {
                leftArray = left.get();
                rightArray = right.get();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            } catch (ExecutionException e1) {
                e1.printStackTrace();
            }
            int i = 0, j = 0, x = 0;
            while (i < leftArray.length && j < rightArray.length) {
                if (leftArray[i] > rightArray[j]) {
                    a[x++] = rightArray[j++];
                    a[x++] = leftArray[i++];
                } else {
                    a[x++] = leftArray[i++];
                    a[x++] = rightArray[j++];
                }
            }
        }
            /*
            for (int i = 0; i < l; i++) {

                if (i <= m) replace(i, leftArray[i]);
                else replace(i, rightArray[i]);
            }

            if (compare(m, m + 1))
                for (int i = m; i > 0; i--) while (compare(i, i + 1)) swap(i, i + 1);
        }
        */
        return a;
    }
    /*
    public void run(){
		//System.out.print("thread with elements:");
		//printArray();
        //System.out.println("\nM:"+((s+e)/2)+" s:"+s+"e:"+e);
        //System.out.println("l:"+l+" s:"+s+" e:"+e);
        if(l<2)if(compare(s,e))swap(s,e);
        else if(l<3){boolean first=a[s]>a[s+1],second=compare(s+1,e);

			if(first&&second)swap(a[s],a[e]);
			else for(int i=s;i<e;i++){
				if(compare(i,i+1)) swap(i,i+1);
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
            if(compare(m,m+1)){                                                //Merging sorted left and right halves
               for(int i=m;i>0;i--){int j = i;
                   while(a[j]>a[j+1]){swap(j,j+1);j++;}
               }
                 System.out.println("Array after merge:");
                printArray();
            }
        }
    }
    */
    public static synchronized void printArray(int pa[]){
        for(int i=0;i<pa.length;i++){
            System.out.print(pa[i]+" ");
        }
    }
    public static void main(String ar[]){
        int a[] = {4,6,3,2,6,8,6,4,22,5,7,67,35,7,45,99},l=a.length;
        ExecutorService ex = Executors.newFixedThreadPool(10);
        MergeSort_Threaded ms = new MergeSort_Threaded(a);
        //ms.getExecutorService(ex);
        Future<int[]> f=ex.submit(ms);
        ex.shutdown();
        //Thread t = new Thread(ms);
        /*
        t.start();
        try {
            t.join();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        */
        try {
            ex.awaitTermination(10,TimeUnit.MINUTES);a=f.get();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }catch(ExecutionException e){
            e.printStackTrace();
        }
        System.out.println("End of main thread.");
        MergeSort_Threaded.printArray(a);
    }
}
