package Threads;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by SanthoshVarathan on 25/10/16.
 */
public class deadLock {
    Lock lock1 = new ReentrantLock();
    Lock lock2 = new ReentrantLock();
    Random r = new Random();
    private account a1 = new account();
    private account a2 = new account();

    public void stageOne() throws InterruptedException{
        //Thread.sleep(1000);
        for(int i=0;i<1000;i++) {
            getlock(lock1,lock2);
            try {
                account.transfer(a1, a2, r.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }
    public void stageTwo()throws InterruptedException{
        for(int i=0;i<1000;i++) {
            getlock(lock2,lock1);
            try {
                account.transfer(a2, a1, r.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }
    private void getlock(Lock lock1, Lock lock2) throws InterruptedException {
        boolean locked1=false,locked2=false;
        while(true) {
            try{
                locked1 = lock1.tryLock();
                locked2 = lock2.tryLock();
            }
            finally {
                if (locked1 && locked2) return;
                if(locked1) lock1.unlock();
                else if(locked2) lock2.unlock();
            }
            Thread.sleep(1);
        }
    }
    public void balancePrinter(){
        System.out.println("A1: "+a1.getBalance());
        System.out.println("A2: "+a2.getBalance());
        System.out.println("Total: "+(a1.getBalance()+a2.getBalance()));
    }
    public static void main(String ar[]){
        final deadLock d = new deadLock();
        Thread t1= new Thread(new Runnable() {
            @Override
            public void run() {
                try{
              d.stageOne();}
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        Thread t2= new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    d.stageTwo();}
                catch(InterruptedException e){
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
        d.balancePrinter();
    }
}
