public class recursiveSortofStack
//sort a stack using recursion
{
//<<<<<<< HEAD
//	int t;
//	public void recursiveSort(intStack s){
//		int x=s.pop();
//		if(!s.isEmpty()) recursiveSort(s);

//=======
	
//<<<<<<< HEAD

//=======
	public void recursiveSort(intStack s,boolean thoor,int x){
		if(!thoor){if(!s.isEmpty()){x=s.pop();if(!s.isEmpty()) recursiveSort(s,false,x);}}

			if(s.isEmpty()||x>s.top())s.push(x);
			else {int y=s.pop();recursiveSort(s,true,x);s.push(y);}
	}
		
		

	public static void main(String ar[]){
	
		recursiveSortofStack ob=new recursiveSortofStack();
		intStack s=new intStack(3);
		s.push(2);
		s.push(1);
		s.push(4);
		s.push(0);
		s.push(5);
		ob.recursiveSort(s,false,0);
		s.printStack();
	}
}
