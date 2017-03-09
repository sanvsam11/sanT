package Interview_questions;

/**
 * Created by SanthoshVarathan on 15/12/16.
 */
public class string_reverse {
    StringBuilder reversedString=new StringBuilder();
    String reverseMethod(String input){
        for(int i=input.length()-1;i>=0;i--)reversedString.append(input.charAt(i));
        return reversedString.toString();
    }
    public static void main(String ar[]){
        String s = "Santhosh";
        string_reverse object = new string_reverse();
        System.out.println(object.reverseMethod(s));
    }
}
