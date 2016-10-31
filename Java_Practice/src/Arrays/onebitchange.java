package Arrays;

/**
 * Created by Santhosh Varathan on 31-Oct-16.
 *
 * Change if all bits can be made same by single flip
 Given a binary string, find if it is possible to make all its digits
 equal (either all 0’s or all 1’s) by flipping exactly one bit.

 Input: 101
 Output: Yes
 Explanation: In 101, the 0 can be flipped
 to make it all 1

 Input: 11
 Output: No
 Explanation: No matter whichever digit you
 flip, you will not get the desired string.

 Input: 1
 Output: Yes
 Explanation: We can flip 1, to make all 0's
 */
public class onebitchange {
    public void oneFlipCheck(int[] a){int z=0,o=0;
        for(int i=0;i<a.length;i++){
            if(a[i]==0) z++;
            else o++;
            if(z>1&&o>1)break;
        }
        if(z==1||o==1) System.out.println("YES.");
        else System.out.println("NO.");
    }
    public static void main(String ar[]){
        int bar []= {0,1,0,1,0,1,1,1};
        onebitchange o = new onebitchange();
        o.oneFlipCheck(bar);
    }
}
