/**
 * Created by SanthoshVarathan on 24/07/16.
 */
public class Stack_class {
    class node{
        int element;
        node next;

        public node(int element){
            this.element=element;
        }
    }
    node top=new node(0);
    public Stack_class(int element){
        top.element=element;
        top.next=null;
    }
    public void push(int element){
        node newnode=new node(element);
            newnode.next=top;
            top=newnode;

    }
    public void pop(){
        if(top!=null){node temp=top;
            top=top.next;
        }
    }
    public void printStack(){
        while(top!=null){
            System.out.println(top.element);
            top=top.next;
        }
    }

    public static void main(String ar[]){
        Stack_class s = new Stack_class(1);
        s.push(2);
        s.push(3);
        s.printStack();
    }
}
