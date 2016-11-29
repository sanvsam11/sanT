package Threads;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by SanthoshVarathan on 29/11/16.
 */
public class ReEntrantLock_10 {
    Lock lock = new ReentrantLock(true);
    Condition con = lock.newCondition();
    int count;
    public void increment(){
        for(int i=0;i<10000;i++)
        count++;
    }
    /*
    public static void main(String ar[]){

        final ReEntrantLock_10 r = new ReEntrantLock_10();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    r.firstThread();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    r.secondThread();
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
        System.out.println("Count:"+r.count);
    }
    */
    public void firstThread() throws InterruptedException{
        lock.lock();
        System.out.println("Waiting..");
        con.await();
        System.out.println("Woken up..");
        try {
          increment();
        }
        finally {
            lock.unlock();
        }
    }
    public void secondThread() throws InterruptedException{
        Thread.sleep(100);
        lock.lock();
        System.out.println("Return key. now.");
        new Scanner(System.in).nextLine();
        System.out.println("Signalling now..");
        con.signal();
        try {
            increment();
        }
        finally {
            lock.unlock();
        }
    }
}
