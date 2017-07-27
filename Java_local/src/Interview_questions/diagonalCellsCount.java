package Interview_questions;

/**
 * Created by SanthoshVarathan on 25/12/16.
 */
public class diagonalCellsCount {
    int countBlackCells(int n, int m) {int result = 0;
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++){
                //if(i==0&&j==0||i==(n-1)&&j==(n-1)) result++;
                if(n==m){
                    if(i==j||Math.abs(i-j)==1) result++;
                }
                else if(m>n){int d = m-n;
                    while(d>=0){
                        if((j-i)==d) result++;
                        d--;
                    }
                }
            }
        return result;
    }
    public static void main(String ar[]){
        System.out.println("Result: "+new diagonalCellsCount().countBlackCells(2,5));
    }
}
