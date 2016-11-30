import java.util.Scanner;

public class quicksort
{
	public int[] quickSortFunction(int a[],int n){
		quickSorter(a,0,n-1);//last element as pivot. Can add other types later..
	return a;}

	public int[] quickSorter(int a[],int l,int r){
		int i=l,p=r,j=p-1;

		while(i<=j){
			if(i<p&&a[i]>a[p]) {int x = a[i];a[i]=a[p];a[p]=x; p=i;} i++;
			if(j>p&&a[j]<a[p]) {int x = a[j];a[j]=a[p];a[p]=x; p=j;} j--;
		}p=j;
		if(!(p-l==1||r-p==1)){
		a = quickSorter(a,l,p);
		a = quickSorter(a,p+1,r);}
	return a;}
	/*
	public static void main (String ar[]){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number of items to be sorted: ");
		int n= in.nextInt(),a[]=new int[n];
		for(int i=0;i<n;i++) a[i]=in.nextInt();
		quicksort ob = new quicksort();
		System.out.println(ob.quickSortFunction(a,n));
	}
	*/
}
