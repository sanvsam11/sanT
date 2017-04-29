package GeeksforGeeks.BinaryTree;

/**
 * Created by SanthoshVarathan on 08/03/17.
 */
class BinaryTree<e> {
    node<e> root;
    public node insert(e element){
        if(root==null) root = new node(element);
        return root;
    }
    public void insert(node n,e element){
        if(n.left==null) n.left=new node(element);
        else if(n.right==null) n.right = new node(element);
    }
    public void delete(node n){
        if(n.right!=null) n.right=null;
        else n.left=null;
    }
    public void printInOrder(node n){
        if(n==null) return;
            printInOrder(n.left);
            System.out.print(n.element+" ");
            printInOrder(n.right);
    }
    public void printLevelOrder(nodeQueue q){
        while(!q.isEmpty()){
            node<Character> pop = q.dequeue();
            System.out.print(pop.element+" ");
            if(pop.left!=null) q.enqueue(pop.left);
            if(pop.right!=null) q.enqueue(pop.right);
        }
    }
    public void printLevelOrderSpiral(nodeQueue q){

    }
}

public class MyBinaryTree{
    public static void main(String ar[]){
        BinaryTree<Character> duplicateTree = new BinaryTree<>();
        node<Character> root = duplicateTree.insert('a');
        duplicateTree.insert(root,'b');
        duplicateTree.insert(root,'c');
        duplicateTree.insert(root.left,'d');
        duplicateTree.insert(root.left,'e');
        duplicateTree.insert(root.left.left,'y');
        duplicateTree.insert(root.left.left,'z');
        duplicateTree.insert(root.right,'f');
        duplicateTree.insert(root.right,'g');
        //duplicateTree.printInOrder(root);
        nodeQueue<Character> levelQueue = new nodeQueue<>(root);
        duplicateTree.printLevelOrder(levelQueue);
    }
}
