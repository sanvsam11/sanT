/**
 * Created by sant on 14/9/15.
 */
public class BinaryTreeMaker{
    QueueMaker BTEnabler=new QueueMaker();
    QueueMaker BTQueue =new QueueMaker();
    QueueMaker ZZQ=new QueueMaker();
    tnode Root=null,c;int max=0,lsum=0;boolean zz=true;

    public BinaryTreeMaker(){Root=null;}
    public void InsertNode(char element){
        while(true){
            if(Root==null){tnode newnode=new tnode(element);c=Root=newnode;BTQueue.push(newnode);break;}
            else{
                if(c.left==null){tnode newnode=new tnode(element);c.left=newnode;BTEnabler.push(newnode);break;}
                else if(c.right==null) {tnode newnode=new tnode(element);c.right=newnode;BTEnabler.push(newnode);break;}
                else c=BTEnabler.pop();
            }
        }
    }

    public int SumatLevels(){
        BTQueue.EmptyQueue();
        BTQueue.push(Root);tnode mark=new tnode('0');
        BTQueue.push(mark);
        while (true){c= BTQueue.pop();
            if(c!=null&&c!=mark) {lsum=lsum+c.element;
            BTQueue.push(c.left);
                BTQueue.push(c.right);
            }
            else if(c==mark){
                BTQueue.push(mark);
            max=(lsum>max)?lsum:max;System.out.println(lsum);lsum=0;}
            else {System.out.println(lsum);break;};
        }
        return max;
    }
    public void DisplayTree(){
        BTQueue.EmptyQueue();
        BTQueue.push(Root);
        while(true){c= BTQueue.pop();
            if(c!=null) { System.out.println(c.element);
            BTQueue.push(c.left);
                BTQueue.push(c.right);}
            else break;
        }
    }
	public void ZigzagPrint(){BTQueue.EmptyQueue();BTQueue.push(Root);ZZQ.push(Root);
        tnode z=new tnode('0');BTQueue.push(z);
        while(true){c= BTQueue.pop();
            if(c==null)break;
            else if(c==z){zz=!zz;}
            else{BTQueue.push(c.left);BTQueue.push(c.right);
                if(zz){ZZQ.push(c.left);ZZQ.push(c.right);}
                else{

                //ZZQ.push(c.right);ZZQ.push(c.left);
                }
            }
        }
        while(true) {c=ZZQ.pop();
            if(c==null)break;
            else System.out.println(c.element);
        }
    }
    public static void main(String ar[]){
        BinaryTreeMaker testtree=new BinaryTreeMaker();

        testtree.InsertNode('a');
        testtree.InsertNode('b');
        testtree.InsertNode('c');
        testtree.InsertNode('d');
        testtree.InsertNode('e');
        testtree.InsertNode('f');
        testtree.InsertNode('g');

        testtree.ZigzagPrint();
        //testtree.DisplayTree();
        //System.out.println("max:"+testtree.SumatLevels());
    }
}
