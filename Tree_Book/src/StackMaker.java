/**
 * Created by sant on 19/9/15.
 */
public class StackMaker {
    qnode top,c;

    public StackMaker(){
        top=null;
    }

    public void push(tnode element){
        if(top==null){qnode newnode=new qnode(element);top=newnode;}
        else{qnode newnode = new qnode(element);newnode.next=top;top=newnode;}
    }

    public tnode pop(){ tnode tmp;
        if(top==null)return null;
        else {tmp=top.element;top=top.next;return tmp;}
    }
    public void PrintStack(){c=top;
        while (c!=null){System.out.println(c.element.element);c=c.next;}
    }
    public static void main(String ar[]){
      /*
        tnode a=new tnode('a');
        tnode b=new tnode('b');
        tnode c=new tnode('c');
        tnode d=new tnode('d');

        StackMaker teststack=new StackMaker();
        teststack.push(a);
        teststack.push(b);
        teststack.push(c);
        teststack.push(d);
        teststack.PrintStack();
        System.out.println("pop:"+teststack.pop().element);
        teststack.PrintStack();
        */
    }
}
