/**
 * Created by SanthoshVarathan on 24/07/16.
 */
public class tree_1 {
    int element;
    tree_1 left;
    tree_1 right;

    public tree_1(int element){
        this.element=element;
        left=null;
        right=null;
    }

    public tree_1 insertElement(tree_1 t,int element){
        if(t==null){t=new tree_1(element);}
        return t;

    }
    public void preOrder(tree_1 r){
        if(r!=null){
            System.out.print(r.element);
            preOrder(r.left);
            preOrder(r.right);
        }
    }

    public void printTree(tree_1 r){
        System.out.println("Tree in Pre-Order format:");
        preOrder(r);
    }

    public static void main(String ar[]){
        tree_1 mt = new tree_1(5);
        mt.left=mt.insertElement(mt.left,4);
        mt.left.left=mt.insertElement(mt.left.left,2);
        mt.left.right=mt.insertElement(mt.left.right,3);
        mt.right=mt.insertElement(mt.right,7);
        mt.right.left=mt.insertElement(mt.right.left,6);
        mt.right.right=mt.insertElement(mt.right.right,8);
        mt.printTree(mt);
    }
}
