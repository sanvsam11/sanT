package codingRound;

/**
 * Created by SanthoshVarathan on 23/02/17.
 */
public abstract class cacheMemory {
    public  abstract void putValue(int key,int value);
    public abstract int getValue(int key);
    public abstract int removeValue(int key);
    public abstract boolean containsKey(int key);
    public abstract boolean isFull();
    public abstract void printValues();
}
