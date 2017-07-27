package Amazon;

/**
 * Created by SanthoshVarathan on 23/07/17.
 */
public class SetTwoThreeDivThree {
    void print2or3SetsDivThree(int a[]){
        for(int i=0;i<a.length;i++)
            for(int j=i+1;j<a.length;j++)
                for(int k=j+1;k<a.length;k++){
                    if((a[i]+a[j])%3==0)
                        System.out.println("{"+a[i]+","+a[j]+"}");
                    if((a[i]+a[j]+a[k])%3==0)
                        System.out.println("{"+a[i]+","+a[j]+","+a[k]+"}");
                }
    }
    public static void main(String ar[]){
        int a[] = {3, 6, 7, 2, 9};
        new SetTwoThreeDivThree().print2or3SetsDivThree(a);
    }
}
