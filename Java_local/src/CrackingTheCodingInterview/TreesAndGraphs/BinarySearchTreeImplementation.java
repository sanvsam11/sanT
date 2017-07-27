package CrackingTheCodingInterview.TreesAndGraphs;

/**
 * Created by SanthoshVarathan on 09/07/17.
 */
public class BinarySearchTreeImplementation<t extends Comparable<t>> {
    TreeNode root, currentNode;
    public TreeNode getRoot(){
        return root;
    }
    public void insert(t data){
        TreeNode newnode = new TreeNode(data);
        currentNode = root;
        while(true){
            if(currentNode==null){
                currentNode = newnode;
                return;
            }
            if(data.compareTo((t)currentNode.getData())<0)
                currentNode = currentNode.getLeft();
            else
                currentNode = currentNode.getRight();
            }
    }
    public TreeNode getNode(t data,TreeNode n){
        if(n==null)
            return null;
        if(n.getData()==data)
            return n;
        else if(data.compareTo((t)n.getData())<0)
            return getNode(data,n.getLeft());
        else
            return getNode(data,n.getRight());
    }
    public void delete(t data,TreeNode n){
        if(n.getData()==data){
            if(n.isLeaf())
                n=null;
            else if(n.getLeft()==null||n.getRight()==null){
                TreeNode targetNode = (n.getLeft()==null)?n.getRight():n.getLeft();
                n.setData(targetNode.getData());
                n.setLeft(targetNode.getLeft());
                n.setRight(targetNode.getRight());
                targetNode = null;
            }
            else{

            }
        }
    }
}
