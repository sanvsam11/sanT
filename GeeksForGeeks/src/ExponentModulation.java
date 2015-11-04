
import java.util.*;public class ExponentModulation
{
	public static void main(String ar[]){
		//System.out.println("let the games begin");
	
		Scanner in = new Scanner(System.in);
		int b = in.nextInt(),p=in.nextInt(),m=in.nextInt(),a=1;
		for(int i=0;i<p;i++)a=a*b;
		//System.out.println(b+" "+p+" "+m+" "+a);
		System.out.println(a/m);}
}
