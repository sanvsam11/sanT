package Threads;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.*;

/**
 * Created by SanthoshVarathan on 28/11/16.
 */
public class callableFuture_13 {
    /*
    public static void main(String ar[]){
        ExecutorService ex = Executors.newCachedThreadPool();
        Future<Integer> f = ex.submit(new Callable<Integer>() {
            public Integer call()throws Exception{
                Random r = new Random();
                int Duration = r.nextInt(10000);
                if(Duration>2000) throw new IOException("Generated value is too long baa");
                System.out.println("Started callable Thread.");
                //try {
                    Thread.sleep(Duration);
                //} catch (InterruptedException e) {
                //    e.printStackTrace();
                //}
                System.out.println("Ended callable Thread");
                return Duration;
            }
        });
        try {
            ex.awaitTermination(10,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("Return value:" + f.get());
        } catch (InterruptedException|ExecutionException e) {
            if(e instanceof ExecutionException){System.out.println(e);
            IOException ioex = (IOException)((ExecutionException) e).getCause();
            System.out.println("Message: "+ioex.getMessage());}
            else e.printStackTrace();
        }
    }
    */
}
