/**
 * Created by sant on 10/12/15.
 */
import java.util.*;
public class shiftpn {
    public int shiftcheck(String pn){
        int l = pn.length(),sh=0;boolean s=false;
        for (int i=0;i<l;i++){
            if(!((s==false&&pn.charAt(i)=='+')||(s==true&&pn.charAt(i)=='-'))) sh++;
            s=!s;
        }
        return sh;
    }
    public static void main(String args[]){
		shiftpn ob = new shiftpn();
        Scanner in = new Scanner(System.in);
        String input = in.next();
        System.out.println(ob.shiftcheck(input));
    }
}
