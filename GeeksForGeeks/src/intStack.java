
import org.w3c.dom.*;public class intStack
{
	sNode h,c,n;
	public intStack(int element){h=new sNode(element);h.next=null;}
	
	public boolean isEmpty(){
		if(h==null) return true; else return false;
	}
	public void push(int x){
		if(h==null){h=new sNode(x);h.next=null;}
		else {n=new sNode(x);n.next=h;h=n;}
	}
	
	public int pop(){int x;
		if(h!=null){x=h.element;
		h=h.next;}
		else x=-100;
	return x;}
	
	public int top(){int x;
		if(h==null)x=-100;
		else x=h.element;
	return x;}
	
	public void printStack(){c=h;
		while(c!=null){
			System.out.println(c.element);
		c=c.next;}
	}
}
