public class recursiveSortofStack
//sort a stack using recursion
{
//<<<<<<< HEAD
//	int t;
//	public void recursiveSort(intStack s){
//		int x=s.pop();
//		if(!s.isEmpty()) recursiveSort(s);

//=======
	
	public void recursiveSort(intStack s,boolean thoor){int x=s.top();
		if(!thoor){if(!s.isEmpty()){x=s.pop();
		 recursiveSort(s,false);}
          }
//>>>>>>> ce8154347d073c83a3b7a04030a5345d3a5a4235
		if(s.isEmpty()) s.push(x);
		else {
			if(s.top()>x)recursiveSort(s,true);
			else s.push(x);
		}
		
		
	}
	public static void main(String ar[]){
	
		recursiveSortofStack ob=new recursiveSortofStack();
		intStack s=new intStack(3);
		s.push(2);
		s.push(1);
		ob.recursiveSort(s,false);
		s.printStack();
	}
}
