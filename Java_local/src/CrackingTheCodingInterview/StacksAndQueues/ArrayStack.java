package CrackingTheCodingInterview.StacksAndQueues;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SanthoshVarathan on 07/07/17.
 */
public class ArrayStack {
    int s1,s2,s3,n;
    int threeStack[];
    ArrayStack(int n) {
        n=n;
        threeStack = new int[n];
        s1 = 0;s2 = n/2;s3 = n-1;
    }
    public void push(int stackId,int data){
        if(stackId==1){
            if((s1+1)==n/2)
                System.out.println("Failed to push to stack 1");
            else
                threeStack[s1++]=data;
        }
        else if(stackId==2){
            if((s2+1)==s3)
                System.out.println("Failed to push to stack 2");
            else
                threeStack[s2++]=data;
        }
        else{
            if((s3-1)==s2)
                System.out.println("Failed to push to stack 3");
            else
                threeStack[s3--]=data;
        }
    }
    public int pop(int stackId){
        int temp=0;
        if(stackId==1){
            if(s1!=0)
                temp = threeStack[s1--];
        }
        else if(stackId==2){
            if(s2!=n/2)
                temp = threeStack[s2--];
        }
        else{
            if(s3!=n)
                temp = threeStack[s3++];
        }
        return temp;
    }
    public static void main(String ar[]){
        ArrayStack tripleStack = new ArrayStack(9);
        for(int j=0;j<3;j++)
            for(int i=1;i<4;i++)
                tripleStack.push(i,j);

        for(int i=0;i<3;i++) {
            for (int j = 0; j < 3; j++)
                System.out.print(tripleStack.pop(i+1));
            System.out.println();
        }
    }
}
