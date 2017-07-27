package Dynamic_Programming;

/**
 * Created by SanthoshVarathan on 10/06/17.
 */
public class dp_testClass {
    public static void main(String ar[]) {
        Longest_Increasing_Subsequence l = new Longest_Increasing_Subsequence();
        int a[] = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        System.out.println("Result:" +l.lis(a));
    }
}
