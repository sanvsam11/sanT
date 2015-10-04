
import java.util.*;
public class Linked_List_Fold
{
	node r,f;static boolean end=false;
	LinkedListMaker list=new LinkedListMaker();
	public void ListGetter(LinkedListMaker list){this.list=list;r=f=list.head;end=false;}
	public void Folder(node rt){
		if(rt.next!=null)Folder(rt.next);

		if(f.next==rt){end=true;rt.next=null;}
		if(end==false){
			node t=f.next;f.next=rt;rt.next=t;f=rt.next;
		}
	}
	public static void main(String ar[]){
		Linked_List_Fold ob=new Linked_List_Fold();
		ob.list.InsertNode('a');
		ob.list.InsertNode('b');
		ob.list.InsertNode('c');
		ob.list.InsertNode('d');
		ob.list.InsertNode('e');
		ob.list.InsertNode('f');
		ob.list.InsertNode('g');
		ob.list.InsertNode('h');
		ob.ListGetter(ob.list);
		ob.Folder(ob.r);
		ob.list.PrintList();
	}
}
