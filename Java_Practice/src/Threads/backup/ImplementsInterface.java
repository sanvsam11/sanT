package Threads.backup;

/**
 * Created by SanthoshVarathan on 17/10/16.
 */
import java.util.*;
class implementingClass implements Runnable{

    private volatile boolean stop = false;

    public void run(){
        for(int i=0;i<10;i++) {
            System.out.println("Hello:" + i);if(stop)break;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
    public void shutdown(){
    stop = true;
    }
}
public class ImplementsInterface {
    /*
    public static void main(String ar[]){
        implementingClass imp1 = new implementingClass();
        implementingClass imp2 = new implementingClass();
        Thread t1 = new Thread(imp1);
        Thread t2 = new Thread(imp2);
        t1.start();
        Scanner in = new Scanner(System.in);in.nextLine();
        imp1.shutdown();
    }
    */
}
