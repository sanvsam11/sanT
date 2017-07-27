package TechGig;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by SanthoshVarathan on 24/06/17.
 */
public class CandidateCode3 {
    public static int[] deleteOnlyOneAndOnce(int[] input1,int x)
    {
        int l = input1.length;
        for(int i:input1)
            if(i==x) l--;
        int output[] = new int[l],j=0;
        for(int i:input1)
            if(i!=x) output[j++]=i;
        return output;
    }
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int[] output = null;
        int ip1_size = 0;
        ip1_size = Integer.parseInt(in.nextLine().trim());
        int[] ip1 = new int[ip1_size];
        int ip1_item;
        for(int ip1_i = 0; ip1_i < ip1_size; ip1_i++) {
            ip1_item = Integer.parseInt(in.nextLine().trim());
            ip1[ip1_i] = ip1_item;
        }
        int x  = in.nextInt();
        output = deleteOnlyOneAndOnce(ip1,x);
        for(int output_i=0; output_i < output.length; output_i++) {
            System.out.println(String.valueOf(output[output_i]));
        }
    }

}
