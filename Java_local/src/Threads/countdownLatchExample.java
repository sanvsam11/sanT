package Threads;

import java.util.RandomAccess;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by SanthoshVarathan on 21/02/17.
 */
public class countdownLatchExample {

    public static void main(String ar[]){
        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for(int i=0;i<3;i++){
            executor.submit(new runner(latch));
        }
        executor.shutdown();
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Completed");
    }
}
class runner implements Runnable{
    CountDownLatch latch;
    public runner(CountDownLatch latch){
        this.latch=latch;
    }
    public void run(){
        System.out.println("Started");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        latch.countDown();
    }
}
