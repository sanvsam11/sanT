package Threads.backup;

import java.util.*;

/**
 * Created by SanthoshVarathan on 16/10/16.
 */
public class nthreads implements Runnable {
    LinkedList<Integer> l[];int n;
    public void getResource(LinkedList<Integer> l[]){
        for(int i=0;i<l.length;i++) this.l[i]=l[i];
    }
    public void getThreadNumber(int n){
        this.n=n;
    }
    public void run(){
        for(int i=0;i<l.length;i++){
            l[i].push(n);
        }
    }
}
