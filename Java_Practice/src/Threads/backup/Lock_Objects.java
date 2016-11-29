package Threads.backup;
import java.util.*;
/**
 * Created by SanthoshVarathan on 18/10/16.
 */
public class Lock_Objects {
    Random r = new Random();
    List<Integer> l1 = new ArrayList<Integer>();
    List<Integer> l2 = new ArrayList<>();
    Object lock1 = new Object();
    Object lock2 = new Object();

    public void stageOne(){
       synchronized (lock1)
       {
           try {
               Thread.sleep(1);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           l1.add(r.nextInt());
       }
    }
    public void stageTwo(){
        synchronized (lock2)
        {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            l2.add(r.nextInt());
        }
    }
    public void process(){
        for(int i=0;i<1000;i++){
            stageOne();
            stageTwo();
        }
    }
    /*
    public static void main(String ar[]){
        final Lock_Objects lo = new Lock_Objects();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lo.process();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                lo.process();
            }
        });
        long st = System.currentTimeMillis();
        t1.start();
        t2.start();
        try{
        t1.join();t2.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        long et=System.currentTimeMillis();
        System.out.println("Runtime: "+(et-st));
        System.out.println("List1:"+lo.l1.size()+" List2:"+lo.l2.size());
    }
    */
}
