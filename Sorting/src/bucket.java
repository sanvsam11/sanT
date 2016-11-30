
import java.util.*;public class bucket
{
	public boolean a[];
	public boolean[] sortfunction(int N[],int n,int m){boolean a[]=new boolean[m];
		for(int i=0;i<n;i++)
		a[N[i]-1]=true;
		return a;
	}
	public void printSorted(boolean a[],int m){
	    for(int i=0;i<m;i++)if(a[i])System.out.println(i+1);
	}/*
	public static void main(String ar[]){
		bucket ob = new bucket();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(),N[]=new int[n],m=0;
		for(int i=0;i<n;i++) {N[i]=in.nextInt();if(N[i]>m)m=N[i];}
		
			ob.printSorted(ob.sortfunction(N,n,m),m);
	}
	*/
}
