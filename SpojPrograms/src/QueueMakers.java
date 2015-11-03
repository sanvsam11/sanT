/**
 * Created by sant on 19/9/15.
 */
public class QueueMakers {
    qnode head,tail;

    public QueueMakers(tnode element){
        qnode newnode= new qnode(element);
        head=newnode;tail=newnode;
    }
    public QueueMakers(){head=null;tail=null;}

    public void push(tnode element){
        if(head==null) {  qnode newnode=new qnode(element);head=newnode;tail=newnode;}
        else {
            qnode newnode=new qnode(element);head.next=newnode;head=newnode;
        }
    }

    public tnode pop(){
        tnode temp;
        if(tail==null)return null;
        else if(tail!=head){temp=tail.element;tail=tail.next;return temp;}
        else {temp=tail.element;tail=head=null;return temp;}
    }
    public void EmptyQueue(){head=tail=null;}
    public void PrintQueue(){
        qnode c=tail;
        while (true){
            System.out.println(c.element.element);if(c==head)break;

            c=c.next;}
    }
/*
    public static void main(String ar[]){

        QueueMaker testq=new QueueMaker();
        tnode a=new tnode('a');
        tnode b=new tnode('b');
        tnode c=new tnode('c');

        testq.push(a);
        testq.push(b);
        testq.push(c);
        testq.PrintQueue();

    }
	*/
}
