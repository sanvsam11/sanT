package CrackingTheCodingInterview.TreesAndGraphs;

/**
 * Created by SanthoshVarathan on 09/07/17.
 */
public class TreeNode<t> {
    private t data;
    private TreeNode left,right;
    public TreeNode(t d){
        data  = d;
        left = right = null;
    }
    public void setData(t d){
        data = d;
    }
    public t getData(){
        return data;
    }
    public TreeNode getLeft(){
        return left;
    }
    public TreeNode getRight(){
        return right;
    }
    public void setLeft(TreeNode l){
        left = l;
    }
    public void setRight(TreeNode r){
        right = r;
    }
    public boolean isLeaf(){
        return left==null&&right==null;
    }
}
