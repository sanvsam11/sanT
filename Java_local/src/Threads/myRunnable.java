package Threads;

/**
 * Created by SanthoshVarathan on 21/02/17.
 */
public class myRunnable implements Runnable {
    public void run(){
        for(int i=0;i<5;i++) System.out.println(Thread.currentThread().getName()+":"+i);
    }
    public static void main(String ar[]){
        Thread t1 = new Thread(new myRunnable());
        Thread t2 = new Thread(new myRunnable());
        t1.setName("Thread 1");t2.setName("Thread 2");
        t1.start();t2.start();
        try{
            t2.join();t1.join();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
