package CrackingTheCodingInterview.TreesAndGraphs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by SanthoshVarathan on 09/07/17.
 */
public class BinaryTreeImplementation<t> {
    TreeNode<t> root,currentNode;
    Queue<TreeNode> orderQueue;
    public BinaryTreeImplementation(){
        orderQueue = new ArrayDeque<>();
    }
    public TreeNode getRoot(){
        return root;
    }
    public void insert(t data){
        TreeNode newnode = new TreeNode(data);
        if(root==null)
            root = new TreeNode<>(data);

        else{
            currentNode = orderQueue.peek();
            if(currentNode.isLeaf())
                currentNode.setLeft(newnode);
            else{
                currentNode.setRight(newnode);
                orderQueue.remove();
            }
        }
        orderQueue.add(newnode);
    }
    public void printTreeInOrder(TreeNode n){
        if(n==null)
            return;
        printTreeInOrder(n.getLeft());
        System.out.print(n.getData()+" ");
        printTreeInOrder(n.getRight());
    }
}
