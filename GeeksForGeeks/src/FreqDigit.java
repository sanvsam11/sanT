
import java.util.*;public class FreqDigit//find the most reccuring digit in the intege.no string, array or hash
{
	public static void main(String ar[]){
		Scanner in = new Scanner(System.in);
		int input = in.nextInt();
		int N=0,c=0;
		while(input>0){
			N = input % 10;input=input/10;
			
			while(input%10==N)c++;
		}
	}
}
