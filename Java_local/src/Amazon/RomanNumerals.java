package Amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by SanthoshVarathan on 23/07/17.
 */
public class RomanNumerals {
    Map<Integer,String> Symbols;
    RomanNumerals(Map<Integer,String> sym){
        Symbols = sym;
    }
    public StringBuilder toRomanMethod(int n,int place){
        StringBuilder result = null;
        if(n>0)
            result = toRomanMethod(n/10,place+1);
        if(n==0)
            return new StringBuilder();
        int d = n % 10;
        if(d==0) return result;
        int dVal = 1;
        for(int i=1;i<place;i++)
            dVal*=10;
        if(Symbols.containsKey(d*dVal))
            result.append(Symbols.get(d*dVal));
        else{
            if(d==4||d==9)
                result.append(Symbols.get(dVal)+Symbols.get((d+1)*dVal));
            else{
                if(d>5)
                    result.append(Symbols.get(dVal*5));
                for(int i=0;i<d%5;i++)
                    result.append(Symbols.get(dVal));
                }
        }
        return result;
    }
    public static void main(String ar[]){
        int input = new Scanner(System.in).nextInt();
        Map<Integer,String> symbols = new HashMap<>();
        symbols.put(10,"X");
        symbols.put(50,"L");
        symbols.put(1,"I");
        symbols.put(5,"V");
        symbols.put(100,"C");
        symbols.put(500,"D");
        symbols.put(1000,"M");
        System.out.println(new RomanNumerals(symbols).toRomanMethod(input,1).toString());
    }
}
