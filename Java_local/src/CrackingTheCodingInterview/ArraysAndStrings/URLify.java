package CrackingTheCodingInterview.ArraysAndStrings;

/**
 * Created by SanthoshVarathan on 05/07/17.
 */
public class URLify {
    public static String URLMethod(char a[]){
        int i=a.length-1,j=0;
        while(i>=0) {
            boolean foundSpace = false, canInsert = false;
            while (!foundSpace) {
                if (a[i] != ' ') j = i;
                if (a[i] != ' ' && a[i - 1] == ' ') foundSpace = true;
                i--;
            }
            for (int e = a.length; j >= i; j--,e--)
                for (int k = j + 1; k < e; k++) {
                    a[k] = a[k-1];
                    a[k-1] = ' ';
                }
            if (canInsert) {
                i = a.length - 1;
                while (a[i--] != ' ') ;
                a[i] = '0';
                a[i - 1] = '2';
                a[i - 2] = '%';
            }
            if (!canInsert) canInsert = true;
        }
        return a.toString();
    }
    public static void main(String ar[]){
        char input[] = {'a',' ','s','t','r','i','n','g','s',' ','p','u','r','p','o','s','e',' ',' ',' ',' '};
        System.out.println("Output:"+URLMethod(input));
    }
}
