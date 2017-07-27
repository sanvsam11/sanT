package CrackingTheCodingInterview.StacksAndQueues;

import java.util.Random;

/**
 * Created by SanthoshVarathan on 07/07/17.
 */
public class StackSorter {
    public MyStack<Integer> insertSorted(int data,MyStack<Integer> s){
        if(s.isEmpty()||s.peek()>data)
            s.push(data,0);
        else {
            int temp = s.pop();
            s = insertSorted(data,s);
            s.push(temp,0);
        }
        return s;
    }
    public MyStack sort(MyStack<Integer> s){
        MyStack<Integer> tempStack = new MyStack<>(s.getCount());
        while(!s.isEmpty())
            tempStack.push(s.pop(),0);
        while(!tempStack.isEmpty())
            s = insertSorted(tempStack.pop(),s);
        return s;
    }
    public static void main(String ar[]){
        MyStack<Integer> testStack = new MyStack<>(10);
        Random r = new Random();
        for(int i=0;i<10;i++)
            testStack.push(r.nextInt(10),0);
        testStack = new StackSorter().sort(testStack);
        while(!testStack.isEmpty())
            System.out.print(testStack.pop()+" ");
    }
}
