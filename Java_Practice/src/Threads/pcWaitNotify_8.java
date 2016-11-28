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
       synchronized(l){
		while(true){
            if(!l.isEmpty())wait();
            l.add(tlr.nextInt(0,9));
            l.notify();
        }
		}
    }
    public void consumer() throws InterruptedException{
synchronized(l){
        while(true){
            if(l.size()<8) wait();
            Thread.sleep(1000);
            if(tlr.nextInt(0,5)==0) System.out.println(Thread.currentThread().getId()+": Consumed "+l.get(tlr.nextInt(0,10)));
            l.notify();
        }
		}
    }
    public static void main(String ar[]){
       final pcWaitNotify_8 p = new pcWaitNotify_8();
        Thread ct = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    p.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        final Thread pt = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    p.producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        ct.start();
        pt.start();
        try {
            pt.join();ct.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
