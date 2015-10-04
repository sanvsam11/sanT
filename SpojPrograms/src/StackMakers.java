/**
 * Created by sant on 19/9/15.
 */
public class StackMakers {
    qnodes top,c;int Count=0;

    public StackMakers(){
        top=null;
    }

    public void push(tnodes element){
        if(element!=null)
        if(top==null){
            qnodes newnode=new qnodes(element);top=newnode;}
        else{
            qnodes newnode = new qnodes(element);newnode.next=top;top=newnode;}
    }

    public tnodes pop(){ tnodes tmp;
        if(top==null)return null;
        else {tmp=top.element;top=top.next;return tmp;}
    }
    public void PrintStack(){c=top;
        while (c!=null){System.out.println(c.element.element);c=c.next;}
    }
    public void EmptyStack(){
        top=null;
    }
    public boolean EmptyStackCheck(){if(top==null)return true;else return false;}

    public int CountStack(){c=top;Count=0;
        while(c!=null){Count++;c=c.next;}return Count;
    }
    public void CopyStack(StackMakers s2){
        StackMakers temp=new StackMakers();
    while (!this.EmptyStackCheck()) temp.push(this.pop());
    while (!temp.EmptyStackCheck()) s2.push(temp.pop());
    }
    /*
	public static void main(String ar[]){

        tnodes a=new tnodes('a');
        tnodes b=new tnodes('b');
        tnodes c=new tnodes('c');
        tnodes d=new tnodes('d');

        StackMaker teststack=new StackMaker();
        StackMaker teststack2=new StackMaker();
        teststack.push(a);
        teststack.push(b);
        teststack.push(c);
        teststack.push(d);
        teststack2.push(a);
        teststack2.push(b);
        teststack2.push(c);
        teststack2.push(d);
        //teststack.PrintStack();
        //System.out.println("pop:"+teststack.pop().element);
        //teststack.PrintStack();
        teststack.pop();
       // System.out.println(teststack.CountStack());
        teststack.PrintStack();teststack2.PrintStack();

    }
*/
}
