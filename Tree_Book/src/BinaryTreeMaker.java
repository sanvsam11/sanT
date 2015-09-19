/**
 * Created by sant on 14/9/15.
 */
public class BinaryTreeMaker{
    QueueMaker BTEnabler=new QueueMaker();
    QueueMaker TPrintQueue=new QueueMaker();
    tnode Root=null,c;int max=0,lsum=0;

    public BinaryTreeMaker(){Root=null;}
    public void InsertNode(char element){
        while(true){
            if(Root==null){tnode newnode=new tnode(element);c=Root=newnode;TPrintQueue.push(newnode);break;}
            else{
                if(c.left==null){tnode newnode=new tnode(element);c.left=newnode;BTEnabler.push(newnode);break;}
                else if(c.right==null) {tnode newnode=new tnode(element);c.right=newnode;BTEnabler.push(newnode);break;}
                else c=BTEnabler.pop();
            }
        }
    }

    public int SumatLevels(){TPrintQueue.EmptyQueue();TPrintQueue.push(Root);tnode mark=new tnode('0');TPrintQueue.push(mark);
        while (true){c=TPrintQueue.pop();
            if(c!=null&&c!=mark) {lsum=lsum+c.element;
            TPrintQueue.push(c.left);TPrintQueue.push(c.right);
            }
            else if(c==mark){TPrintQueue.push(mark);
            max=(lsum>max)?lsum:max;System.out.println(lsum);lsum=0;}
            else {System.out.println(lsum);break;};
        }
        return max;
    }
    public void DisplayTree(){TPrintQueue.EmptyQueue();TPrintQueue.push(Root);
        while(true){c=TPrintQueue.pop();
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
        System.out.println("max:"+testtree.SumatLevels());
    }
}
