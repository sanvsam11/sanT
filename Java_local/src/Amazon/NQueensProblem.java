package Amazon;

import java.util.Scanner;

/**
 * Created by SanthoshVarathan on 10/07/17.
 */
public class NQueensProblem {
    boolean board[][];
    int n;
    NQueensProblem(int n){
        this.n = n;
        board = new boolean[n][n];
    }
    public void resetBoard(){
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                board[i][j] = false;
    }
    public boolean checkRowMethod(int r,int c){
        for(int x=0;x<n;x++)
            if(x!=c&&board[r][x])
                return false;
        return true;
    }
    public boolean checkColumnMethod(int r,int c){
        for(int x=0;x<n;x++)
            if(x!=r&&board[x][c])
                return false;
        return true;
    }
    public boolean checkLeftDiagonalMethod(int r,int c){
        int row = 0, col = 0;
        if(r>c)
            row = r - c;
        else
            col = c - r;
        while(row<n&&col<n)
            if(board[row++][col++])
                if(r!=(row-1)&&c!=(col-1))
                    return false;
        return true;
    }
    public boolean checkLeft1DiagonalMethod(int r,int c){
        int row = r,col = c;
        while(--row>=0&&--col>=0)
            if(board[row][col])
                return false;
        row = r;
        col = c;
        while(++row<n&&++col<n)
            if(board[row][col])
                return false;
        return true;
    }
    public boolean checkRightDiagonalMethod(int r,int c){
//        int row = r,col = c;
//        while(--row>=0&&++col<n)
//            if(board[row][col])
//                return false;
//        row = r;
//        col = c;
//        while(++row<n&&--col>=0)
//            if(board[row][col])
//                return false;
//        return true;
        int row = 0, col = n-1;
        if((r+c)>n)
            col = Math.min((r+c),n-1);
        else
            row = (r+c)%(n-1);
        while(row<n&&col>=0)
            if(board[row++][col--])
                if((row-1)!=r&&(col+1)!=c)
                    return false;
        return true;
    }
    public boolean checkBoardAtMethod(int r,int c){
        return checkRowMethod(r,c)&&checkColumnMethod(r,c)&&checkLeftDiagonalMethod(r,c)&&checkRightDiagonalMethod(r,c);
    }
    public boolean fillboardMethod(boolean board[][],int r){
        if(r==n) return true;
        for(int c=0;c<n;c++){
            board[r][c] = true;
            if(checkBoardAtMethod(r,c)) {
                if (fillboardMethod(board, r + 1))
                    return true;
            }
            board[r][c] = false;
        }
        return false;
    }
    public void printResult(){
        System.out.println();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                System.out.print(board[i][j]?"1":"0");
            System.out.println();
        }
    }
    public static void main(String ar[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        NQueensProblem ob = new NQueensProblem(n);
//        for(int i=0;i<n;i++){
//            ob.resetBoard();
//            ob.board[0][i] = true;
//            if(ob.fillboardMethod(ob.board,i))
//                ob.printResult();
//            ob.board[0][i] = false;
//        }
        if(ob.fillboardMethod(ob.board,0))
            ob.printResult();
    }
}
