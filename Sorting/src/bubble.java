import java.util.*;
public class bubble
{
	int i=0;
	public int[] bubbleSortFunction(int a[],int n){
		for(int i=0;i<2;i++)
			for(int j=0;j<n-1;j++)
			{int x;
				if(a[j]>a[j+1]){
					x=a[j];a[j]=a[j+1];a[j+1]=x;
				}
			}
	return a;}
	public void printSequence(int a[],int n){
		for(int i=0;i<n;i++)System.out.println(a[i]);
	}
	public static void main(String ar[]){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(),a[]=new int[n];
		for(int i=0;i<n;i++)a[i]=in.nextInt();
		bubble ob = new bubble();
		ob.printSequence(ob.bubbleSortFunction(a,n),n);
	}
}
