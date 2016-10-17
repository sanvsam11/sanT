/**
 * Created by SanthoshVarathan on 12/10/16.
 * java program to convert hour/minute time to words
 */
import java.util.*;
import java.lang.String;
import java.util.regex.*;
public class timeTeller {
    public String numberToWords(int n){String time="";
        String units[] = {"one","two","three","four","five","six","seven","eight","nine","ten"},
                teens[]={"eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen",
                        "eighteen","nineteen"},
                mul[]={"zero","ten","twenty","thirty","forty","fifty","sixty"};


        if(n<11)time=units[n-1];
        else if(n<20) time = teens[n-11];
        else if(n%10==0) time = mul[n/10];
        else{
            time = mul[n/10];
            time = time.concat(units[n%10-1]);
        }
        return time;
    }
    public void timePrinter(int h,int m){String time="";
        if(m==0)
            time = numberToWords(h).concat(" o' clock");
        else if(m==15){
            time = "quarter past ";time = time.concat(numberToWords(h));
        }
        else if(m==30){
            time = "half past "; time = time.concat(numberToWords(h));
        }
        else if(m<30){
            time = numberToWords(m);time = time.concat(" minutes past ");
            time = time.concat(numberToWords(h));
        }
        else if(m==45){h=h+1;
            time = "quarter to ";time = time.concat(numberToWords(h));
        }

        else{
            m=60-m;h=h+1;
            time = numberToWords(m);time = time.concat(" minutes to ");
            time = time.concat(numberToWords(h));
        }
        System.out.println(time);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int h = in.nextInt();
        int m = in.nextInt();
        timeTeller s = new timeTeller();
        s.timePrinter(h,m);
    }
}
