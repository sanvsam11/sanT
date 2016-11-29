package Threads.backup;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by SanthoshVarathan on 19/10/16.
 */
class processor2 implements Runnable{
    CountDownLatch latch;
    public processor2(CountDownLatch latch){
        this.latch=latch;
    }
    public void run(){
        System.out.println("Start of thread");
        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        latch.countDown();

    }
}
public class countDownLatch {
    /*
    public static void main(String ar[]){
        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService e = Executors.newFixedThreadPool(3);
        for(int i=0;i<3;i++) e.submit(new processor2(latch));
        try {
            latch.await();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        System.out.println("completed");
    }
    */
}
