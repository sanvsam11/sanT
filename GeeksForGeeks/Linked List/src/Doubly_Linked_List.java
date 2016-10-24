/**
 * Created by SanthoshVarathan on 21/08/16.
 */
public class Doubly_Linked_List<t> {
    class node<t>{
        t element;
        node next;
        Object o = new Object();
        public node(t element){
            this.element=element;
            next=null;
        }
        public node(){
            element=null;next=null;
        }
    }
    node head,t;
    public Doubly_Linked_List(t element){
        head = new node(element);
    }
    public Doubly_Linked_List(){
        head=null;
    }
    public void insertElement(t element){
        if(head==null)head = new node(element);
        else {t=head;
            while(t.next!=null)t=t.next;
            node newnode = new node(element);
            t.next=newnode;
        }
    }
}
