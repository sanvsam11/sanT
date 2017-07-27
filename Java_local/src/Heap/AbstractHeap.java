package Heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.lang.Comparable;
import java.util.List;

/**
 * Created by SanthoshVarathan on 08/07/17.
 */
public abstract class AbstractHeap<t extends Comparable<t>>{
    List<t> array = new ArrayList<>();
    public int getLeftIndex(int i){
        return (i+1>array.size())?-1:i*2 + 1;
    }
    public int getRightIndex(int i){
        return (i+2>array.size())?-1:i*2 + 2;
    }
    public int getParentIndex(int i){
        return (i>array.size())?-1:(i-1)/2;
    }
    public void swap(int index1,int index2){
        t temp = array.get(index1);
        array.set(index1,array.get(index2));
        array.set(index2,temp);
    }
    public boolean isLeaf(int i){
        return getLeftIndex(i)==-1&&getRightIndex(i)==-1;
    }
}
