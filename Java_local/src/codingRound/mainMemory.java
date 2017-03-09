package codingRound;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by SanthoshVarathan on 23/02/17.
 */
public class mainMemory extends cacheMemory {
    Lock lock = new ReentrantLock();
    Map<Integer,Integer> Data = new HashMap<>();
    int MAX_SIZE;

    public void setsize(int MAX_SIZE) {
        this.MAX_SIZE = MAX_SIZE;
    }

    public mainMemory(int size){
        MAX_SIZE=size;
    }
    @Override
    public void putValue(int key, int value)
    {   try {
        lock.lock();
        Data.put(key, value);
    }
    finally{
        lock.unlock();
    }
    }
    public boolean containsKey(int key){
        return Data.containsKey(key);
    }

    @Override
    public boolean isFull() {
        if(Data.size()<MAX_SIZE) return false;
        else return true;
    }

    @Override
    public void printValues() {

    }

    @Override
    public int getValue(int key)
    {
        try {
            lock.lock();
            return Data.get(key);
        }
        finally {
            lock.unlock();
        }
    }

    @Override
    public int removeValue(int key) {
        try {
            lock.lock();
            return Data.remove(key);
        }
        finally{
            lock.unlock();
        }
    }

}
