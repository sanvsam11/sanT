package CrackingTheCodingInterview.ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SanthoshVarathan on 05/07/17.
 */
public class PalindromePermutation {
    public static boolean palindromePermuationCheckMethod(String input){
        boolean foundOddCount = false;
        input = input.toLowerCase();
        Map<Character,Integer> charMap = new HashMap<>();
        for(char c:input.toCharArray()){
            if(c!=' '){
                if(charMap.containsKey(c))
                    charMap.put(c,charMap.get(c)+1);
                else
                    charMap.put(c,1);
            }
        }
        for(Map.Entry<Character,Integer> e:charMap.entrySet())
            if(e.getValue()%2!=0){
                if(!foundOddCount)
                    foundOddCount = true;
                else
                    return false;
            }
        return true;
    }

    public static void main(String ar[]){
        String input = "Tact coa";
        System.out.println(palindromePermuationCheckMethod(input));
    }
}
