package Threads;

import java.util.LinkedList;
import java.util.Random;
/**
 * Created by SanthoshVarathan on 23/10/16.
 */
public class prodCon_wt_nf {
    LinkedList<Integer> l = new LinkedList<Integer>();
    Random r = new Random();
    Object lock = new Object();
    public void produce() throws InterruptedException{
        int i=0;
            while (true) {
        synchronized (lock) {
                        while(l.size()==10)
                        lock.wait();
                l.add(i++);
                lock.notify();
                    }
            }
        }

    public void consume()throws InterruptedException{
            while (true) {
        synchronized (lock) {
                System.out.print("Size: " + l.size());
                    while(l.isEmpty())
                        lock.wait();
                System.out.println(" "+l.removeFirst());
                lock.notify();
                }
                    Thread.sleep(r.nextInt(1000));
            }

    }
    public static void main(String ar[]){
        final prodCon_wt_nf pc = new prodCon_wt_nf();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    pc.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
