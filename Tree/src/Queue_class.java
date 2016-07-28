/**
 * Created by SanthoshVarathan on 25/07/16.
 */
public class Queue_class {
    class node{
        tree_1 element;
        node next;

        public node(tree_1 t){
            element=t;next=null;
        }
        public node(){element=null;next=null;}
    }
    node top;
    public Queue_class(tree_1 t){
        top=new node(t);
    }
    public void enqueue(tree_1 t){
        if(top==null){top=new node(t);top.next=null;}
        else{node tmp=top;
            while(tmp.next!=null)tmp=tmp.next;
            node newnode=new node(t);
            tmp.next=newnode;
        }
    }
    public tree_1 dequeue(){ tree_1 t;
        t=top.element;
        top=top.next;
        return t;
    }
    public void printQueue(){ node tmp=top;
        while(tmp!=null){
            System.out.println(tmp.element.element);
            tmp=tmp.next;
        }
    }
    /*
    public static void main(String ar[]){
        tree_1 t1=new tree_1(1);
        tree_1 t2=new tree_1(2);
        tree_1 t3=new tree_1(3);
        Queue_class q=new Queue_class(t1);
        q.enqueue(t2);
        q.dequeue();
        q.enqueue(t3);
        q.printQueue();
    }
    */
}
