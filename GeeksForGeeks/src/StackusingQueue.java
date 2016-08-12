/**
 * Created by SanthoshVarathan on 12/08/16.
 */
public class StackusingQueue {
    mQueue q1,q2;mQueue.node top;
    public StackusingQueue(){
        q1.top=null;q2.top=null;
    }
    public StackusingQueue(int element){
        q1=new mQueue(element);this.top=q1.top;
        q2=new mQueue();
    }
    public void push(int element){              //costly push function
        while(!q1.isEmpty())q2.enqueue(q1.dequeue());
        q1.enqueue(element);
        while(!q2.isEmpty())q1.enqueue(q2.dequeue());
    }
    public int pop(){
        return q1.dequeue();
    }
    public void printStack(){
        q1.printQueue();
    }
    public boolean isEmpty(){
        return q1.isEmpty();
    }
    /*public static void main(String ar[]){
        StackusingQueue sqq = new StackusingQueue(1);
        sqq.push(2);
        sqq.push(3);
        sqq.push(4);
        sqq.push(5);
        sqq.pop();
        sqq.printStack();
    }
    */
}
