package CrackingTheCodingInterview.LinkedList;

/**
 * Created by SanthoshVarathan on 06/07/17.
 */
public class SumLists {
    public static int Length(LinkedList l){
        node runner  = l.getHead();
        int output = 0;
        while(runner!=null){
            output++;
            runner = runner.next;
        }
        return output;
    }
    public static int addRecursiveMethod(node a,node b){
        if(a==null&&b==null)
            return 0;
        else{
            int sum = (Integer)a.data+(Integer)b.data+addRecursiveMethod(a.next,b.next);
            int carry = (sum>9)?1:0;
            a.data = sum % 10;
            return carry;
        }
    }
    public static LinkedList highHead(LinkedList a,LinkedList b){
        int finalCarry = addRecursiveMethod(a.getHead(),b.getHead());
        if(finalCarry!=0){
            node newnode = new node(finalCarry);
            newnode.next = a.getHead();
            a.setHead(newnode);
        }
        return a;
    }
    public static LinkedList<Integer> unitHead(LinkedList<Integer> a,LinkedList<Integer> b){
        node a_runner = a.getHead(),b_runner = b.getHead();
        int carry = 0;
        while(a_runner!=null&&b_runner!=null){
            int sum = (Integer) a_runner.data +(Integer) b_runner.data+carry;
            carry = (sum<10)?0:1;
            a_runner.data = sum % 10;

            if(a_runner.next==null&&carry==1)
                a_runner.data=(Integer)a_runner.data+carry;
            a_runner = a_runner.next;
            b_runner = b_runner.next;
        }
        return a;
    }
    public static LinkedList listsSum(LinkedList a, LinkedList b,boolean unitHead){
        int la = Length(a), lb = Length(b);
        int difference = Math.abs(la-lb);
        if(unitHead)
            return unitHead(a,b);
        else
            return highHead(a,b);
    }
    public static void main(String ar[]){
        LinkedList<Integer> a = new SingleLinkedList(), b = new SingleLinkedList();
        a.insert(7);
        a.insert(1);
        a.insert(6);
        b.insert(5);
        b.insert(9);
        b.insert(2);
        a.printList();b.printList();
        a = listsSum(a,b,false);
        a.printList();
    }
}
