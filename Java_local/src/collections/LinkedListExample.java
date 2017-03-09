package collections;

import java.util.LinkedList;

/**
 * Created by SanthoshVarathan on 27/02/17.
 */
public class LinkedListExample {
    public static void main(String ar[]){
        LinkedList<Integer> mylist = new LinkedList<>();
        mylist.add(2,10);
        mylist.add(3,20);
        mylist.add(5,50);
        for(int i:mylist)System.out.print(i+" ");
    }
}
