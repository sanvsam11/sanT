/**
 * Created by sant on 19/9/15.
 */
public class QueueMakers {
    qnodes head,tail;

    public QueueMakers(tnodes element){
        qnodes newnode= new qnodes(element);
        head=newnode;tail=newnode;
    }
    public QueueMakers(){head=null;tail=null;}

    public void push(tnodes element){
        if(head==null) {  qnodes newnode=new qnodes(element);head=newnode;tail=newnode;}
        else {
            qnodes newnode=new qnodes(element);head.next=newnode;head=newnode;
        }
    }

    public tnodes pop(){
        tnodes temp;
        if(tail==null)return null;
        else if(tail!=head){temp=tail.element;tail=tail.next;return temp;}
        else {temp=tail.element;tail=head=null;return temp;}
    }
    public void EmptyQueue(){head=tail=null;}
    public void PrintQueue(){
        qnodes c=tail;
        while (true){
            System.out.println(c.element.element);if(c==head)break;

            c=c.next;}
    }
/*
    public static void main(String ar[]){

        QueueMakers testq=new QueueMakers();
        tnodes a=new tnodes('a');
        tnodes b=new tnodes('b');
        tnodes c=new tnodes('c');

        testq.push(a);
        testq.push(b);
        testq.push(c);
        testq.PrintQueue();

    }
	*/
}
