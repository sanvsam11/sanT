import java.util.*;
public class zigzagString
{
	public static void main(String ar[]){
		Scanner in = new Scanner(System.in);
		String s=in.next();int l=s.length(),k=0;
		char[] out=new char[l];
		for(int i=0;i<l;i++) if(i%2==0) {out[k]=s.charAt(i);k++;}
		for(int i=1;i<l;i++) if(i%2!=0) {out[k]=s.charAt(i);k++;}

		System.out.println(out);
	}
}
