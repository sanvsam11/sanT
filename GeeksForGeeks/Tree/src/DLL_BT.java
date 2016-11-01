/**
 * Created by SanthoshVarathan on 21/08/16.
 */
public class DLL_BT {
    public node treeToList(node n){
        n.left = treeToList(n.left,null,true);
        n.right = treeToList(n.right,n,false);
        return n;
    }
    public boolean isLeaf(node n){
        return (n.left==null&&n.right==null)?true:false;
    }
    public node treeToList(node n,node a,boolean lr){
        if(!isLeaf(n.left)&&!isLeaf(n.right)){
            if(!lr){
                node l=treeToList(n.left,a,true);
                l.right=n;
                n.left = l;
                node r=treeToList(n.right,n,false);
                return n;
            }
            else{
                n.left=treeToList(n.left,null,true);
                node r = treeToList(n.right,n,false);
                r.right=a;
                a.left=r;
                return n;
            }
        }
        else if(isLeaf(n.left)&&isLeaf(n.right)){
                n.left.left = a;
                n.left.right = n;
                n.right.left = n;
                return n.right;
        }
        return null;
    }
    public void printList(node l){
        while(l.left!=null) l=l.left;
        while(l.right!=null) {System.out.println(l.element);l=l.right;}
    }
    public static void main(String ar[]){
        BinaryTree<Character> tl = new BinaryTree<>('a');
        tl.root.left = new node('b');
        tl.root.right = new node('c');
        tl.root.left.left = new node('d');
        tl.root.left.right = new node('e');
        tl.root.right.left=new node('f');
        tl.root.right.right=new node('g');
        tl.root = new DLL_BT().treeToList(tl.root); //left is true, right is false;
        new DLL_BT().printList(tl.root);
    }
}
