package CrackingTheCodingInterview.ArraysAndStrings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by SanthoshVarathan on 05/07/17.
 */
public class CheckPermutation {
    public static boolean bruteForceMethod(String a, String b){
        boolean bCheckArray[] = new boolean[b.length()];
        char bArray[] = b.toCharArray();
        for(int i=0;i<bArray.length;i++) {
            boolean found = false;
            for (char c : a.toCharArray())
                if (bArray[i]==c) {
                    found = true;
                    break;
                }
            if(found == false) return false;
        }
        return true;
    }

    public static boolean hashCheckMethod(String a,String b){
        Set<Character> aHashSet = new HashSet<>();
        for(char c:a.toCharArray())
            aHashSet.add(c);
        for(char c:b.toCharArray())
            if(!aHashSet.contains(c))
                return false;
        return true;
    }

    public static String sort(String s){
        char a[] = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
    public static boolean sortCheckMethod(String a,String b){
        if(a.length()!=b.length())
            return false;
        return sort(a).equals(sort(b));
    }

    public static void main(String ar[]){
        String a = "santhosh",b = "hsohtnas";
        System.out.println("Brute Force Method:"+bruteForceMethod(a,b));
        System.out.println("Hashed Method:"+hashCheckMethod(a,b));
        System.out.println("Sorted Method:"+sortCheckMethod(a,b));
    }
}
