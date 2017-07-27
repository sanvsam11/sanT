package Amazon;

import java.util.Scanner;

/**
 * Created by SanthoshVarathan on 03/07/17.
 * test input
 * The first line of input contains an integer T denoting the number of test cases.
 The first line of each test case contains x1, y1, x2, y2, x3, y3, x4, y4 (four points coordinates).
 1
 20 10 10 20 20 20 10 10
 */
class point{
    int x,y;
    public point(int a, int b){
        x = a;y = b;
    }
}
public class PointsSquareCheck {
    public PointsSquareCheck(Scanner in){
        String input[] = new String[2];
        input[0] = in.nextLine();
        input[1] = in.nextLine();
        int t = Integer.parseInt(input[0]);
        for(int i=0;i<t;i++){
            point p[] = new point[4];
            String testCase[] = input[1].split(" ");
            for(int x=0,j=0;x<8;x+=2)
                p[j++] = new point(Integer.parseInt(testCase[x]),Integer.parseInt(testCase[x+1]));
            System.out.println(PointsSquareCheckMethod(p[0],p[1],p[2],p[3]));
        }
    }
    public int findDistance(point p1,point p2){
        double X = Math.abs(p1.x-p2.x),Y = Math.abs(p1.y-p2.y);
        return (int) Math.sqrt(X*X + Y*Y);
    }
    public boolean PointsSquareCheckMethod(point p1,point p2,point p3, point p4){
        int d12 = findDistance(p1,p2), d13 = findDistance(p1,p3), d14 = findDistance(p1,p4);
        if(d12==d13) return d14==findDistance(p2,p3);
        else if(d12==d14) return d13==findDistance(p2,p4);
        else if(d13==d14) return d12==findDistance(p3,p4);
        else return false;
    }
}
