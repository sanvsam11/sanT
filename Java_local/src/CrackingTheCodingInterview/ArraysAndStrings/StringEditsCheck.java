package CrackingTheCodingInterview.ArraysAndStrings;

/**
 * Created by SanthoshVarathan on 06/07/17.
 */
public class StringEditsCheck {
    public static boolean isEditCountOneCheckMethod(String a, String b){
        char aAr[] = a.toCharArray();
        char bAr[] = b.toCharArray();
        int differenceLength = Math.abs(aAr.length-bAr.length);
        if(differenceLength>1) return false;
        boolean foundEdit = false;
        for(int a_i=0,b_i=0;a_i<aAr.length&&b_i<bAr.length;a_i++,b_i++) {
            if (aAr[a_i] == bAr[b_i]) continue;
            if (foundEdit) return false;
            if (differenceLength == 0) {   //detected replacement
                foundEdit = true;
            } else if (aAr[a_i + 1] == bAr[b_i]) {  //insert or delete detection
                a_i++;
                foundEdit = true;
            } else if (aAr[a_i] == bAr[b_i + 1]) {
                b_i++;
                foundEdit = true;
            }
        }
        return true;
    }

    public static void main(String ar[]){
        String a = "flan",b = "blak";
        System.out.println(isEditCountOneCheckMethod(a,b));
    }
}
