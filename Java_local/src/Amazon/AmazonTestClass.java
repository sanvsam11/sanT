package Amazon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by SanthoshVarathan on 03/07/17.
 */
public class AmazonTestClass {
    public static void main(String ar[]) throws IOException{
        Object testObject;
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(System.in);
        //testObject = new PointsSquareCheck(in);
        testObject = new RotateStringCheck(in);
    }
}
