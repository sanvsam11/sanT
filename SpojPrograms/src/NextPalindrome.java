import java.util.Scanner;
public class NextPalindrome
{
	static int c=0;
	static public int NumberOfDigits(int i){
		if(i/10==0)
		return 1;
		else
		return 1+NumberOfDigits(i/10);
	}
	static public int IntegerRev(int x){ int j=0,l=NumberOfDigits(x);
		while(l>0){
			j=j+(int)((x%10)*Math.pow(10.0,l-1));l--;
		x=x/10;}
		return j;
	}
	static public boolean CheckPalindrome(int n){
		if(IntegerRev(n)==n)
			return true;
		else
			return false;
	}
	/*
	public static void main(String ar[]){
		NextPalindrome ob=new NextPalindrome();
		//System.out.println( ob.CheckPalindrome(13231));
		//System.out.println(Math.pow(2,3));
		int[] ip={0,0,0};
		Scanner input=new Scanner(System.in);
		System.out.println("Enter 3 numbers");
		for(int i=0;i<3;i++){
			ip[i]=input.nextInt();
		}
	
		for(int i=0;i<ip.length;i++){
			ip[i]++;
			while(!ob.CheckPalindrome(ip[i])){
				ip[i]++;
			}
			System.out.println(ip[i]);
		}
	}
	*/
}
