package CrackingTheCodingInterview.StacksAndQueues;

/**
 * Created by SanthoshVarathan on 07/07/17.
 */
public class MyQueueWithStack<t> {
    MyStack<t> s1,s2;
    public MyQueueWithStack(){
        s1 = new MyStack<t>(10);
        s2 = new MyStack<t>(10);
    }
    public t remove(){
        return s1.pop();
    }
    public void add(t data){
        while(!s1.isEmpty())
            s2.push(s1.pop(),s1.peekMin());
        s1.push(data,data);
        while(!s2.isEmpty())
            s1.push(s2.pop(),s2.peekMin());
    }
    public t peek(){
        return s1.peek();
    }
    public boolean isEmpty(){
        return s1.isEmpty();
    }
    public static void main(String ar[]){
        MyQueueWithStack<Integer> q = new MyQueueWithStack<>();
        q.add(1);
        q.add(2);
        q.add(3);
        while(!q.isEmpty())
            System.out.print(q.remove()+" ");
    }
}
