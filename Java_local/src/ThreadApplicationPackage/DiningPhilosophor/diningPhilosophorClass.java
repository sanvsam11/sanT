package ThreadApplicationPackage.DiningPhilosophor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by SanthoshVarathan on 22/02/17.
 */
public class diningPhilosophorClass {
    public static void main(String ar[]){
        int PHILOSOPHOR_COUNT=5;
        ExecutorService philosophorExecutor = Executors.newFixedThreadPool(PHILOSOPHOR_COUNT);

    }
}
