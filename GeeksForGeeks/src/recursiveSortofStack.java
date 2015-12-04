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
		if(!thoor){
		 if(!s.isEmpty()){x=s.pop(); recursiveSort(s,false,x);}
		 else recursiveSort(s,true,x);
//>>>>>>> c3b49cf8582021865df60648a0a7d88647179781
          }
//>>>>>>> ce8154347d073c83a3b7a04030a5345d3a5a4235
		else{
			if(s.isEmpty()||x>s.top())s.push(x);
			else {
				int y=s.pop();recursiveSort(s,true,x);s.push(y);
			}
		}
	}
		
		

	public static void main(String ar[]){
	
		recursiveSortofStack ob=new recursiveSortofStack();
		intStack s=new intStack(3);
		s.push(2);
		s.push(1);
		ob.recursiveSort(s,false,0);
		s.printStack();
	}
}
