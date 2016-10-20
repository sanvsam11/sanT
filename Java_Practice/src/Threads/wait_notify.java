package Threads;
import java.util.*;
import java.util.concurrent.RunnableFuture;

/**
 * Created by SanthoshVarathan on 20/10/16.
 */
public class wait_notify {
    public class prodcons{
        wait_notify w;
        public prodcons(wait_notify w){
            this.w = w;
        }
        public void produce()throws InterruptedException{
            synchronized (w) {
                System.out.println("producer started..");
                    Thread.sleep(2000);
                wait();
                System.out.println("Producer completed.");
            }
        }
        public void consume()throws InterruptedException{
            synchronized (w) {
                Scanner in = new Scanner(System.in);
                System.out.println("Consumer started");
                    Thread.sleep(4000);
                    notify();
                    System.out.println("notified");
                    Thread.sleep(2000);
                System.out.println("consumer completed");
            }
        }
    }
    public static void main(String ar[]){
        final wait_notify w = new wait_notify();
        Thread t1 = new Thread(new Runnable() {
        public void run(){
            try{w.new prodcons(w).produce();}
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                w.new prodcons(w).consume();}
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
        try{
            t1.join();t2.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
