package CrackingTheCodingInterview.StacksAndQueues;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SanthoshVarathan on 07/07/17.
 */
public class SetOfStacks<t> {
    List<MyStack<t>> StackSet;
    int n;
    public SetOfStacks(int n){
        this.n=n;
        StackSet = new ArrayList<MyStack<t>>();
        //StackSet.add(new MyStack<t>(n));
    }
    public void push(t data){
        if(StackSet.isEmpty())
            StackSet.add(new MyStack<t>(n));
        if(StackSet.get(StackSet.size()-1).isFull())
            StackSet.add(new MyStack<t>(n));
        StackSet.get(StackSet.size()-1).push(data,null);
    }
    public t pop(){
        if(StackSet.isEmpty())
            return null;
        t temp = StackSet.get(StackSet.size()-1).pop();
        if(StackSet.get(StackSet.size()-1).isEmpty())
            StackSet.remove(StackSet.size()-1);
        return temp;
    }
    public t popAt(int index){
        return StackSet.get(index).pop();
    }
    public boolean isEmpty(){
        return StackSet.size()==0;
    }
    public t peek(){
        if(isEmpty())
            return null;
        else
            return StackSet.get(StackSet.size()-1).peek();
    }
    public static void main(String ar[]){
        SetOfStacks<Integer> stackSetObject = new SetOfStacks<>(3);
        for(int i=0;i<9;i++)
            stackSetObject.push(i);
        System.out.println(stackSetObject.pop());
        System.out.println(stackSetObject.popAt(0));
        while(!stackSetObject.isEmpty())
            System.out.print(stackSetObject.pop()+" ");
    }
}
