package Amazon;

/**
 * Created by SanthoshVarathan on 21/07/17.
 */
public class MissingNumberInArray {
    static void printMissingNumber(int a[]){
        int n = a.length;
        int sum = (n*(n-1))/2;
        for(int i:a)
            sum=sum - i;
        System.out.println("sum method:"+sum);
    }
    static void printMissingNumberXOR(int a[]){
        int n = a.length;
        int xor = 1,xorArray = a[0];
        for(int i=2;i<n;i++)
            xor = xor ^ i;
        for(int i=1;i<n;i++)
            xorArray = xorArray ^ a[i];
        System.out.println("XOR method:"+xorArray);
    }
    public static void main(String ar[]){
        int a[] = {1,2,3,4,0,6,7,8,9};
        KSumInArray helper = new KSumInArray();
        //a = helper.generateArray(50);
        printMissingNumber(a);
        printMissingNumberXOR(a);
    }
}
