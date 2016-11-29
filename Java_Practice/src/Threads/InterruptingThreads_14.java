package Threads;

import java.util.Random;

/**
 * Created by SanthoshVarathan on 29/11/16.
 */
public class InterruptingThreads_14 {
    /*
    public static void main(String ar[]) throws InterruptedException{
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                Random r = new Random();
                System.out.println("Started thread..");
                for(int i=0;i<1E7;i++){
                    //if(Thread.currentThread().isInterrupted())break;
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        System.out.println("Interrupted..");
                    }
                    Math.asin(r.nextDouble());
                }
                System.out.println("Ended thread..");
            }
        });
        t.start();
        Thread.sleep(500);
        t.interrupt();
        t.join();
    }
    */
}
