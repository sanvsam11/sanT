package codingRound;

/**
 * Created by SanthoshVarathan on 23/02/17.
 */
public class cacheTestClass {
    public static void main(String ar[]){
        //cacheMemory memory = new mainMemory(10);
        cache c = new TTLCache(10);
        c.startCache();
    }
}
