package Graphs;

/**
 * Created by SanthoshVarathan on 03/09/16.
 */
public class Linker_Node {
    Adjacency_List_Node v;
    Linker_Node next;
    public Linker_Node(Adjacency_List_Node element){
        v=element;
        next=null;
    }
    public boolean hasNext(){
        return (next==null)?false:true;
    }

}
