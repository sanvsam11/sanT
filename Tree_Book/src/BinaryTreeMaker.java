/**
 * Created by sant on 14/9/15.
 */
public class BinaryTreeMaker{
    QueueMaker BTEnabler=new QueueMaker();
    QueueMaker TPrintQueue=new QueueMaker();
    tnode Root=null,c;

    public BinaryTreeMaker(){Root=null;}
    public void InsertNode(char element){
        while(true){
            if(Root==null){tnode newnode=new tnode(element);c=
                    Root=newnode;BTEnabler.push(newnode);TPrintQueue.push(newnode);break;}
            else{
                if(c.left==null){tnode newnode=new tnode(element);c.left=newnode;BTEnabler.push(newnode);break;}
                else if(c.right==null) {tnode newnode=new tnode(element);c.right=newnode;BTEnabler.push(newnode);break;}
                else c=BTEnabler.pop();
            }
        }
    }
    public void DisplayTree(){
        while(true){
            c=TPrintQueue.pop();
            if(c!=null) { System.out.println(c.element);
            TPrintQueue.push(c.left);TPrintQueue.push(c.right);}
            else break;
        }
    }
    public static void main(String ar[]){
        BinaryTreeMaker testtree=new BinaryTreeMaker();

        testtree.InsertNode('a');
        testtree.InsertNode('b');
        testtree.InsertNode('c');
        testtree.InsertNode('d');

        testtree.DisplayTree();
    }
}
