package Amazon;

/**
 * Created by SanthoshVarathan on 22/07/17.
 */
public class CheckNumberPowerOf {
    static boolean checkmethod(int n,int x,int y){
        if(n%x!=0)
            return false;
        int check = 1;
        while(y-->0)
            check*=x;
        return check==n;
    }
    public static void main(String ar[]){
        System.out.println(checkmethod(27,3,3));
    }
}
