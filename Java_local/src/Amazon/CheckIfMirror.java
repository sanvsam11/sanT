package Amazon;

import CrackingTheCodingInterview.TreesAndGraphs.TreeNode;

/**
 * Created by SanthoshVarathan on 22/07/17.
 */
public class CheckIfMirror<t> {
    boolean isMirrorMethod(TreeNode<t> a,TreeNode<t> b){
        if(a==null&&b==null)
            return true;
        else if(a==null||b==null)
            return false;
        else
            return a.getData()==b.getData()&&isMirrorMethod(a.getLeft(),b.getRight())&&isMirrorMethod(a.getRight(),b.getLeft());
    }
    TreeNode<t> reverseTree(TreeNode<t> n){
        if(n==null)
            return null;
        else{
            reverseTree(n.getLeft());
            TreeNode<t> temp = n.getLeft();
            n.setLeft(n.getRight());
            n.setRight(temp);
            reverseTree(n.getLeft());
        }
        return n;
    }
    public static void main(String ar[]){
        CheckIfMirror<Integer> instance = new CheckIfMirror<>();
        TreeNode<Integer> tree = new TreeNode<>(1);
        tree.setLeft(new TreeNode(3));
        tree.setRight(new TreeNode(2));
        tree.getRight().setLeft(new TreeNode(5));
        tree.getRight().setRight(new TreeNode(4));
        TreeNode<Integer> revTree = instance.reverseTree(tree);
        //revTree.getLeft().setLeft(new TreeNode(7));
        System.out.println(instance.isMirrorMethod(tree,revTree));
    }
}
