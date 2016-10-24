/**
 * Created by SanthoshVarathan on 28/07/16.
 */
public class Binary_tree<T> {
    class node{
        T element;
        node left;node right;
        public node(T element){
            this.element=element;
            left=null;right=null;
        }
        public node(){
            this.element=null;left=null;right=null;
        }
    }
    node root=new node();
    public Binary_tree(T element){
        root.element=element;
        root.left=null;root.right=null;
    }
    public Binary_tree(){
        root.element=null;root.left=null;
        root.right=null;
    }
    public void insert_node(T element){
        root=insert_node(root,element);
    }
    Queue_node qi=new Queue_node(root);
    public node insert_node(node n,T element){n=qi.dequeue();
       /* if(n==null) n=new node(element);
        else{
            if(n.left==null) n.left=insert_node(n.left,element);
            else n.right=insert_node(n.right,element);
        }
        return n;
        */
        if(n==null)n=new node(element);
        else {
            qi.enqueue(n.left);
            qi.enqueue(n.right);
        }
        return n;
    }
    public void print_inOrder(){System.out.println("\nTree in Inorder:"); print_inOrder(root);}
    public void print_inOrder(node n){
        if(n!=null){
            print_inOrder(n.left);
            System.out.print(n.element+" ");
            print_inOrder(n.right);
        }
    }
    public void print_preOrder(){System.out.println("\nTree in preOrder:");print_preOrder(root);}
    public void print_preOrder(node n){
        if(n!=null){
            System.out.print(n.element+" ");
            print_preOrder(n.left);
            print_preOrder(n.right);
        }
    }
    public void print_postOrder(){System.out.println("\nTree in PostOrder:");print_postOrder(root);}
    public void print_postOrder(node n){
        if(n!=null){
            print_postOrder(n.left);
            print_postOrder(n.right);
            System.out.print(n.element+" ");
        }
    }
    Queue_node q=new Queue_node(root);
    //public void print_levelOrder(){print_levelOrder(root);}
    public void print_levelOrder(){node n=q.dequeue();
        if(n!=null) {
            System.out.print(n.element+" ");
            q.enqueue(n.left);
            q.enqueue(n.right);
            print_levelOrder();
        }
    }
    public static void main(String ar[]){
        Binary_tree<Character> mt=new Binary_tree<Character>('a');
        mt.insert_node('b');
        mt.insert_node('c');
        mt.insert_node('d');
        mt.insert_node('e');
        mt.insert_node('f');
        mt.print_preOrder();
        //mt.print_inOrder();
       // mt.print_postOrder();
       // mt.print_levelOrder();
    }
}
