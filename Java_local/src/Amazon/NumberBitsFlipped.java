package Amazon;

/**
 * Created by SanthoshVarathan on 23/07/17.
 */
public class NumberBitsFlipped {
    public int numberOfBitsFlip(int a,int b){
        int count = 0;
        int x = a^b;
        while(x>0){
            x = x & (x-1);
            count++;
        }
        return count;
    }
    public static void main(String ar[]){
        int a = 7,b = 8;
        System.out.println(new NumberBitsFlipped().numberOfBitsFlip(a,b));
    }
}
