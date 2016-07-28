/**
 * Created by SanthoshVarathan on 28/07/16.
 */
public class Linked_list {
    class node_i{
        int element;
        node_i next;
    public  node_i(){
        element=0;next=null;
    }
        public node_i(int element){
            this.element=element;next=null;
        }
    }
    node_i head,n;

    public Linked_list(int element){
        head=new node_i(element);
    }
    public Linked_list(){
        head=null;
    }

    public void insert_int_element(int element){
        if(head==null) head=new node_i(element);
        else{n=head;
            while(n.next!=null) n=n.next;
            node_i newnode=new node_i(element);
            n.next=newnode;
        }
    }
    public void delete_int_element(int element){
        if(head==null) System.out.println("List non existent. moron.");
        else if(head.element==element) {head=null;System.out.println("Deleted the only element. Dumass.");}
        else{n=head;
            while(n!=null){
                if(n.next.element==element){
                    node_i temp=n.next;
                    n.next=temp.next;
                }
            n=n.next;}
        }
    }
    public void print_list() {
        if (head == null) System.out.println("Print what? spaces??");
        else {
            n = head;
            System.out.println("The Linked List:");
            while (n != null) {
                System.out.print(n.element + " ");
                n = n.next;
            }
        }
    }
    public int length_linkedlist(Linked_list l){
        int length=0;n=l.head;
        while(n!=null){n=n.next;length++;}
        return length;
    }
    public int add_equal_lists(node_i a,node_i b,node_i r){int c=0;
        if(a.next!=null) c=add_equal_lists(a.next,b.next,r.next);
        c = a.element+b.element+c;
        if(c<9) {r.element=c; return 0;}
        else {r.element = c%10; return c/10;}
    }
    public Linked_list Add_two_numbers(Linked_list a, Linked_list b){
        Linked_list r=new Linked_list(0);
        int a_length=length_linkedlist(a),b_length=length_linkedlist(b);
        node_i a_iterator=a.head,r_iterator=r.head,b_iterator=b.head;
        if(a_length!=b_length){int d=((a_length-b_length)>0)?a_length-b_length:b_length-a_length;
            r=new Linked_list(a.head.element);
            d--;
            while(d>0){
                a_iterator=a_iterator.next;
                r.insert_int_element(a_iterator.element);
                r_iterator=r_iterator.next;
            d--;}
        }
        else{int length=a_length;length--;
            while(length>0){
                r.insert_int_element(0);
            length--;}
            int c= 0;c=add_equal_lists(a_iterator,b_iterator,r_iterator);
            if(c!=0){
                node_i newnode=new node_i(c);
                newnode.next=r.head;
                r.head=newnode;
            }
        }
    return r;
    }
    public static void main(String ar[]){
        Linked_list temp=new Linked_list();
        Linked_list ml=new Linked_list(5);
        //ml.delete_int_element(1);
        //ml.insert_int_element(1);
        ml.insert_int_element(2);
        ml.insert_int_element(5);
        //ml.print_list();
        Linked_list ml2=new Linked_list(5);
        ml2.insert_int_element(2);
        ml2.insert_int_element(5);
        Linked_list r = temp.Add_two_numbers(ml,ml2);
        r.print_list();
    }
}
