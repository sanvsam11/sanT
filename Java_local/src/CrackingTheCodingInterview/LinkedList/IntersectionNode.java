package CrackingTheCodingInterview.LinkedList;

/**
 * Created by SanthoshVarathan on 07/07/17.
 */
public class IntersectionNode<e> {
    public static int findListsIntersection(LinkedList a,LinkedList b){
        int l_a = SumLists.Length(a), l_b = SumLists.Length(b);
        int difference = Math.abs(l_a - l_b);
        node aRunner = a.getHead(), bRunner = b.getHead();
        if(l_a>l_b)
            while(difference-->0)
                aRunner = aRunner.next;
        else
            while(difference-->0)
                bRunner = bRunner.next;
        while(aRunner!=bRunner){
            aRunner = aRunner.next;
            bRunner = bRunner.next;
        }
        return (Integer)aRunner.data;
    }
    public static void main(String ar[]){
        LinkedList<Integer> a = new SingleLinkedList<>();
        LinkedList<Integer> b = new SingleLinkedList<>();
        node ah = new node(1);
        node bh = new node (2);
        a.setHead(ah);
        b.setHead(bh);
        ah.next = new node(2);
        ah = ah.next;
        ah.next = new node(3);
        ah = ah.next;
        bh.next = ah;
        ah.next = new node(4);
        ah = ah.next;
        ah.next = new node(5);
        a.printList();
        b.printList();
        System.out.println(findListsIntersection(a,b));
    }
}
