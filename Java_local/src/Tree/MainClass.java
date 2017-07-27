package Tree;

/**
 * Created by SanthoshVarathan on 27/04/17.
 */
public class MainClass {
    public static void main(String ar[]){
        Binary_Search_Tree mytree = new Binary_Search_Tree(5);
        mytree.insertNode(2);
        mytree.insertNode(7);
        mytree.insertNode(1);
        mytree.insertNode(3);
        mytree.insertNode(6);
        mytree.insertNode(8);
        //mytree.insertNode(4);

        mytree.printInorder();
        System.out.println(mytree.isBalanced());
    }
}
