package Threads;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by SanthoshVarathan on 29/11/16.
 */
public class deadLock_11 {
    Lock lock1 = new ReentrantLock();
    Lock lock2 = new ReentrantLock();
    //private int count1,count2;
    account a = new account();
    account b = new account();
    public void increment1(){
        //count1++;
    }
    public void increment2(){
        //count2++;
    }
    public static void main(String ar[]){
        final deadLock_11 d = new deadLock_11();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                d.stageOne();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    d.stageTwo();
                }catch(InterruptedException e){
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
        System.out.println("Account a:"+d.a.getBalance()+" Account b:"+d.b.getBalance() );
        System.out.println("Total: "+(d.a.getBalance()+d.b.getBalance()));
    }
    private void acquireLocks(Lock flock,Lock slock)throws InterruptedException{
        while(true){boolean flockb=false,slockb=false;
            try{
                flockb = flock.tryLock();
                slockb = slock.tryLock();
            }finally {
                if(flockb&&slockb)return;
                else if(flockb) flock.unlock();
                else slock.unlock();
                Thread.sleep(100);
            }
        }
    }
    public void stageOne() throws InterruptedException{
        //lock1.lock();lock2.lock();
        acquireLocks(lock1,lock2);
        try {
            //increment1();
            Random r = new Random();
            account.transfer(a,b,r.nextInt(100));
            //lock2.lock();
        }finally {
            lock1.unlock();
            lock2.unlock();
        }
        /*
        lock2.lock();
        try {
            increment2();
        }
        finally{
            lock2.unlock();
        }
        */
    }
    public void stageTwo()throws InterruptedException{
        //lock2.lock();lock1.lock();
        acquireLocks(lock1,lock2);
        Random r = new Random();
        try {
            //increment2();
            account.transfer(b,a,r.nextInt(100));
            //lock1.lock();
        }finally {
            lock2.unlock();
            lock1.unlock();
        }
        /*
        lock1.lock();
        try {
            increment1();
        }
        finally {
            lock1.unlock();
        }
        */
    }
}
