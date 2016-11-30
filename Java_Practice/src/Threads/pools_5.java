package Threads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by SanthoshVarathan on 26/11/16.
 */
public class pools_5 implements Runnable{
    private int id;
    public pools_5(int i){id=i;}
    public void run(){
        System.out.println(id+": Start");
        try {
            Thread.sleep(5000);             //simulating doing useful work
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(id+": End");
    }
    /*
    public static void main(String ar[]){
        ExecutorService exT = Executors.newFixedThreadPool(3); //basically number of concurrent jobs running

        for(int i=0;i<5;i++){
            exT.submit(new pools_5(i));
        }
        exT.shutdown();
        System.out.println("All threads submitted.");
        try {
            exT.awaitTermination(11, TimeUnit.SECONDS);         // join for pooled threads
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("All threads complete");
    }
    */
}
