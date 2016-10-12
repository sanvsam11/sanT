package Arrays;

/**
 * Created by SanthoshVarathan on 12/10/16.
 */
public class Sudoku {
    public int block(int i,int j){
        if(i<3&&j<3) return 0;
        else if(i<3&&j<6) return 1;
        else if(i<3&&j<9) return 2;
        else if(i<6&&j<3) return 3;
        else if(i<6&&j<6) return 4;
        else if(i<6&&j<9) return 5;
        else if(i<9&&j<3) return 6;
        else if(i<9&&j<6) return 7;
        else  return 8;
    }
    public boolean check(int a[][]){boolean c[][]=new boolean[9][9],r[][]=new boolean[9][9],b[][]=new boolean[9][9];
        for(int i=0;i<9;i++)
            for(int j=0;j<9;j++)
            {
                c[i][j]=r[i][j]=b[i][j]=false;
            }
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){int v = a[i][j]-1,block=block(i,j);
                if(v==-1) continue;
                    if(r[i][v]||c[j][v]||b[block][v]) return false;
                else {
                        r[i][v]=true;c[j][v]=true;b[block][v]=true;
                    }
            }
        }
        return true;
    }
    public static void main(String ar[]){
        int a[][] = {{8,0,0,4,0,6,0,0,7},{0,0,0,0,0,0,4,0,0},{0,1,0,0,0,0,6,5,0},{5,0,9,0,3,0,7,8,0},{0,0,0,0,7,0,0,0,0},{0,4,8,0,2,0,1,0,3},{0,5,2,0,0,0,0,9,0},{0,0,1,0,0,0,0,0,0},{3,0,0,9,0,2,0,0,5}};
        Sudoku s = new Sudoku();
        for(int i=0;i<9;i++) {
            for (int j = 0; j < 9; j++) System.out.print(a[i][j] + " ");
           System.out.println();
        }
        System.out.println(s.check(a));
    }
}
