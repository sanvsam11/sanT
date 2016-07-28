/**
 * Created by SanthoshVarathan on 24/07/16.
 */
public class tree_1 {
    int element;
    tree_1 left;
    tree_1 right;
    //Stack_class s=new Stack_class();
    Queue_class q=new Queue_class(this);
    public tree_1(int element){
        this.element=element;
        left=null;
        right=null;
    }
    public tree_1(){
        element=0;left=null;right=null;
    }
    public boolean isLeaf(tree_1 t){
        return (t.left==null&&t.right==null)?true:false;
    }
    public tree_1 insertElement(int element){tree_1 t=q.dequeue();
            //if(t==null){t=new tree_1(element);}
            if(t.left==null){t.left=new tree_1(element);q.enqueue(t);}
            else if(t.right==null) {t.right=new tree_1(element);q.enqueue(t.left);q.enqueue(t.right);}
            //else {q.enqueue(t.left);q.enqueue(t.right);t=insertElement(element);}
        return t;
    }
    public void preOrder(tree_1 t){
        if(t!=null){
            System.out.print(t.element+" ");
            preOrder(t.left);
            preOrder(t.right);
        }
    }
    public void inOrder(tree_1 t){
        if(t!=null){
            inOrder(t.left);
            System.out.print(t.element+" ");
            inOrder(t.right);
        }
    }

    public void printTree(tree_1 r){
        System.out.println("Tree in Pre-Order format:");
        preOrder(r);
    }
    public void boundary_left(tree_1 t){
        if(!isLeaf(t)) {System.out.print(t.element+" ");boundary_left(t.left);}
    }
    public void boundary_leaves(tree_1 t){
        if(t.left!=null)boundary_leaves(t.left);
        if(isLeaf(t))System.out.print(t.element+" ");
        if(t.right!=null)boundary_leaves(t.right);
    }
    public void boundary_right(tree_1 t){
        if(t.right.right!=null)boundary_right(t.right);
        System.out.print(t.element+" ");
    }
    public void boundary_printer(tree_1 t){
        System.out.println("Tree boundary nodes:");
       boundary_left(t);
       boundary_leaves(t);
        boundary_right(t);
    }
    public static void main(String ar[]){
        tree_1 mt = new tree_1(1);

       /* mt.left=mt.insertElement(4);
        mt.left.left=mt.insertElement(2);
        mt.left.right=mt.insertElement(3);
        mt.right=mt.insertElement(7);
        mt.right.left=mt.insertElement(6);
        mt.right.right=mt.insertElement(8);
        mt.printTree(mt);
        */

        mt.insertElement(2);
        mt.insertElement(3);
        mt.insertElement(4);
        mt.insertElement(5);
        mt.insertElement(6);
        mt.insertElement(7);
        mt.insertElement(8);
        mt.insertElement(9);
        mt.insertElement(10);
        mt.insertElement(11);
        mt.printTree(mt);
        mt.boundary_printer(mt);

    }
}
