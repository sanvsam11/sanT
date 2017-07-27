package Heap;

import java.util.Comparator;

/**
 * Created by SanthoshVarathan on 08/07/17.
 */
public class MinHeap<t extends Comparable<t>> extends AbstractHeap<t> {
    public void siftUp(int index){
        if(index==0)
            return;
        int parentIndex = getParentIndex(index);
        if(array.get(index).compareTo(array.get(parentIndex))<0){
            swap(index,parentIndex);
            siftUp(parentIndex);
        }
    }
    public void siftDown(int index){
        if(index==-1||isLeaf(index))
            return;
        int leftIndex = getLeftIndex(index), rightIndex = getRightIndex(index);
        int smallIndex = (rightIndex==-1)?leftIndex:(array.get(leftIndex).compareTo(array.get(rightIndex))<0)?leftIndex:rightIndex;
        if(array.get(index).compareTo(array.get(smallIndex))>0){
            swap(index,smallIndex);
            siftDown(smallIndex);
        }
    }
    public void insert(t data){
        array.add(data);
        siftUp(array.size()-1);
    }
    public void delete(t data){
        array.remove(data);
        siftDown(0);
    }
    public t getMin(){
        return array.get(0);
    }
}
