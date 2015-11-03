/**
 * Created by sant on 3/11/15.
 */
public class CountFromTail {
    LinkedListMaker list = new LinkedListMaker();
    int count=1,tofind=0;boolean found = false;
    public CountFromTail(LinkedListMaker list, char tofind){this.list=list;this.tofind=tofind;}
    public void TailCounter(node head){

        if(head.next!=null) TailCounter(head.next);

        if(head.element!=tofind&&found==false) count++;
        else found=true;
    }
    public static void main(String ar[]){
        LinkedListMaker list = new LinkedListMaker('a');
        list.InsertNode('b');
        list.InsertNode('c');
        list.InsertNode('d');
        list.InsertNode('e');

        CountFromTail ob = new CountFromTail(list,'b');
        ob.TailCounter(list.head);
        System.out.println("Count from tail is:"+ob.count);
    }
}
