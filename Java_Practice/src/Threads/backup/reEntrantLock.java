package Threads.backup;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by SanthoshVarathan on 25/10/16.
 */
public class reEntrantLock {
    private int c=0;
    Lock lock = new ReentrantLock();
    Condition con = lock.newCondition();
    private void increment(){
        for(int i=0;i<1000;i++)c++;
    }
    public void stage1() throws InterruptedException{
            lock.lock();
            con.await();
            increment();//System.out.println("s1: "+c);
            lock.unlock();
    }
    public void stage2() throws InterruptedException{
            lock.lock();
            increment();
            con.signal();
            lock.unlock();

    }
    /*
    public static void main(String ar[]){
        final reEntrantLock r = new reEntrantLock();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    r.stage1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    r.stage2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();t2.start();
        try{
            t1.join();t2.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(r.c);
    }
    */
}
