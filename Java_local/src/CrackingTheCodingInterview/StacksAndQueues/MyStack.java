package CrackingTheCodingInterview.StacksAndQueues;

/**
 * Created by SanthoshVarathan on 07/07/17.
 */
public class MyStack<t> {
    static class StackNode<t>{
        t data;
        t min;
        StackNode next;
        public StackNode(t d,t m){
            data = d;
            min = m;
        }
    }
    StackNode<t> top;
    int count=0,n;
    public MyStack(int n){
        this.n = n;
    }
    public boolean isFull(){
        return count==n;
    }
    public void push(t data,t min){
        StackNode<t> n = new StackNode<>(data,min);
        if(top==null)
            top = n;
        else{
            n.next = top;
            top = n;
        }
        count++;
    }
    public t pop(){
        if(top==null) return null;
        else{
            count--;
            StackNode temp = top;
            top = top.next;
            return (t)temp.data;
        }
    }
    public t peek(){
        if(top==null) return null;
        else return (t)top.data;
    }
    public t peekMin(){
        if(top==null) return null;
        else return (t)top.min;
    }
    public boolean isEmpty(){
        return top==null;
    }
    public int getCount(){
        return count;
    }
}
