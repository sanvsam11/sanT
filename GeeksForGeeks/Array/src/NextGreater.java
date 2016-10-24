/**
 * Created by SanthoshVarathan on 30/09/16.
 */

public class NextGreater {

    public void sortFunction(int a[],int n){
        for(int i=0;i<n;i++)
            for(int j=i+1;j<n;j++){
                if(a[i]>a[j]){
                    int x=a[i];
                    a[i]=a[j];
                    a[j]=x;
                }
            }
    }
    public void nextGreaterElement(int a[],int n){
         int as[]=new int[n];
        for(int i=0;i<n;i++)as[i]=a[i];
        sortFunction(as,n);
        System.out.print("{");
        for(int i=0;i<n;i++){int nextGreat=0;
            for(int j=0;j<n-1;j++){if(a[i]==as[j]) nextGreat=as[j+1];}
        System.out.print(a[i]+" > "+nextGreat+",");
        }
        System.out.print("}");
    }
    public static void main(String ar[]){
    NextGreater n = new NextGreater();
        int a[]={2,3,7,-1,8,5,11},l=7;
        n.nextGreaterElement(a,l);
    }
}
