package Arrays;

/**
 * Created by SanthoshVarathan on 21/09/16.
 * Active and Inactive cells after k Days
 * Given a binary array of size n where n > 3. A true (or 1) value in the array means active and false (or 0) means inactive.
 * Given a number k, the task is to find count of active and inactive cells after k days.
 * After every day, status of i’th cell becomes inactive if its left and right cells have same value, i.e., either both are 0 or both are 1.
 Since there are no cells before leftmost and after rightmost cells,
 the value cells before leftmost and after rightmost cells is always considered as 0 (or inactive).


 Input: cells[] = {1, 0, 1, 1}, k = 2
 Output : Active Cells = 1, Inactive Cells = 3
 Explanation: After 1 day, cells[] = {1, 0, 1, 0}
 After 2 days, cells[] = {1, 0, 0, 0}

 Input : cells[] = {0, 1, 0, 1, 0, 1, 0, 1},  k = 3
 Output: Active Cells = 2 , Inactive Cells = 6
 Explanation :
 After 1 day, cells[] = {1, 0, 0, 0, 0, 0, 0, 0}
 After 2 days, cells[] = {0, 1, 0, 0, 0, 0, 0, 0}
 After 3 days, cells[] =  {1, 0, 1, 0, 0, 0, 0, 0}

 Input : cells[] = {0, 1, 1, 1, 0, 1, 1, 0},  k = 4
 Output: Active Cells = 3 , Inactive Cells = 5
 */
public class cells {
    int[] stateChange(int cells[],int n){
        int[] next=new int[n];
        if(cells[1]==1)next[0]=1;else next[0]=0;
        if(cells[n-2]==1)next[n-1]=1;else next[n-1]=0;
        for(int i=1;i<n-1;i++)
            if(cells[i-1]==cells[i+1])next[i]=0;
            else next[i]=1;
        return next;
    }
    void printArray(int[]a,int n){
        for(int i=0;i<n;i++)System.out.print(a[i]+" ");
    }
    public int[] stateAfterKDays(int[] a,int n,int k){
        for(int i=0;i<k;i++) {a=stateChange(a,n);System.out.println();printArray(a,n);}
        return a;
    }
    public int getActiveCount(int[] a,int n){
        int count=0;
        for(int i=0;i<n;i++)if(a[i]==1)count++;
        return count;
    }
    public static void main(String ar[]){
        int cells[]={0, 1, 1, 1, 0, 1, 1, 0},n=8;
        int k=4;
        cells c = new cells();
        cells=c.stateAfterKDays(cells,n,k);
        System.out.println(c.getActiveCount(cells,n));
    }
}
