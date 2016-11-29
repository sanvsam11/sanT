package Threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by SanthoshVarathan on 27/11/16.
 */
public class pcWaitNotify_8 {
    static List<Integer> l = new ArrayList<>(10);
    static ThreadLocalRandom tlr = ThreadLocalRandom.current();
    public void producer() throws InterruptedException{

		while(true){
            synchronized(this){
            if(l.size()<10){l.add(tlr.nextInt(0,9));
                System.out.println(Thread.currentThread().getName()+": size:"+l.size());}
            notify();
        }
		}
    }
    public void consumer() throws InterruptedException{
        while(true){
            synchronized(this){
            Thread.sleep(1000);
            if(l.size()<10) wait();
            if(tlr.nextInt(0,5)==0&&l.size()<10) System.out.println(Thread.currentThread().getName()+": Consumed "+l.get(tlr.nextInt(0,10)));
        }
		}
    }
    /*
    public static void main(String ar[]){
       final pcWaitNotify_8 p = new pcWaitNotify_8();
        Thread ct = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Consumer started..");
                    p.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });ct.setName("consumer");
        final Thread pt = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Producer started..");
                    p.producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });pt.setName("producer");
        ct.start();
        pt.start();
        try {
            pt.join();ct.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    */
}
