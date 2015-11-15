public class recursiveSortofStack
//sort a stack using recursion
{
	int x,t;
	public void recursiveSort(intStack s){
		x=s.pop();
		if(!s.isEmpty()) recursiveSort(s);

		if(s.isEmpty()) s.push(x);
		else {
			if(s.top()>x)recursiveSort(s);
			else s.push(x);
		}
	}
	public static void main(String ar[]){
	
		recursiveSortofStack ob=new recursiveSortofStack();
		intStack s=new intStack(3);
		s.push(2);
		s.push(1);
		ob.recursiveSort(s);
		s.printStack();
	}
}
