package Graphs;

/**
 * Created by SanthoshVarathan on 03/09/16.
 */
public class Linker_Node {
    char element;
    Linker_Node next;
    public Linker_Node(char element){
        this.element=element;
        next=null;
    }
    public boolean hasNext(){
        return (next==null)?false:true;
    }

}
