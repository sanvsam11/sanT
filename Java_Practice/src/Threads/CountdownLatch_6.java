package Threads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by SanthoshVarathan on 27/11/16.
 */
public class CountdownLatch_6 implements Runnable{
    CountDownLatch latch;                                       //runnable instances stores reference to single latch
    CountdownLatch_6(CountDownLatch latch){
        this.latch = latch;
    }
    public void run(){
        System.out.println(Thread.currentThread().getId()+": Started.");
        try {
            Thread.sleep(3000);                                                 //simulating useful work
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getId()+": completed..");
        latch.countDown();                                                       // notifyAll equivalent but with a count and simplified code
    }
    public static void main(String ar[]){
        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService ex = Executors.newFixedThreadPool(3);
        for(int i=0;i<3;i++) ex.submit(new CountdownLatch_6(latch));
        System.out.println("Main thread waiting for latch countdown..");
        try {
            //ex.awaitTermination(2, TimeUnit.SECONDS);
            latch.await();                                                      // wait() equivalent but waiting for zero countdown
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Dependent threads completed...");
        System.out.println("Main OUT.");
    }
}
