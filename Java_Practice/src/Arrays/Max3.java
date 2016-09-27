package Arrays;

/**
 * Created by SanthoshVarathan on 27/09/16.
 */
public class Max3 {
    public int getThirdLargest(int a[],int n){int m1=a[0],m2=Integer.MIN_VALUE,m3=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(a[i]==m1||a[i]==m2||a[i]==m3);
            else if(m1<a[i]) {m3=m2;m2=m1;m1=a[i];}
            else if(m2<a[i]){m3=m2;m2=a[i];}
            else if(m3<a[i])m3=a[i];
        }
        return m3;
    }
    public static void main(String ar[]){
       int a[]={4,6,5,7,7,2,4,4},n=7;
        Max3 mf = new Max3();
        System.out.println("Solution:"+mf.getThirdLargest(a,n));
    }
}
