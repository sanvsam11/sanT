/**
 * Created by SanthoshVarathan on 28/07/16.
 */
public class Queue_node {
    class node{
        Binary_tree.node element;
        node next;
        public node(Binary_tree.node element){
            this.element=element;next=null;
        }
        public node(){
            element=null;next=null;
        }
    }
    node front,rear;
    public Queue_node(Binary_tree.node element){
        front=new node(element);
        rear=front;
    }
    public void enqueue(Binary_tree.node n){
        if(front==null){front=new node(n);rear=front;}
        else {
            node newnode=new node(n);
            rear.next=newnode;
        }
    }
    public Binary_tree.node dequeue(){
        if(front==null||rear==null) return null;
        else if(front==rear){
            node temp=front;
            front=null;rear=null;
            return temp.element;}
        else{
            node temp=front;
            front=front.next;
            return temp.element;
        }
    }
}
