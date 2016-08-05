/**
 * Created by SanthoshVarathan on 29/07/16.
 */
import java.util.Scanner;
public class matrix90 {
    int a[][],x,y;
    public void getxy(int x,int y){
        a=new int[x][y];this.x=x;this.y=y;
    }
    public void getmatrix(){Scanner in = new Scanner(System.in);
        for(int i=0;i<x;i++)
        for(int j=0;j<y;j++)a[i][j]=in.nextInt();
    }
    public void transpose(){
        for(int i=0;i<x;i++)
            for(int j=0;j<y;j++) if(i<j){
                int t;
                //a[i][j]=a[i][j]^a[j][i];
                t = a[i][j];
                //a[j][i]=a[i][j]^a[j][i];
                a[i][j] = a[j][i];
                //a[i][j]=a[i][j]^a[j][i];
                a[j][i] = t;
            }
    }
    public void mirror(){int m=(y%2==0)?y/2:(y/2)+1;
        for(int i=0;i<x;i++)
            for(int j=0;j<m;j++)
            {int t;
                t=a[i][y-j-1];
                a[i][y-j-1]=a[i][j];
                a[i][j]=t;
            }
    }
    public void rotate90(){
        transpose();mirror();
    }
    public void printMatrix(){
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++)System.out.print(a[i][j]+" ");
        System.out.println(" ");}
    }
    public static void main(String ar[]){
        matrix90 mo = new matrix90();
        mo.getxy(3,3);
        mo.getmatrix();
        //mo.rotate90();
        mo.transpose();
        mo.printMatrix();
        mo.mirror();
        mo.printMatrix();
    }
}
