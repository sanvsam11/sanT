package Threads;

import java.util.LinkedList;

/**
 * Created by SanthoshVarathan on 16/10/16.
 */
public class nthreadsTest {
    public static void main(String ar[]){
        nthreads t[]=new nthreads[10];
        LinkedList<Integer> l[]=new LinkedList[10];
        for(int i=0;i<10;i++){
            t[i]=new nthreads();
            t[i].getThreadNumber(i);
            l[i]=new LinkedList<Integer>();
            t[i].getResource(l);
        }
        for(int i=0;i<10;i++) t[i].run();
    }
}
