package Dynamic_Programming;

/**
 * Created by SanthoshVarathan on 10/06/17.
 * java code to find the length of the  longest increasing subsequence
 */
public class Longest_Increasing_Subsequence {
    public int lis(int a[]) {
        int m[] = new int[a.length],r=1;
        for (int i = 0; i < m.length; i++) m[i] = 1;
        for (int i = 1; i < a.length; i++)
            for (int j = 0; j < i; j++)
                if (a[j] < a[i]) m[i] = Math.max(m[i], m[j]+1);
        for(int i=0;i<m.length;i++)
            if(r<m[i])r=m[i];
        return r;
    }
}
