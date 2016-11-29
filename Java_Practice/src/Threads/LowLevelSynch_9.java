package Threads;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.lang.Thread;

/**
 * Created by SanthoshVarathan on 29/11/16.
 */
public class LowLevelSynch_9 {
    private LinkedList<Integer> ll = new LinkedList<>();
    Object lock = new Object();
    final int LIMIT = 10;
    /*
    public static void main(String ar[]){
        final LowLevelSynch_9 l = new LowLevelSynch_9();
        Thread pt = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    l.producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread ct = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    l.consumer();
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
    */
    public void producer() throws InterruptedException{ int i=0;
        while(true){
            synchronized (lock) {
                while(ll.size()==LIMIT) lock.wait();
                ll.add(i++);
                lock.notify();
            }
        }
    }
    public void consumer() throws InterruptedException{
        Random r = new Random();
        while(true){
            synchronized (lock){
                while(ll.size()==0) lock.wait();
                System.out.print("Size: "+ll.size());
                int x = ll.remove();
                System.out.println("; Consumed: "+x);
                lock.notify();
            }
            Thread.sleep(r.nextInt(1000));
        }
    }
}
