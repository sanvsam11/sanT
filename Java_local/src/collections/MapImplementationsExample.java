package collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by SanthoshVarathan on 05/03/17.
 */
public class MapImplementationsExample {
    public static void main(String ar[]){
        Map<Integer,String> hashmap = new HashMap<>();
        Map<Integer,String> linkedhashmap = new LinkedHashMap<>();
        Map<Integer,String> treemap = new TreeMap<>();

        testMap(linkedhashmap);
    }
    public static void testMap(Map<Integer,String> m){
        m.put(1,"one");
        m.put(2,"two");
        m.put(3,"three");
        m.put(4,"four");
        m.put(5,"five");

        for(Integer i:m.keySet()){
            System.out.println(i);
        }
    }
}
