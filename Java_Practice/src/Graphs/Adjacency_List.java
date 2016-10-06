package Graphs;

/**
 * Created by SanthoshVarathan on 03/09/16.
 */
public class Adjacency_List {
    Adjacency_List_Node c, head;
    Linker_Node l;
    public Adjacency_List(){
      // head = new Adjacency_List_Node('\0');
}
    public void addListNode(char element){c=head;
        if(c==null)head=new Adjacency_List_Node(element);
        else{
            while(c.next!=null)c=c.next;
            Adjacency_List_Node newnode = new Adjacency_List_Node(element);
            c.next=newnode;
        }
    }
    public void addLink(char element,char link){c=head;Adjacency_List_Node v=head;Linker_Node l;
        while(c.element!=element&&c!=null)c=c.next;l=c.link;
        while(v.element!=link)v=v.next;
        if(l==null) c.link=new Linker_Node(v);
           else{
            while (l.next != null) l = l.next;
            Linker_Node newnode = new Linker_Node(v);
            l.next = newnode;
        }
    }
    public void printList(){c=head;
        while(c!=null){l=c.link;
            System.out.print(c.element);
            while(l!=null){
                System.out.print("->"+l.v.element);l=l.next;
            }
            if(c.next!=null)System.out.print("\n|\n");c=c.next;
        }
    }
}
