import java.util.Queue;

/**
 * Created by SanthoshVarathan on 24/10/16.
 */
public class Stackusing1queue {
    QueueusingStack q = new QueueusingStack();
    public void push(int element){
        q.enqueue(element);
        for(int i=0;i<q.size();i++) q.enqueue(q.dequeue());
    }
    public int pop(){
        return q.dequeue();
    }
    public void printStack(){
        q.printQueue();
    }

    public static void main(String ar[]){
        Stackusing1queue s = new Stackusing1queue();
        s.push(5);
        s.push(4);
        s.push(3);
        s.pop();
        s.push(2);
        s.push(1);
        s.printStack();
    }
}
