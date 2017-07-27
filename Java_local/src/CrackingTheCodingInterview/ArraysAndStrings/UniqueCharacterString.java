package CrackingTheCodingInterview.ArraysAndStrings;

import java.util.*;

/**
 * Created by SanthoshVarathan on 05/07/17.
 */
public class UniqueCharacterString {
    public static boolean hashingMethod(String s){
        Set<Character> charMap = new HashSet<>();
        //char charArray[] = s.toCharArray();
        for(char c:s.toCharArray()){
            if(charMap.contains(c))
                return false;
            else
                charMap.add(c);
        }
        return true;
    }

    public static boolean bruteForceMethod(String s){
        char charArray[] = s.toCharArray();
        for(int i=0;i<charArray.length;i++){
            for(int j=0;j<charArray.length;j++){
                if(i!=j&&charArray[i]==charArray[j]) return false;
            }
        }
        return true;
    }

    public static boolean sortAdjacentMethod(String s){
        List<Character> charList = new ArrayList<>();
        for(char c:s.toCharArray())
            charList.add(c);
        Collections.sort(charList);
        for(int i=1;i<charList.size();i++)
            if(charList.get(i-1)==charList.get(i)) return false;
        return true;
    }

    public static void main(String ar[]){
        String s = "santho";
        System.out.println(sortAdjacentMethod(s));
    }
}
