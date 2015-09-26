/**
 * Created by sant on 23/9/15.
 */
public class LeastCommonAncestor {
    static boolean found=false;
    static char LCA;
    StackMaker TStack=new StackMaker();
    public void ResetObject(){
        found=false;TStack.EmptyStack();
    }
    public void FindPath(tnode n, tnode l){
        if(n!=null&&!found)if(n.element!=l.element){
            TStack.push(n);
            FindPath(n.left,l);
            if(!found)FindPath(n.right,l);
            if(!found)TStack.pop();
        }else {found=true;TStack.push(n);}
    }
    public void LCA_Finder(StackMaker s1, StackMaker s2){
        while (true){tnode a=s1.pop();tnode b=s2.pop();
            if(a==b){LCA=a.element;break;}
        }
    }
/*
    public static void main(String ar[]){
        BinaryTreeMaker TestTree=new BinaryTreeMaker();
        StackMaker TStack1=new StackMaker();
        StackMaker TStack2=new StackMaker();
        LeastCommonAncestor object=new LeastCommonAncestor();
        TestTree.InsertNode('a');TestTree.InsertNode('b');TestTree.InsertNode('c');TestTree.InsertNode('d');
        TestTree.InsertNode('e');TestTree.InsertNode('f');TestTree.InsertNode('g');TestTree.InsertNode('h');
        TestTree.InsertNode('i');TestTree.InsertNode('j');TestTree.InsertNode('k');TestTree.InsertNode('l');
        TestTree.InsertNode('m');TestTree.InsertNode('n');TestTree.InsertNode('o');
        object.FindPath(TestTree.Root, new tnode('j'));object.TStack.CopyStack(TStack1);TStack1.PrintStack();
        object.ResetObject();
        object.FindPath(TestTree.Root, new tnode('k'));object.TStack.CopyStack(TStack2);TStack2.PrintStack();
        object.LCA_Finder(TStack1,TStack2);
        System.out.println(object.LCA);

    }
	*/
}
