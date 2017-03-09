package Threads;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by SanthoshVarathan on 22/02/17.
 */
public class deadlockExample {
    account a1 = new account();
    account a2 = new account();
    Lock lock1 = new ReentrantLock();
    Lock lock2 = new ReentrantLock();

    public static void main(String ar[]){
        final deadlockExample d = new deadlockExample();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                d.method1();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                d.method2();
            }
        });
        t1.start();t2.start();
        try {
            t1.join();t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        d.finishingMethod();
    }
    public void acquireLock(Lock lock1,Lock lock2){
        while(true) {

            boolean getlock1 = false;
            boolean getlock2 = false;
            try {
                getlock1 = lock1.tryLock();
                getlock2 = lock2.tryLock();

            } finally {
                if (getlock1 && getlock2) return;
            }
            if (getlock1) lock1.unlock();
            if (getlock2) lock2.unlock();
        }
    }
    public void method1(){
        Random r = new Random();
        //lock1.lock();lock2.lock();
        try {
            acquireLock(lock1,lock2);
            for (int i = 0; i < 100; i++)
                a1.transfer(a2, r.nextInt(1000));
        }
        finally {
            lock1.unlock();lock2.unlock();
        }
        //lock1.unlock();lock2.unlock();
    }
    public void method2(){
        Random r = new Random();
        //lock2.lock();lock1.lock();
        try {
            acquireLock(lock2,lock1);
            for (int i = 0; i < 100; i++)
                a2.transfer(a1, r.nextInt(1000));
        }
        finally{
            lock2.unlock();lock1.unlock();
        }
        //lock2.unlock();lock1.unlock();
    }
    public void finishingMethod(){
        System.out.println("Account1:"+a1.getBalance()+" Account2:"+a2.getBalance());
        System.out.println("Total: "+(a1.getBalance()+a2.getBalance()));
    }
}

class account {
    int balance=10000;
    public void setBalance(int balance){
        this.balance=balance;
    }
    public int getBalance(){
        return balance;
    }
    public void transfer(account a2,int amount){
        setBalance(getBalance()-amount);
        a2.setBalance(a2.getBalance()+amount);
    }
}
