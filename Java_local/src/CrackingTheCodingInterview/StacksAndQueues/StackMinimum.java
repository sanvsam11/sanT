package CrackingTheCodingInterview.StacksAndQueues;

/**
 * Created by SanthoshVarathan on 07/07/17.
 */
public class StackMinimum {
    MyStack<Integer> minimumStack = new MyStack<>(100);
    public void push(int data){
        if(minimumStack.isEmpty()||data<minimumStack.peekMin())
            minimumStack.push(data,data);
        else
            minimumStack.push(data,minimumStack.peekMin());
    }
    public int pop(){
        return (Integer)minimumStack.pop();
    }
    public int peek(){
        return (Integer)minimumStack.peek();
    }
    public int getMin(){
        return (Integer)minimumStack.peekMin();
    }
    public boolean isEmpty(){
        return minimumStack.isEmpty();
    }

    public static void main(String ar[]){
        StackMinimum s = new StackMinimum();
        s.push(10);
        s.push(6);
        s.push(20);
        s.push(4);
        s.push(1);
        System.out.println(s.getMin());
    }
}
