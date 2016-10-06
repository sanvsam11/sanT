package Graphs;

/**
 * Created by SanthoshVarathan on 03/09/16.
 */
public class Adjacency_List_Node {
    char element;
    Adjacency_List_Node next;
    Linker_Node link;
    int state;
    public Adjacency_List_Node(char element){
        this.element=element;
        link=null;next=null;
    }
    public boolean hasNextListNode(){
        return (next==null)?false:true;
    }
    public boolean hasLink(){
        return (link==null)?false:true;
    }
}
