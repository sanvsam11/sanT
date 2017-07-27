package CrackingTheCodingInterview.LinkedList;

/**
 * Created by SanthoshVarathan on 06/07/17.
 */
public class deleteMiddleNode {
    public static LinkedList<Integer> deleteMiddleElementMethod(LinkedList<Integer> list){
        node midPreviousRunner = list.getHead(),midRunner = midPreviousRunner,doubleRunner = midRunner.next.next;
        while(doubleRunner!=null){
            if(doubleRunner.next==null) break;
            midPreviousRunner = midRunner;
            midRunner = midRunner.next;
            doubleRunner = doubleRunner.next.next;
        }
        if(doubleRunner==null)
            midPreviousRunner.next = midRunner.next;
        else {
            midPreviousRunner = midRunner;
            midRunner = midRunner.next;
            midPreviousRunner.next = midRunner.next;
        }
        midRunner = null;
        return list;
    }
    public static void main(String ar[]){
        LinkedList<Integer> list = SingleLinkedList.generateTestList(9,true);
        list.printList();
        deleteMiddleElementMethod(list);
        list.printList();
    }
}
