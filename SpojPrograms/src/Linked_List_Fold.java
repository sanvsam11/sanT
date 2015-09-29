
import java.util.*;public class Linked_List_Fold
{
	node r,f;
	LinkedListMaker list=new LinkedListMaker();
	public void ListGetter(LinkedListMaker list){this.list=list;}
	public void Folder(node n){r=n;
		if(r.next!=null)Folder(r.next);
		
	}
}
