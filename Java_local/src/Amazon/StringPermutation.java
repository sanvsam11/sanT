package Amazon;

/**
 * Created by SanthoshVarathan on 22/07/17.
 */
public class StringPermutation {
    public static void printPermutations(String s,int limit){
        printPermutationsMethod(s,"",s.length()-limit);
    }
    public static void printPermutationsMethod(String start,String end,int limit){
        if(start.length()==limit)
            System.out.println(end);
        else{
            for(int i=0;i<start.length();i++)
                printPermutationsMethod(start.substring(0, i) + start.substring(i + 1), end + start.charAt(i), limit);
            }
    }
    public static void main(String ar[]){
        String s = "abcd";
        printPermutations(s,3);
    }
}
