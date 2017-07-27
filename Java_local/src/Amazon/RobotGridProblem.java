package Amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by SanthoshVarathan on 24/07/17.
 */
public class RobotGridProblem {
    cell target;
    public RobotGridProblem(int x,int y){
        target = new cell(x,y);
    }
    class cell{
        int x,y;
        cell(int a,int b){
            x = a;
            y = b;
        }
        public boolean equals(cell c){
            return x==c.x&&y==c.y;
        }
    }
    List<cell> findPathInGrid(boolean grid[][], List<cell> path, cell current){
        if(current==null)
            current=new cell(0,0);
        if(current.x==grid.length&&current.y==grid.length)
            return path;
        else if(current.x<0||current.x>=grid.length||current.y<0||current.y>=grid.length)
            return null;
        else if(!grid[current.x][current.y])
            return null;
        else{
            path.add(current);
            List<cell> tempDown = findPathInGrid(grid,path,new cell(current.x,current.y+1)),tempRight=findPathInGrid(grid,path,new cell(current.x+1,current.y));
            if(tempDown!=null)
                path = tempDown;
            else if(tempRight!=null)
                path = tempRight;
            else{
                path.remove(path.indexOf(current));
                return null;
            }
        }
        return path;
    }
    public void printMatrix(char[][] result){
        for(int i=0;i<result.length;i++){
            for(int j=0;j<result.length;j++)
                System.out.print(result[i][j]);
            System.out.println();
        }
    }
    public static void main(String ar[]){
        Random r = new Random();
        int n = r.nextInt(10);
        char resultMatrix[][] = new char[n][n];
        List<cell> path = new ArrayList<>();
        boolean grid[][] = new boolean[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                if(r.nextInt(100)%3==0){
                    resultMatrix[i][j] = 'B';
                    grid[i][j] = false;
                }
                else {
                    resultMatrix[i][j] = ' ';
                    grid[i][j] = true;
                }
        RobotGridProblem rgInstance = new RobotGridProblem(n-1,n-1);
        path=rgInstance.findPathInGrid(grid,path,null);
        if(path!=null)
            for(cell c:path)
                resultMatrix[c.x][c.y] = '*';
        rgInstance.printMatrix(resultMatrix);

    }
}
