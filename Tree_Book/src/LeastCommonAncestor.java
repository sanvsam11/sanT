/**
 * Created by sant on 23/9/15.
 */
public class LeastCommonAncestor {

    StackMaker TStack=new StackMaker();
    public boolean FindLeafPath(tnode N,tnode L){
        if(N.left!=null&&N.right!=null){
            TStack.push(N);
            if((FindLeafPath(N.left,L)||FindLeafPath(N.right, L)))return true;
            else {TStack.pop();return false;}
        }
        else return (N==L)?true:false;
    }

    public static void main(String ar[]){
        BinaryTreeMaker TestTree=new BinaryTreeMaker();
        StackMaker TStack1=new StackMaker();
        StackMaker TStack2=new StackMaker();
        LeastCommonAncestor object=new LeastCommonAncestor();
        TestTree.InsertNode('a');TestTree.InsertNode('b');TestTree.InsertNode('c');TestTree.InsertNode('d');
        TestTree.InsertNode('e');TestTree.InsertNode('f');TestTree.InsertNode('g');TestTree.InsertNode('h');
        TestTree.InsertNode('i');TestTree.InsertNode('j');TestTree.InsertNode('k');TestTree.InsertNode('l');
        TestTree.InsertNode('m');TestTree.InsertNode('n');TestTree.InsertNode('o');
        object.FindLeafPath(TestTree.Root,new tnode('j'));
        object.TStack.PrintStack();

    }
}
