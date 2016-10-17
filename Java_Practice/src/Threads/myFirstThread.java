package Threads;
import java.util.concurrent.*;
import java.lang.*;
/**
 * Created by SanthoshVarathan on 16/10/16.
 */

public class myFirstThread implements Runnable{
public void run(){
    String hhmd[] = {"once there was a king whose kingdom was troubled by a bear in a forest.","The king decided to end this problem himself.",
    "he went into the jungle by himself vowing to bring down the beast.","He found the bear, shot his arrow at its solar plexus,....!","arrow is going,","going",
            "going","going","!!!!!!!","missed by a hairline...."};
    try{
        for(int i=0;i<hhmd.length;i++){
            Thread.sleep(4000);
            threadMessage(hhmd[i]);
        }
    }catch(InterruptedException e){
        threadMessage("i ain't finished.. moron");
    }

}
    public static void threadMessage(String message){
        String tname = Thread.currentThread().getName();
        System.out.format("%s:%s%n",tname,message);
    }
    public static void main(String ar[])throws InterruptedException{
        long patience = 1000*50;
        threadMessage("Starting hhmd");
        Thread t = new Thread(new myFirstThread());
        long stime = System.currentTimeMillis();
        t.start();
        threadMessage("waiting for hhmd to complete..will leave dots");
        while(t.isAlive()){
            threadMessage(".");
            t.join(1000);
            if (((System.currentTimeMillis() - stime) > patience)
                    && t.isAlive()) {
                threadMessage("Tired of waiting!");
                t.interrupt();
        }
    }
        threadMessage("hhmdkiiiiiiiii!!!");
}
}
