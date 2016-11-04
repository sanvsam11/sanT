/**
 * Created by SanthoshVarathan on 04/11/16.
 */
public class longestValidBraceString {
    StackusingQueue s = new StackusingQueue();
    public int longestValidSequenceCaller(String s){
        return longestValidSequence(s.toCharArray());
    }
    public int longestValidSequenceCaller(char a[]){
        return longestValidSequence(a);
    }
    int longestValidSequence(char a[]){int r=0;s.pop();char t;
        for(int i=0;i<a.length;i++){
            if(a[i]=='(') {s.push(a[i]);r++;System.out.print("(");}
            else if(a[i]==')'){
                if(s.isEmpty())r=0;
                else {s.pop();r++;System.out.print(")");}
            }
        }
        return r;
    }
    public static void main(String ar[]){
        char ca[] = {'(','(',')', '(',')',')'};
        String s = "((()()())())";
        longestValidBraceString l = new longestValidBraceString();
        System.out.println("String: "+ca.toString()+" Output: "+l.longestValidSequenceCaller(ca));
        System.out.println("String: "+s+" Output: "+l.longestValidSequenceCaller(s));
    }
}
