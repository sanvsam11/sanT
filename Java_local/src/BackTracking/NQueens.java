package BackTracking;

/**
 * Created by SanthoshVarathan on 01/04/17.
 */
public class NQueens {
    int N;
    boolean board[][];
    public static void main(String ar[]){
        NQueens nq = new NQueens(3);
        nq.checkQueens(nq.board);
    }
    NQueens(int N){
        board = new boolean[N][N];
        for(int i=0;i<N;i++)
            for(int j=0;j<N;j++)
                board[i][j]=false;
    }
    boolean checkQueens(boolean board[][]){
       return false;
    }
}
