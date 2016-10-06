package Stack;

/**
 * Created by SanthoshVarathan on 05/10/16.
 */
public class Stack<t> {
    node top,c;
    public Stack(t element){
        top=new node(element);
    }
    public void insertElement(t element){
        node newnode = new node(element);
        newnode.next=top;
        top=newnode;
    }
    public t deleteElement(){
        t temp = (t)top.element;
        top=top.next;
        return temp;
    }
    public void printStack(){c=top;
        while(c!=null){System.out.println(c.element);c=c.next;}
    }
    public boolean isEmpty(){
        return (top==null)?true:false;
    }
    /*
    public static void main(String ar[]){
        Stack<Integer> s = new Stack<Integer>(1);
        s.insertElement(2);
        s.insertElement(3);
        s.insertElement(4);
        s.deleteElement();
        s.printStack();
    }
    */
}
