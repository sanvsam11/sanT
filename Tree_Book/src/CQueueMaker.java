/**
 * Created by sant on 21/9/15.
 */
public class CQueueMaker {

    cqnode Head,Tail;

    public CQueueMaker(){Head=Tail=null;}
    public void push(char c){
        if(Head==null){cqnode newqnode=new cqnode(c);Head=newqnode;Tail=newqnode;}
        else{cqnode newqnode=new cqnode(c);Head.next=newqnode;Head=newqnode;}
    }
    public char pop(){char temp;
        if(Tail==null)return '0';
        else{temp=Tail.element;Tail=Tail.next;return temp;}
    }
}
