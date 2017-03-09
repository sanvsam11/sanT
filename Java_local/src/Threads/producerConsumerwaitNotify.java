package Threads;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by SanthoshVarathan on 22/02/17.
 */
public class producerConsumerwaitNotify {

    public static void main(String ar[]){
        final processor4 p  = new processor4();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    p.producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    p.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();t2.start();
        try {
            t1.join();t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class processor4{
    LinkedList<Integer> list = new LinkedList<>();
    int limit=10;
    Object lock = new Object();
    public void producer() throws InterruptedException {
        while(true){
            synchronized (lock) {
                while (list.size() == limit)
                    lock.wait();

                Random random = new Random();
                list.add(random.nextInt(100));
                lock.notify();
            }
        }
    }
    public void consumer() throws InterruptedException {
        Random r = new Random();
        while(true){
            synchronized (lock){
                Thread.sleep(r.nextInt(1000));
                while(list.size()==0) lock.wait();
                System.out.println("Removed "+list.removeFirst()+" size:"+list.size());
                lock.notify();
            }
        }


    }
}
