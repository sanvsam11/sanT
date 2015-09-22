/**
 * Created by sant on 14/9/15.
 */
public class BinaryTreeMaker{
    QueueMaker BTEnabler=new QueueMaker();
    QueueMaker BTQueue =new QueueMaker();
    QueueMaker ZZQ=new QueueMaker();
    StackMaker RZZQ=new StackMaker();
    StackMaker BTStack=new StackMaker();
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
            else if(c==z){
               if(zz) while(true) {c=ZZQ.pop();
                if(c==null)break;
                else System.out.println(c.element);
            }
                else while(true) {c=RZZQ.pop();
                   if(c==null)break;
                   else System.out.println(c.element);
               }

           zz=!zz;BTQueue.push(z); }
            else{BTQueue.push(c.left);BTQueue.push(c.right);
                if(zz){ZZQ.push(c.left);ZZQ.push(c.right);}
                else{RZZQ.push(c.left);RZZQ.push(c.right);
                //ZZQ.push(c.right);ZZQ.push(c.left);
                }
            }
        }
    }

    public void TreeBoundaryPrinter(){c=Root;StackMaker RevRit=new StackMaker();
        while(true){
            if(c.left!=null)System.out.println(c.element);
            else break;
        c=c.left;}
        BTQueue.EmptyQueue();
        BTQueue.push(Root);while(true){c=BTQueue.pop();
            if(c==null) break;
            else{if(c.left==null&&c.right==null)System.out.println(c.element);
                BTQueue.push(c.left);BTQueue.push(c.right);}
        }

        c=Root;while(true){
            if(c.right!=null)RevRit.push(c);
            else break;
        c=c.right;}RevRit.PrintStack();
    }

    public void PrintInOrder(){c=Root;BTStack.EmptyStack();BTStack.push(Root);
        while(true){
            if(c!=null){BTStack.push(c.left);c=c.left;}
            else{c=BTStack.pop();System.out.println(c.element);
                BTStack.push(c.right);c=c.right;
                if(BTStack.EmptyStackCheck())break;
            }
        }
    }
    public void PrintPostOrder(){c=Root;BTStack.EmptyStack();BTStack.push(Root);
        while(true){
            if(c!=null){
                BTStack.push(c.right);
                BTStack.push(c.left);
                c=c.left;
            }
            else {c=BTStack.pop();
                int i=BTStack.CountStack();
                System.out.println(c.element);
                if(i!=1){c=null;}
                if(BTStack.EmptyStackCheck())break;
            }
        }
    }
//Aide configured
    public tnode CreateTree_Pre_In(CQueueMaker PQ,CQueueMaker IQ){char PC,IC;
        PC=PQ.pop();tnode N=new tnode(PC);
        CQueueMaker l=new CQueueMaker();CQueueMaker r=new CQueueMaker();
        while(true){IC=IQ.pop();
            if(PC==IC)break; l.push(IC);}
        while (!IQ.IsEmpty())r.push(IQ.pop());
        if(!(PQ.IsEmpty()||l.IsEmpty()||r.IsEmpty())){N.left=CreateTree_Pre_In(PQ,l); N.right=CreateTree_Pre_In(PQ,r);}
        return N;
    }
    public static void main(String ar[]){
        BinaryTreeMaker testtree=new BinaryTreeMaker();
/*
        testtree.InsertNode('a');
        testtree.InsertNode('b');
        testtree.InsertNode('c');
        testtree.InsertNode('d');
        testtree.InsertNode('e');
        testtree.InsertNode('f');
        testtree.InsertNode('g');<<<<<<< HEAD

//<<<<<<< HEAD
=======
        testtree.PrintPostOrder();
=======
*/
       // testtree.PrintPostOrder();
//>>>>>>> branch 'master' of https://github.com/sanvsam11/sanT.git
        //testtree.PrintInOrder();
//>>>>>>> branch 'master' of https://github.com/sanvsam11/sanT.git
        //testtree.TreeBoundaryPrinter();
        //testtree.ZigzagPrint();
        testtree.DisplayTree();
        //System.out.println("max:"+testtree.SumatLevels());

        CQueueMaker InQ=new CQueueMaker();
        InQ.push('d');InQ.push('b');InQ.push('e');InQ.push('a');InQ.push('f');InQ.push('c');InQ.push('g');
        CQueueMaker PrQ=new CQueueMaker();
        PrQ.push('a');PrQ.push('b');PrQ.push('d');PrQ.push('e');PrQ.push('c');PrQ.push('f');PrQ.push('g');
        testtree.Root=testtree.CreateTree_Pre_In(PrQ,InQ);
       testtree.PrintInOrder();
       // testtree.DisplayTree();
    }
}
