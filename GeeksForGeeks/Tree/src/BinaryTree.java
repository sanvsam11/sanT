/**
 * Created by Santhosh Varathan on 01-Nov-16.
 */
public class BinaryTree<t> {
    node root;
    public BinaryTree(t element){
        root = new node(element);
    }
}
class node<t>{
    t element;
    node<t> left;
    node<t> right;
    public node(){
        element = null;
        left = null;
        right = null;
    }
    public node(t element){
        this.element = element;
        left = null;right = null;
    }
}
