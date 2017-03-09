package Threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by SanthoshVarathan on 21/02/17.
 */
public class ThreadpoolExample {
    public static void main(String ar[]){
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for(int i=1;i<10;i++){
            executor.submit(new processor2(i));
        }
        System.out.println("All tasks submitted");
        executor.shutdown();
        try {
            executor.awaitTermination(20, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("All tasks completed");
    }
}
class processor2 implements Runnable{
    int id;
    public processor2(int id){
        this.id=id;
    }
    public void run(){
        System.out.println("Starting "+id);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("completed "+id);
    }
}

