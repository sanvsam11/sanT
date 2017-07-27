package Threads;

import java.util.Scanner;

/**
 * Created by SanthoshVarathan on 22/02/17.
 */
public class waitNotifyExample {
    public static void main(String ar[]){
        final processor3 p = new processor3();
        Thread pt = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    p.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread ct = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    p.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        pt.start();ct.start();
        try {
            pt.join();ct.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class processor3{
    public void produce() throws InterruptedException{
        synchronized (this){
            System.out.println("Producer thread running...");
            wait();
            System.out.println("Resumed.");
        }
    }
    public void consume() throws InterruptedException{
        Thread.sleep(3000);
        Scanner in = new Scanner(System.in);
        synchronized (this){
            System.out.println("Hit return key.");
            in.nextLine();
            notify();
            Thread.sleep(5000);
        }
    }
}
