package Threads;

import java.util.Scanner;

/**
 * Created by SanthoshVarathan on 26/11/16.
 */
public class volatile_2 implements Runnable{
    private volatile boolean running = true;
    public static void main(String ar[]){
        volatile_2 v= new volatile_2();
        Thread t = new Thread(v);
        t.start();
        new Scanner(System.in).nextLine();
        v.shutdown();
    }
    public void shutdown(){
        running = false;
    }
    public void run() {
        while (running) {
            System.out.println("Hello !");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
