import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by sant on 14/9/15.
 */
public class Avl_Tree{// self Balancing binary search tree

    Tnode Root;

    public Avl_Tree(int element)
    {
        Root=new Tnode(element);
    }

    public Tnode InsertNode(int element,Tnode n){
        if(n==null) {n=new Tnode(element);return n;}
        else
            if(element<=n.element) n.left=InsertNode(element,n.left);
            else n.right=InsertNode(element,n.right);
                return n;
    }

    public void DisplayTree(Tnode n){
        if (n!=null){
            DisplayTree(n.left);
            System.out.println(n.element);
            DisplayTree(n.right);
        }
    }

    public static void main(String ar[]){
        Avl_Tree mytree=new Avl_Tree(2);
        mytree.InsertNode(1,mytree.Root);
        mytree.InsertNode(3,mytree.Root);
        mytree.InsertNode(4,mytree.Root);
        mytree.InsertNode(5,mytree.Root);

        mytree.DisplayTree(mytree.Root);
    }
}
