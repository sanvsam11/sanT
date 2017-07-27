package CrackingTheCodingInterview.LinkedList;

import sun.awt.image.ImageWatched;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by SanthoshVarathan on 06/07/17.
 */
public class RemoveDuplicatesUnsorted {
    public static LinkedList hashSetMethod(LinkedList list){
        node runner = list.getHead();
        Set<Integer> elementSet = new HashSet<>();
        elementSet.add((Integer)runner.data);
        //runner = runner.next;
        while(runner.next!=null){
            if(elementSet.contains((Integer)runner.next.data))
                runner.next = runner.next.next;
            else{
                elementSet.add((Integer)runner.next.data);
                runner = runner.next;
            }
        }
        return list;
    }

    public static LinkedList bruteForceMethod(LinkedList list){
        node currentPointer = list.getHead();
        node runner;
        while(currentPointer.next!=null){
            runner = currentPointer;
            while(runner.next!=null)
                if(runner.next.data==currentPointer.data)
                    runner.next = runner.next.next;
                else
                    runner = runner.next;

            currentPointer = currentPointer.next;
        }
        return list;
    }

    public static void main(String ar[]){
        LinkedList list = SingleLinkedList.generateTestList(10,false);
        list.printList();
        list = bruteForceMethod(list);
        list.printList();
    }
}