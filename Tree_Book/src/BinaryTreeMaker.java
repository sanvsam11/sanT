/**
 * Created by sant on 14/9/15.
 */
public class BinaryTreeMaker{
    QueueMaker BTEnabler=new QueueMaker();
    QueueMaker TPrintQueue=new QueueMaker();
    tnode Root,c;

    public BinaryTreeMaker(){Root=null;}
    public void InsertNode(char element){ c=Root;
        while(true){
            if(c==null){tnode newnode=new tnode(element);Root=newnode;BTEnabler.push(newnode);TPrintQueue.push(newnode);break;}
            else{c=BTEnabler.pop();
                if(c.left==null){tnode newnode=new tnode(element);c.left=newnode;BTEnabler.push(newnode);break;}
                else {tnode newnode=new tnode(element);c.right=newnode;BTEnabler.push(newnode);break;}
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
