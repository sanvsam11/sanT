
import java.util.*;
public class Linked_List_Fold
{
	node r,f;
	LinkedListMaker list=new LinkedListMaker();
	public void ListGetter(LinkedListMaker list){this.list=list;r=f=list.head;}
	public void Folder(node r){
		if(r.next!=null)Folder(r.next);

		if(r!=f){
			node t=f.next;f.next=r;r.next=t;
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
		ob.Folder(ob.list.head);
		ob.list.PrintList();
	}
}
