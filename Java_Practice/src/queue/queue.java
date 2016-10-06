package queue;

public class queue<t>
{
	node front,rear,c;
	public queue(t element){
		front=new node(element);
		rear=front;
	}
	public void enqueue(t element){
		if(front==null)front=rear=new node(element);
		else{
			node newnode = new node(element);
			rear.next=newnode;
			rear=newnode;
		}
	}
	public t dequeue(){
		if(front==null) return null;
		else {
			t temp=(t)front.element;
			front=front.next;
			if(front==null)rear=null;
			return temp;
		}
	}
	public void printQueue(){c=front;System.out.print(c.element);c=c.next;
		while(c!=null) {System.out.print("->"+c.element);c=c.next;}
	}
	public boolean isEmpty(){
		return (front==null)?true:false;
	}
	/*
	public static void main(String ar[]){
		queue<Integer> q = new queue<Integer>(1);
		q.enqueue(2);
		q.enqueue(3);
		q.dequeue();
		q.enqueue(4);
		q.printQueue();
	}
	*/
}
