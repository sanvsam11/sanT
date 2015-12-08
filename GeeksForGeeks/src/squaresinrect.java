
import java.util.*;
public class squaresinrect
{
	public squaresinrect(){}
	public int squarecount(int l, int b){
		int squares=0,i=2,x=0;
		if(l==b) squares = squares + 1;
		squares = squares + l*b;//1x1
		while(true){x=b/i;
			if(i<=b) squares = squares + x*x;else break;
		i++;}
		return squares;
	}
	
	public static void main(String ar[]){
		int l=4,b=3;
		//Scanner in = new Scanner(System.in);
		//l=in.nextInt();b=in.nextInt();
		squaresinrect ob = new squaresinrect();
		System.out.println(ob.squarecount(l,b));
	}
}
