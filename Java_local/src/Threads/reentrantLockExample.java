package Threads;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by SanthoshVarathan on 22/02/17.
 */
public class reentrantLockExample {
    public static void main(String ar[]){
        final processor5 p = new processor5();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run(){
                try {
                    p.methodOne();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                p.methodTwo();
            }
        });
        t1.start();t2.start();
        try {
            t1.join();t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        p.finishingMethod();
    }
}
class processor5{
    Lock lock = new ReentrantLock();
    Condition con = lock.newCondition();
    int count=0;
    void increment(){
        for(int i=0;i<10000;i++) count++;
    }
    public void methodOne() throws InterruptedException {
        try{
            lock.lock();
            System.out.println("waiting..");
            con.await();
            System.out.println("Resumed.");
            increment();
        }
        finally {
            lock.unlock();
        }
    }
    public void methodTwo(){
        try{
            lock.lock();
            increment();
            System.out.println("press return key.");
            new Scanner(System.in).nextLine();
            con.signal();
        }
        finally {
            lock.unlock();
        }
    }
    public void finishingMethod(){
        System.out.println("count is:" +count );
    }
}
