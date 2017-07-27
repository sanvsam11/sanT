package CrackingTheCodingInterview.LinkedList;

/**
 * Created by SanthoshVarathan on 06/07/17.
 */
public class kthElementFromEnd {

    static int kthElementFromEndMethod(LinkedList<Integer> list,int k){
        node forwardPointer = list.getHead(),kPointer = forwardPointer;
        int kCopy = k;
        while(kCopy-->0&&forwardPointer!=null)
            forwardPointer = forwardPointer.next;
        while(forwardPointer!=null){
            forwardPointer = forwardPointer.next;
            kPointer = kPointer.next;
        }
        return (Integer)kPointer.data;
    }

    public static void main(String ar[]){
        LinkedList<Integer> list = SingleLinkedList.generateTestList(10,true);
        list.printList();
        System.out.println(kthElementFromEndMethod(list,5));
    }
}
