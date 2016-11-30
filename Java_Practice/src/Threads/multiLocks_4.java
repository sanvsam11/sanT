package Threads;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by SanthoshVarathan on 26/11/16.
 */
public class multiLocks_4 implements Runnable{
    private Random r = new Random();            //to simulate data reception or generation or calculation
    List<Integer> l1 = new ArrayList<>();
    List<Integer> l2 = new ArrayList<>();
    Object lock1 = new Object();
    Object lock2 = new Object();
    public void run(){
        process();             //current thread calling process that calls two methods in sequence which are synchronised seperately for access to two lists
    }
    /*
    public static void main(String ar[]){
        multiLocks_4 m = new multiLocks_4();
        Thread t1 = new Thread(m);
        Thread t2 = new Thread(m);
        long st = System.currentTimeMillis();               //starting time
        t1.start();
        t2.start();
        try{
            t1.join();t2.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        long et = System.currentTimeMillis();               //ending time
        System.out.println("Runtime: "+(et-st));
        System.out.println("l1: "+m.l1.size()+" l2: "+m.l2.size());
    }
    */
    public void stageOne(){                     //method updating list 1
        //lock1.lock();
        synchronized (lock1) {                  //lock1 to restrict access to list 1
            try {
                Thread.sleep(1);
                l1.add(r.nextInt());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //finally {
            //    lock1.unlock();
            //}
        }
    }
    public void stageTwo() {                    //method updating list 2
        synchronized (lock2) {                  //lock2 to restrict access to list 2
            try {
                Thread.sleep(1);
                l2.add(r.nextInt());
            } catch (InterruptedException e) {
                e.printStackTrace();
                }
            //finally {
                //    lock2.unlock();
                // }
            }
        }

    public void process(){                      //method calling two mehods that access list 1 and list 2

        for(int i=0;i<1000;i++) {
            stageOne();
            stageTwo();
        }
    }
}
