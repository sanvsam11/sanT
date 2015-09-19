/**
 * Created by sant on 19/9/15.
 */
public class StackMaker {
    qnode top;

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
}
