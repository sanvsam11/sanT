package Amazon;

/**
 * Created by SanthoshVarathan on 27/07/17.
 */
public class PermutationsProblem {
    public void printPermutations(String input,String prefix){
        if(input.isEmpty())
            System.out.println(prefix);
        for(int c=0;c<input.length();c++)
            printPermutations(input.substring(0,c)+input.substring(c+1),prefix+input.charAt(c));
    }
    public static void main(String ar[]){
        String input = "abc";
        new PermutationsProblem().printPermutations(input,"");
    }
}
