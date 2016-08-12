/**
 * Created by SanthoshVarathan on 12/08/16.
 */
public class mQueue {
    class node{
        int element;
        node next;
        public node(int element){
            this.element=element;next=null;
        }
        public node() {
            element = 0;
            next = null;
        }
    }
    node top,t;
    public mQueue(int element){
        top=new node(element);
    }
    public mQueue(){
        top=null;
    }
    public void enqueue(int element){
        if(top==null) top=new node(element);
        else{t=top;
            while(t.next!=null)t=t.next;
            node newnode=new node(element);
            t.next=newnode;
        }
    }
    public boolean isEmpty(){
        return (top==null)?true:false;
    }
    public int dequeue(){t=top;
        if(top!=null){
            top=top.next;return t.element;
        }
        else return 0;
    }
    public void printQueue(){t=top;
        while(t!=null){System.out.print(t.element+" ");t=t.next;}
    }

    public static void main(String ar[]){
        /*mQueue mq = new mQueue(1);
        mq.enqueue(2);
        mq.dequeue();
        mq.enqueue(3);
        mq.printQueue();
        */
    }

}
