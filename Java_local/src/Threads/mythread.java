package Threads;

/**
 * Created by SanthoshVarathan on 21/02/17.
 */
public class mythread extends Thread {
    public void run(){
        for(int i=0;i<10;i++) System.out.println(Thread.currentThread().getName()+": "+i);
    }
    public static void main(String ar[]){
        mythread t1 = new mythread();t1.setName("Thread 1");
        mythread t2 = new mythread();t2.setName("Thread 2");
        System.out.println("Start of main");
        t1.start();t2.start();
        try{
            t1.join();t2.join();
        }catch(InterruptedException e){e.printStackTrace();}
        System.out.println("End of main");
    }
}
