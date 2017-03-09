package collections;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SanthoshVarathan on 05/03/17.
 */
public class HashmapExample {
    public static void main(String ar[]){
        Map<String,Integer> map = new HashMap<>();
        map.put("one",1);
        map.put("two",2);
        map.put("three",3);
        for (Map.Entry<String,Integer> entry:map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
