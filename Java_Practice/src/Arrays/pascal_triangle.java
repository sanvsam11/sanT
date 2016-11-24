package Arrays;

/**
 * Created by SanthoshVarathan on 27/08/16.
 */
public class pascal_triangle {
    int[][] pt;int n;
    public void createTriangle(int n){this.n=n;
        pt = new int[n][];
        for(int i=0;i<n;i++) pt[i]=new int[i+1];

        for(int i=0;i<n;i++){
            pt[i][0]=1;
            for(int j=1;j<i;j++){
                pt[i][j]=pt[i-1][j-1]+pt[i-1][j];
            }
            pt[i][i]=1;
        }
    }
    public void printTriangle(){
        for(int i=0;i<n;i++) {
            for (int j = 0; j < i + 1; j++) System.out.print(pt[i][j] + " ");
        System.out.println();}
    }
    /*
    public static void main(String ar[]){
        pascal_triangle pas = new pascal_triangle();
        pas.createTriangle(6);
        pas.printTriangle();
    }
    */
}
