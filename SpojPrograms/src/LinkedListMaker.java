public class LinkedListMaker
{
	node head,c;
	public LinkedListMaker(){}
	public LinkedListMaker(char element){
		head=new node(element);
	}
	public void InsertNode(char element){c=head;
		if(c==null)head=new node(element);
		else {while(c.next!=null)c=c.next;
		node newnode=new node(element);c.next=newnode;}
	}
	public void DeleteNode(char element){c=head;
		while(c.next!=null&&c.next.element!=element)c=c.next;
		node temp=c.next;
		c.next=temp.next;
	}
	public void PrintList(){c=head;
		while(c!=null){System.out.println(c.element);c=c.next;}
	}
}
