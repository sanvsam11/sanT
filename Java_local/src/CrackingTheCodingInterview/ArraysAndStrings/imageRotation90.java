package CrackingTheCodingInterview.ArraysAndStrings;
import java.util.Arrays;
import java.util.Random;
/**
 * Created by SanthoshVarathan on 06/07/17.
 */
class image{
    int data;
    public image(){
        data = new Random().nextInt(1000);
    }
    public String toString(){
        return String.valueOf(data);
    }
}
public class imageRotation90 {
    image matrix[][];
    int n;
    public imageRotation90(int N){
        this.n = N;
        this.matrix = new image[N][N];
        for(int i=0;i<N;i++)
            for(int j=0;j<N;j++)
                this.matrix[i][j] = new image();
    }
    public void transposeMatrix(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j&&j<i){
                    image t = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = t;
                }
            }
        }
    }
    public void mirrorMatrix(){
        for(int i=0;i<n;i++)
            for(int j=0;j<=n/2;j++)
            {
                if(n%2!=0&&j==(n/2)) continue;
                image x = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = x;
            }
    }
    public void rotateMatrixMethod(){
        transposeMatrix();
        mirrorMatrix();
    }
    public void printMatrix(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
                System.out.print(matrix[i][j]+" ");
            System.out.println();
        }
    }
    public static void main(String ar[]){
        imageRotation90 object = new imageRotation90(4);
        object.printMatrix();
        System.out.println();
        object.rotateMatrixMethod();
        object.printMatrix();
    }
}
