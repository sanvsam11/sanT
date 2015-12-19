import java.util.*;
public class bubble
{
	int i=0;
	public int[] bubbleSortFunction(int a[],int n){
		for(int i=0;i<n;i++)
			for(int j=i+1;j<n;j++)
			{int x;
				if(a[i]>a[j]){
					x=a[i];a[i]=a[j];a[j]=x;
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
