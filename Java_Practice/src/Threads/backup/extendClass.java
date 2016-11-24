package Threads.backup;

/**
 * Created by SanthoshVarathan on 17/10/16.
 */
class extendedThread extends Thread{
    @Override
    public void run(){
        for(int i=0;i<10;i++)System.out.println("hello:"+i);
    }
}
public class extendClass{
    public static void main(String ar[]){
        extendedThread t1 = new extendedThread();
        extendedThread t2 = new extendedThread();

        t1.start();
        t2.start();
    }
}