package Heap;

import java.util.Random;

/**
 * Created by SanthoshVarathan on 08/07/17.
 */
public class HeapTestClass<t extends Comparable<t>> {
    MinHeap<t> mheap = new MinHeap<>();
    t minimum;
    public boolean minimumTester(t n){
        minimum = minimum==null?n:minimum.compareTo(n)<0?minimum:n;
        mheap.insert(n);
        return minimum==mheap.getMin();
    }
    public static void main(String ar[]){
        HeapTestClass<Integer> test = new HeapTestClass<>();
        Random r = new Random();
        for(int i=0;i<20;i++)
            if(!test.minimumTester(r.nextInt(20)))
                System.out.println(i+1+":Failed!!");
    }
}
