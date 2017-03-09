package Threads;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by SanthoshVarathan on 22/02/17.
 */
public class producerConsumerBlockingExample {
    static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
    public static void main(String ar[]) {
        //producerConsumerBlockingExample p = new producerConsumerBlockingExample();
        Thread pt = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread ct = new Thread(new Runnable(){
           public void run(){
               try {
                   consumer();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        });
        pt.start();ct.start();
        try {
            pt.join();ct.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    static void producer()throws InterruptedException{
        while(true){
            Random random = new Random();
            queue.put(random.nextInt(100));
        }
    }
    static void consumer() throws InterruptedException{
        while(true){
            Thread.sleep(100);
            Random random = new Random();int x=0;
            if(random.nextInt(10)==0) {x=queue.take();
            System.out.println("taken "+x+" size:"+queue.size());}
        }
    }
}
