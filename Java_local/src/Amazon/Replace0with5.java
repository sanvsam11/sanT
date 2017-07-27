package Amazon;

/**
 * Created by SanthoshVarathan on 05/07/17.
 */
public class Replace0with5 {
    public void printMethod(int n){
        int output=0,i=1;
        while(n>0){
            int d = ((n % 10)==0?5:n%10);
            output=output+d*i;
            n/=10;i*=10;
        }
        System.out.println(output);
    }
//    public static void main(String ar[]){
//        int n = 1504040;
//        new Replace0with5().printMethod(n);
//    }
}
