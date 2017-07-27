package CrackingTheCodingInterview.StacksAndQueues;

/**
 * Created by SanthoshVarathan on 07/07/17.
 */
public class MyQueue<t> {
    static class QueueNode<t>{
        t data;
        QueueNode next;
        public QueueNode(t d){
            data = d;
            next = null;
        }
    }
    QueueNode front,end;
    public void add(t data){
        if(end==null)
            end = front =  new QueueNode(data);
        else{
            end.next = new QueueNode(data);
            end = end.next;
        }
    }
    public t remove(){
        if(front == null)
            return null;
        else if(front==end){
            t temp = (t)front.data;
            front = end = null;
            return temp;
        }
        else{
            t temp = (t)front.data;
            front = front.next;
            return temp;
        }
    }
    public t peek(){
        if(front==null)
            return null;
        else
            return (t)front.data;
    }
    public boolean isEmpty(){
        return front==null;
    }
}
