public class SquareRootInteger
{
	int a,i=1;
	public SquareRootInteger(int a){this.a=a;}
	public SquareRootInteger(){a=0;}
	public void FindSquareRoot(){while((i*i)<a)i++;if(i*i!=a)i--;}
	public void FindSquareRoot2(){i=a/2;//does not work
		while(i*i>a)i=i/2;
	}
	public void PrintSquareRoot(){System.out.println(i);}

	public static void main(String ar[]){
		SquareRootInteger ob=new SquareRootInteger();
		ob.a=625;
		ob.FindSquareRoot2();
		ob.PrintSquareRoot();
	}
}
