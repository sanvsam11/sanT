package Threads;

/**
 * Created by SanthoshVarathan on 21/02/17.
 */
public class RaceExample {
    int count=0;
    public static void main(String ar[]){
        new RaceExample().doWork();
    }
    synchronized void incrementMethod(){
        count++;
    }
    public void doWork(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10000;i++) incrementMethod();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10000;i++) incrementMethod();
            }
        });
        t1.start();t2.start();
        try{
            t1.join();t2.join();
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("count:"+count);
    }
}
