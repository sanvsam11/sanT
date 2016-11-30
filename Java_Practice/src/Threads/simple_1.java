package Threads;

import java.util.Random;

/**
 * Created by SanthoshVarathan on 24/11/16.
 */
public class simple_1 implements Runnable{
    /*
    public static void main(String ar[]){
        Thread t = new Thread(new simple_1());
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Random r = new Random(100);
        for(int i=0;i<20;i++){
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Main: "+r.nextInt(100));
        }
    }
    */
    public void run(){
        Random r = new Random(100);
        for(int i=0;i<20;i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread: "+r.nextInt(100));
        }
    }
}
