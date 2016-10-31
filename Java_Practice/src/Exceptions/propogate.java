package Exceptions;
import java.lang.*;
import java.util.*;

/**
 * Created by SanthoshVarathan on 23/10/16.
 */
public class propogate{
    public String reverse (String s)throws EmptyStringException{
            try{
                int l=s.length();
                if(l==0) throw new EmptyStringException();
                Scanner in = new Scanner(System.in);
                in.nextInt();
            }catch (EmptyStringException|InputMismatchException e){
                e.printStackTrace();
            }
        StringBuilder r = new StringBuilder();
        for(int i=(s.length()-1);i>=0;i--)r.append(s.charAt(i));
        return r.toString();
    }
    public static void main(String ar[]){
        String a = "reverse";
        String b = "";
        try {
            System.out.println(new propogate().reverse(a));
            System.out.println(new propogate().reverse(b));
        } catch (EmptyStringException e) {
            e.printStackTrace();
        }
    }
}
