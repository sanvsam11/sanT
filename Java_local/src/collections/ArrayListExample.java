package collections;

import java.util.ArrayList;

/**
 * Created by SanthoshVarathan on 26/02/17.
 */
public class ArrayListExample {
    ArrayList<Integer> ylist = new ArrayList<>();
    public static void main(String ar[]){
        ArrayListExample a = new ArrayListExample();
        a.ylist.add(10);
        a.ylist.add(20);
        System.out.println(a.ylist.get(0)+" "+a.ylist.get(1));

    }
}
