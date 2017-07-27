package Tree;

/**
 * Created by SanthoshVarathan on 27/04/17.
 */
public class Binary_Search_Tree {
    node root;
    public Binary_Search_Tree(int data){
        root = new node(data);
    }
    public void insertNode(int data){
        insert(data,root);
    }
    node insert(int data,node n){
        if(n==null) n = new node(data);
        else
        {
            if(n.data>data) n.left=insert(data,n.left);
            else n.right=insert(data,n.right);
        }
        return n;
    }
    public void printInorder(){
        printInorder(root);
    }
    boolean isLeaf(node n)
    {
        return n.left==null&&n.right==null;
    }
    int getHeight(node n){
        if(n==null) return 0;
        else if(isLeaf(n)) return 1;
        else return Math.max(getHeight(n.left),getHeight(n.right))+1;
    }
    boolean checkBalance(node n){
        return Math.abs(getHeight(n.left)-getHeight(n.right))<=1;
    }
    boolean isBalanced(){
        return checkBalance(root);
    }
    void printInorder(node n){
        if(n!=null)
        {
            printInorder(n.left);
            System.out.print(n.data+" ");
            printInorder(n.right);
        }
    }
}
