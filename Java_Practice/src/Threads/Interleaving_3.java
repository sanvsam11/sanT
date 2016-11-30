package Threads;

/**
 * Created by SanthoshVarathan on 26/11/16.
 */
public class Interleaving_3 {
    private int count=0;
    /*
    public static void main(String ar[]){
        Interleaving_3 i = new Interleaving_3();
        i.doWork();
    }
    */
    public synchronized void sincrement(){    //syncronised method to increment count to avoid interleaving
        count++;                                // ATOMIC (Synchronised)
    }
    public void increment(){                    //unsynchronised method allows for interleaving
        count++;                                // NOT ATOMIC 1. read to tempVar 2. increment tempVar 3. write to count
    }
    public void doWork(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
              for(int i=0;i<10000;i++){
                  sincrement();
              }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10000;i++){
                    sincrement();
                }
            }
        });
        t1.start();
        t2.start();
        try{
            t1.join();t2.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Count: "+count);
    }
}
