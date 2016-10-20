package Threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.Random;

/**
 * Created by SanthoshVarathan on 19/10/16.
 */
public class ProdCon_tsafe{
    static Random r = new Random(100);
    static BlockingQueue<Integer> q = new ArrayBlockingQueue<Integer>(10);
    public static void main(String ar[]) throws InterruptedException{
        Thread t1 = new Thread(new Runnable(){
           public void run(){
               try {
                   producer();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
               try{
                   consumer();
               }catch(InterruptedException e) {
                   e.printStackTrace();
               }
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();
}
    static void producer() throws InterruptedException{
        while(true){
            q.put(r.nextInt(100));
        }
    }
    static void consumer() throws InterruptedException{
        while(true){
            Thread.sleep(100);
            if(r.nextInt(10)==0){
            Integer i = q.take();
            System.out.println("removed Int:"+i+" size:"+q.size());}
        }
    }
}
