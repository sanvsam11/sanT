package Amazon;

/**
 * Created by SanthoshVarathan on 05/07/17.
 */
public class StringPermutationSpace {
    public void printPermutationsSpace(char a[],char buffer[],int i,int j,int n){
        if(i==n){
            buffer[j] = '\0';
            System.out.println(buffer);
            return;
        }

        buffer[j] = a[i];
        printPermutationsSpace(a,buffer,i+1,j+1,n);

        buffer[j] = ' ';
        buffer[j+1] = a[i];
        printPermutationsSpace(a,buffer,i+1,j+2,n);
    }
    public void printPermutations(String s,String prefix){
        if(s.length()==0)
           System.out.println(prefix);
        for(int i=0;i<s.length();i++){
            String rem = s.substring(0,i)+s.substring(i+1,s.length());
            printPermutations(rem,prefix+s.charAt(i));
        }
    }
//    public static void main(String ar[]){
//        String s = "ABCD";
//        char buffer[] = new char[s.length()*2];
//        buffer[0] = s.charAt(0);
//        //new StringPermutationSpace().printPermutations(s," ");
//        new StringPermutationSpace().printPermutationsSpace(s.toCharArray(),buffer,1,1,s.length());
//    }
}
