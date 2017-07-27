package Amazon;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SanthoshVarathan on 27/07/17.
 */
public class CoinsProblem {
    int change[] = {1,5,10,25};
    Map<Integer,Integer> Memoizer = new HashMap<>();
    public int coinChangeProblemMethod(int n){
        if(Memoizer.containsKey(n))
            return Memoizer.get(n);
        int resultCount=0;
        if(n==0)
            return 1;
        else if(n<0)
            return 0;
        else
        for(int ch=0;ch<change.length;ch++)
            resultCount = resultCount + coinChangeProblemMethod(n-change[ch]);
        if(!Memoizer.containsKey(n))
            Memoizer.put(n,resultCount);
        return resultCount;
    }
    public static void main(String ar[]){
        int n = 30;
        System.out.println("Count of possible change:"+new CoinsProblem().coinChangeProblemMethod(n));
    }
}
