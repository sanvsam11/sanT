package GeeksforGeeks.BinaryTree;

/**
 * Created by SanthoshVarathan on 12/04/17.
 */
public class node<e> {
    e element;
    node<e> left;
    node<e> right;
    public node(e element){
        this.element=element;
        left=null;
        right=null;
    }
}
