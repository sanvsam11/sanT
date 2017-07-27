package Linked_List;

/**
 * Created by SanthoshVarathan on 29/04/17.
 */
public class linkedListMainClass {
    public static void main(String ar[]){
        Single_Linked_List<Integer> sl = new Single_Linked_List<>();
        //System.out.println("List is"+(sl.isPalindrome(sl.head)?" ":" not ")+"a palindrome");
        //Single_Linked_List<Integer> sl2 = new Single_Linked_List<>();
        //for(int i=16;i>0;i--) sl.insert(i);
        //for(int i=10;i<70;i+=10) sl.insert(i);
        for(int j=1;j<10;j++) sl.insert(j);
        //node h = sl.head;
        //for(int i=0;i<3;i++) h=h.next;
        //sl.insert(h);
        //sl.insertMultiple(12,15,10,11,5,6,2,3);
        //sl.deletePosition(5);
        //sl.swapNodes2(1,5);
        //System.out.println("List Length:"+sl.getLength());
        //System.out.println("5 is"+(sl.isPresent(5)?" ":" not")+" Present");
        //System.out.println("Middle:"+sl.middleReturn());
        //System.out.println("3rd from end:"+sl.nthNodeFromLeft(3));
        //System.out.println("Count of 5 is:"+sl.countKey(5));
        //node revHead = sl.reverseList(null,sl.head);
        //sl.printList(revHead);
        //System.out.println("List "+(sl.hasLoop()?"has":"does not have"+" loop."));
        //sl.printList();sl2.printList();
        //----------node merge = sl.mergeSortedLists(sl.head,sl2.head);                 //not working
        //sl.printList(merge);
        //sl.deleteRepeatsUnsorted();
        //sl.pairSwap();
        //sl.mergeSort();
        //sl.lastToFirst();
        //sl.deleteAlternateNodes();
        //sl.printList(sl.splitAlternateNodes());
        //System.out.println();
        //sl.deleteLesserNode();
        //sl.reversekNodes(3,sl.head);
        //sl.printList(sl.splitEvenOdd(sl.head));
        //System.out.println();
        //sl.removeLoop();
        //sl.add1(sl.head);
        sl.printList();
    }
}
