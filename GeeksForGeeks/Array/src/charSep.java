/**
 * Created by SanthoshVarathan on 09/10/16.
 */
public class charSep {
    public char[] rearrange(char[]a,int n){ char[] result=new char[n];


        return result;
    }
    public void printSequence(char[] a,int n){
        for(int i=0;i<n;i++)System.out.print(a[i]+ " ");
    }
    public static void main(String ar[]){
        char a[]={'a','a','a','b','b','b','c','c','c'};int n=9;
        charSep c = new charSep();
        a=c.rearrange(a,n);
        c.printSequence(a,n);
    }
}
