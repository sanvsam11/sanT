package Threads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by SanthoshVarathan on 19/10/16.
 */
class processor implements Runnable{
    private int id;
    static int c;
    public processor(int id){
        this.id = id;
    }
    public synchronized void increment(){
        c++;
    }
    public void run(){
        System.out.println("Start of Thread: "+id);
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        increment();System.out.println(c);
        System.out.println("End of Thread: "+id);
    }
}
public class ThreadPoolpgm {
    public static void main(String ar[]){
        ExecutorService e = Executors.newFixedThreadPool(2);
        for(int i=1;i<6;i++) e.submit(new processor(i));
        e.shutdown();
        try {
            e.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }
}
