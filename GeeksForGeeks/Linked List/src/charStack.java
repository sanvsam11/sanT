public class charStack
	{
		sNode h,c,n;
		public charStack(char element){h=new sNode(element);h.next=null;}

		public boolean isEmpty(){
				if(h==null) return true; else return false;
			}
		public void push(char x){
				if(h==null){h=new sNode(x);h.next=null;}
				else {n=new sNode(x);n.next=h;h=n;}
			}

		public int pop(){char x;
				if(h!=null){x=h.element;
						h=h.next;}
				else x=' ';
				return x;}

		public int top(){char x;
				if(h==null)x=' ';
				else x=h.element;
				return x;}

		public void printStack(){c=h;
				while(c!=null){
						System.out.println(c.element);
						c=c.next;}
			}
	}
