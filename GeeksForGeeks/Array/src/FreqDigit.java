
import java.util.*;
public class FreqDigit
//find the most reccuring digit in the intege.no string, array or hash
{
	public static void main(String ar[]){
		Scanner in = new Scanner(System.in);
		int input = in.nextInt();
		int N=0,c=0;
		while(input>0){
			int d = input % 10,dc=0;input=input/10;	
			while(input%10==d){dc++;input=input/10;}
			if(dc==c)N=N>d?N:d;else if(dc>c){N=d;c=dc;}
		}
		System.out.println(N);
	}
}
