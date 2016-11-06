package RexEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by SanthoshVarathan on 05/11/16.
 */
public class regex {
    public static void main(String ar[]){
        String sm = "ababaababaaababaaaaababaaaa";
        String sp = "abaa";
        Pattern p = Pattern.compile(sp);
        Matcher m = p.matcher(sm);
        System.out.println("pattern: "+p+" matcher: "+m);
        while(m.find()){
            System.out.println(m.start()+" "+m.group());
        }
    }
}
