package Threads;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RunnableFuture;

/**
 * Created by SanthoshVarathan on 27/11/16.
 */
public class producerConsumer_7 {
    static BlockingQueue queue = new ArrayBlockingQueue(10);
    public static void main(String ar[]){
        //final producerConsumer_7 pc = new producerConsumer_7();
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consumer();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        producer.start();
        consumer.start();
        try{
            producer.join();
            consumer.join();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    public static void producer() throws InterruptedException{
        Random r = new Random();
        while(true){
            queue.put(r.nextInt(100));
        }
    }
    public static void consumer() throws InterruptedException{
        Random r = new Random();
        while (true){
            Thread.sleep(1000);
            if(r.nextInt(10)==0)
                System.out.println(Thread.currentThread().getName()+" Comsumed: "+queue.take()+"\nQueue Size: "+queue.size());
        }
    }
}
