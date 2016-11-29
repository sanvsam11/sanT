package Threads.backup;

/**
 * Created by SanthoshVarathan on 17/10/16.
 */
public class interleavingExample {
    private int c = 0;
    /*
    public static void main(String ar[]){
        interleavingExample i = new interleavingExample();
        i.execute();
    }
    */
    public void execute(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<1000;i++)
                    inc();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<1000;i++)
                    inc();
            }
        });
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        }
        catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        System.out.println("count: "+c);
    }
    private synchronized void inc(){
        c++;
    }
}
