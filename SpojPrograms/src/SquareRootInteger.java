public class SquareRootInteger
{
	int a,i=1;
	public SquareRootInteger(int a){this.a=a;}
	public SquareRootInteger(){a=0;}
	public void FindSquareRoot(){
		while((i*i)<a)i++;if(i*i!=a)i--;
		}
	public void PrintSquareRoot(){System.out.println(i);}

	public static void main(String ar[]){
		SquareRootInteger ob=new SquareRootInteger();
		ob.a=626;
		ob.FindSquareRoot();
		ob.PrintSquareRoot();
	}
}
