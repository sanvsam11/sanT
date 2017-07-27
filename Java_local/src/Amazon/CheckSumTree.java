package Amazon;

import CrackingTheCodingInterview.TreesAndGraphs.TreeNode;

/**
 * Created by SanthoshVarathan on 23/07/17.
 */
public class CheckSumTree {
    public boolean checkSumTreeMethod(TreeNode<Integer> n){
        if(n.isLeaf())
            return true;
        else
            return ((int)n.getLeft().getData()+(int)n.getRight().getData())==n.getData()&&checkSumTreeMethod(n.getLeft())&&checkSumTreeMethod(n.getRight());
    }
}
