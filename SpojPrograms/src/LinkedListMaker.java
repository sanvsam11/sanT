public class LinkedListMaker
{
	nodes head,c;
	public LinkedListMaker(){}
	public LinkedListMaker(char element){
		head=new nodes(element);
	}
	public void InsertNode(char element){c=head;
		if(c==null)head=new nodes(element);
		else {while(c.next!=null)c=c.next;
		nodes newnode=new nodes(element);c.next=newnode;}
	}
	public void DeleteNode(char element){c=head;
		while(c.next!=null&&c.next.element!=element)c=c.next;
		nodes temp=c.next;
		c.next=temp.next;
	}
	public void PrintList(){c=head;
		while(c!=null){System.out.println(c.element);c=c.next;}
	}
}
