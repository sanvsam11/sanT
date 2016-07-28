/**
 * Created by SanthoshVarathan on 24/07/16.
 */
public class Stack_class {
    class node{
        tree_1 element;
        node next;

        public node(tree_1 element){
            this.element=element;
        }
        public node(){
            this .element=null;
        }
    }
    node top=new node();
    public Stack_class(tree_1 element){
        top.element=element;
        top.next=null;
    }
    public  Stack_class(){
        top=null;
    }
    public void push(tree_1 element){
        node newnode=new node(element);
            newnode.next=top;
            top=newnode;

    }
    public tree_1 pop(){
        if(top.next!=null) {
            node temp = top;
            top = top.next;
            return temp.element;
        }
        return null;
    }
    public void printStack(){
        while(top!=null){
            System.out.println(top.element.element);
            top=top.next;
        }
    }
/*
    public static void main(String ar[]){
        tree_1 t1=new tree_1(1);
        tree_1 t2=new tree_1(3);
        tree_1 t3=new tree_1(4);
        Stack_class s = new Stack_class(t1);
        s.push(t2);
        s.push(t3);
        s.printStack();
    }
*/
}
