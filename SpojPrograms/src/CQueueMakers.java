/**
 * Created by sant on 21/9/15.
 */
public class CQueueMakers {

    cqnodes Head,Tail,c;

    public CQueueMakers(){Head=Tail=null;}
    public void push(char c){
        if(Head==null){
            cqnodes newqnode=new cqnodes(c);Head=newqnode;Tail=newqnode;}
        else{
            cqnodes newqnode=new cqnodes(c);Head.next=newqnode;Head=newqnode;}
    }
    public char pop(){char temp;
        if(Tail==Head){temp=Tail.element;Tail=Head=null;return temp;}
        else{temp=Tail.element;Tail=Tail.next;return temp;}
    }
	public void PrintCQueue(){c=Tail;
		while(c!=Head){System.out.println(c.element);c=c.next;}System.out.println(c.element);
	}
    public boolean IsEmpty(){if(Tail==null&&Head==null)return true;else return false;}
/*
	public static void main(String ar[]){
	
	CQueueMaker test=new CQueueMaker();
	test.push('a');
	test.push('b');
	test.push('c');
	//test.pop();test.pop();
	test.push('d');
	test.PrintCQueue();
	
}
*/
	}
