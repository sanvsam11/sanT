/**
 * Created by SanthoshVarathan on 12/10/16.
 */
import java.util.*;
public class giftbw {
    public long costFinder(long b,long w,long x,long y,long z)
    {long result=0;
        if(b==w||x==y)
            result = b*x+w*y;
        else{
            if(x>(z+y)){
                result = w*y + b*(y+z);
            }
            if(y>(z+x)){
                result = w*(x+z) + b*x;
            }
            else result = b*x+w*y;
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long b = in.nextLong();
            long w = in.nextLong();
            long x = in.nextLong();
            long y = in.nextLong();
            long z = in.nextLong();
            giftbw s = new giftbw();
            System.out.println(s.costFinder(b,w,x,y,z));
        }
    }
}
