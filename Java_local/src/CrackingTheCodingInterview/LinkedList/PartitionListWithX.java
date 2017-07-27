package CrackingTheCodingInterview.LinkedList;

/**
 * Created by SanthoshVarathan on 06/07/17.
 */
public class PartitionListWithX {
    public static LinkedList partitionwithXMethod(LinkedList<Integer> list,int x){
        node lessThanX = list.getHead(), xOrGreater = list.getHead(), runner = lessThanX;

        while((Integer)lessThanX.data>=x){
            list.insert((Integer)lessThanX.data);
            lessThanX = lessThanX.next;
            list.setHead(lessThanX);
        }

        xOrGreater = lessThanX.next;
        while((Integer)xOrGreater.data<x) xOrGreater = xOrGreater.next;

        runner = xOrGreater;
        while((Integer)runner.next.data<x){
            node shiftNode = runner.next;
            runner.next = shiftNode.next;
            node shiftNodeNext = lessThanX.next;
            lessThanX.next = shiftNode;
            lessThanX = shiftNode;
            shiftNode.next = shiftNodeNext;
        }
        return list;
    }
    public static void main(String ar[]){
        LinkedList list = new SingleLinkedList();
        list.insert(3);
        list.insert(2);
        list.insert(1);
        list.insert(5);
        list.insert(8);
        list.insert(5);
        list.insert(10);
        list.printList();
        list=partitionwithXMethod(list,5);
        list.printList();
    }
}
