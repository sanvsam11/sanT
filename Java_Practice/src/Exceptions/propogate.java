package Exceptions;

/**
 * Created by SanthoshVarathan on 23/10/16.
 */
public class propogate{
    public String reverse (String s)throws EmptyStringException{
            int l=s.length();
        StringBuilder r = new StringBuilder();
        for(int i=s.length();i>0;i--)r.append(s.charAt(i));
        return r.toString();
    }
    public static void main(String ar[]){
        String a = "reverse";
        String b = "";
        try {
            new propogate().reverse(a);
            new propogate().reverse(b);
        } catch (EmptyStringException e) {
            e.printStackTrace();
        }
    }
}
