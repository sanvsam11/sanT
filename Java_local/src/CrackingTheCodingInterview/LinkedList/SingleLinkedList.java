package CrackingTheCodingInterview.LinkedList;

import java.util.Random;

/**
 * Created by SanthoshVarathan on 06/07/17.
 */
class node<e>{
    e data;
    node next = null;
    public node(e d){
        data = d;
    }
}
public class SingleLinkedList<e> implements LinkedList<e>{
    private node head,runner;
    public node getHead(){
        return head;
    }
    public void setHead(node h) {
        head = h;
    }
    public node getTail(){
        runner = head;
        while(runner.next!=null)
            runner = runner.next;
        return runner;
    }
    public void insert(e data){
        if(head==null) head = new node(data);
        else{
            runner = head;
            while(runner.next!=null) runner = runner.next;
            runner.next = new node(data);
        }
    }
    public boolean contains(e data){
        runner = head;
        while(runner!=null)
            if(runner.data==data) return true;
        return false;
    }
    public void delete(e data){
        runner = head;
        while(runner.next.data!=data) runner = runner.next;
        runner.next = runner.next.next;
    }
    public void printList(){
        runner = head.next;
        System.out.print(head.data);
        while(runner!=null){
            System.out.print("->"+runner.data);
            runner = runner.next;
        }
        System.out.println();
    }
    public static LinkedList<Integer> generateTestList(int n,boolean sequence){
        LinkedList<Integer> list = new SingleLinkedList<>();
        if(sequence)
            for(int i=1;i<=n;i++)
                list.insert(i);
        else{
            Random r = new Random();
            int x = n;
            while(n-->0)
                list.insert(r.nextInt(x));
        }
        return list;
    }
}
