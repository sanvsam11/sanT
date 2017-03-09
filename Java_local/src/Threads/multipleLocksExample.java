package Threads;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.RunnableFuture;

/**
 * Created by SanthoshVarathan on 21/02/17.
 */
public class multipleLocksExample {
    Object lock1 = new Object();
    Object lock2 = new Object();
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();
    Random r = new Random();
    public void stageone(){
        synchronized (lock1){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        list1.add(r.nextInt(100));
        }
    }
    public void stagetwo(){
        synchronized (lock2){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        list2.add(r.nextInt(100));}
    }
    public void process(){
        for(int i=0;i<1000;i++){
            stageone();
            stagetwo();
        }
    }
    public static void main(String ar[]){
        final multipleLocksExample m = new multipleLocksExample();
        Thread t1 = new Thread(new Runnable() {
            public void run(){
                m.process();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                m.process();
            }
        });
        Long startTime = System.currentTimeMillis();
        t1.start();t2.start();
        try {
            t1.join();t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("List1:"+m.list1.size()+" List2:"+m.list2.size());
        System.out.println("Time taken: "+ (endTime-startTime));
    }
}
