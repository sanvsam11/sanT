/**
 * Created by SanthoshVarathan on 09/08/16.
 */
public class Binary_Search_Tree {
    class node{
        int element;
        node left,right;
    public node(int element){
        this.element=element;
        left=null;right=null;
    }
        public node(){
            element=0;
            left=null;right=null;
        }

    }
    node root;int lhd=0,rhd=0;
    public Binary_Search_Tree(){}
    public Binary_Search_Tree(int element){
        root=new node(element);
    }
    public Binary_Search_Tree(node n){
        root=n;
    }
    public void insertelement(int element){                         // caller for insert element function
        if(root==null)root = new node(element);
        else if(!(element>root.element))root.left=insertelement(root.left,element);
        else root.right=insertelement(root.right,element);
    }
    public node insertelement(node n,int element){
            if(n==null) return n=new node(element);
        else if(element>n.element) n.right=insertelement(n.right,element);
        else n.left=insertelement(n.left,element);
        return n;
    }
    public void printPreorder(node n){
        if(n!=null){
            System.out.print(n.element+" ");
            printPreorder(n.left);
            printPreorder(n.right);
        }
    }
    public void printPreorder(){                                    // caller for preorder function
        printPreorder(root);
    }
    public void printInorder(node n){
        if(n!=null){
            printInorder(n.left);
            System.out.print(n.element+" ");
            printInorder(n.right);
        }
    }
    public void printInorder(){                                     //caller for inorder function
        printInorder(root);
    }
    public void hdFinder(node n,int hd){
        if(n==null)return;
        else{
            if(hd<lhd)lhd=hd;
            else if(hd>rhd)rhd=hd;
                hdFinder(n.left,hd-1);
                hdFinder(n.right,hd+1);

        }
    }
    public void printVerticalOrder(node n,int l,int r,int hd){
        for(int i=l;i<=r;i++){
            printVerticalOrder(n,i,hd);System.out.println(" ");
        }
    }
    public void printVerticalOrder(node n,int v,int hd){
        if(n==null) return;
        if(hd==v) System.out.print(n.element+" ");

            printVerticalOrder(n.left,v,hd-1);
            printVerticalOrder(n.right,v,hd+1);

    }
    public void printVerticalOrder(){                           //caller for vertical printer function and width finder
        hdFinder(root,0);
        printVerticalOrder(root,lhd,rhd,0);
    }


    public static void main(String ar[]){
        Binary_Search_Tree mtree=new Binary_Search_Tree(5);
        mtree.insertelement(2);
        mtree.insertelement(1);
        mtree.insertelement(3);
        mtree.insertelement(4);
        mtree.insertelement(7);
        mtree.insertelement(6);
        mtree.insertelement(8);
        //mtree.printPreorder();
        //mtree.printInorder();
        mtree.printVerticalOrder();
        System.out.println(" ");
        mtree.printInorder();
        System.out.println(" ");
        mtree.printPreorder();
    }
}
