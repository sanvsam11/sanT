import java.util.Queue;

/**
 * Created by SanthoshVarathan on 12/08/16.
 */
public class QueueusingStack{
    StackusingQueue s1,s2;
    public void poll(){}
    public void clear(){}
    public QueueusingStack(){
        s1 = new StackusingQueue();
    }
    public QueueusingStack(int element){
        s1 = new StackusingQueue(element);

    }
    public void enqueue(int element){                   //costly enqueue
        if(s1.top==null)s1.push(element);
        else{
            while(!s1.isEmpty())if(s2==null)s2=new StackusingQueue(s1.pop());else s2.push(s1.pop());
            s1.push(element);
            while (!s2.isEmpty())s1.push(s2.pop());
        }
    }
    public int size(){
        return s1.size();
    }
    public int dequeue(){
        return s1.pop();
    }
    public void printQueue(){
        s1.printStack();
    }
    public static void main(String ar[]){
        QueueusingStack mq = new QueueusingStack(1);
        mq.enqueue(2);
        mq.dequeue();
        mq.enqueue(3);
        mq.printQueue();
    }
}
