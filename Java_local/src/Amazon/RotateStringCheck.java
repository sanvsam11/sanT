package Amazon;

import java.util.Scanner;

/**
 * Created by SanthoshVarathan on 03/07/17.
 */
public class RotateStringCheck {
    public RotateStringCheck(Scanner in){
        int t = Integer.parseInt(in.nextLine());
        for(int i=0;i<t;i++){
            String a = in.nextLine(),b = in.nextLine();
            System.out.println(rotationCheck(a.toCharArray(),b.toCharArray())?1:0);
        }
    }
    public static boolean rotationCheck(char a[],char b[]){
        int l = a.length;
        for(int i=0;i<a.length;i++){
            char ch_a = a[i],ch2_a = a[(i+2)%l], ch_b = b[i],ch2_b = b[(i+2)%l];
            if(a[(i+2)%l]!=b[i]||a[i]!=b[(i+2)%l]) return false;
        }
        return true;
    }
}
