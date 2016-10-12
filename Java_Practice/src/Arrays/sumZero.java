package Arrays;

/**
 * Created by SanthoshVarathan on 10/10/16.
 * Print all subarrays with 0 sum
 * Given an array, print all contiguous subarrays in the array which has sum 0.
 * Input:  arr = [6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7]
 Output:
 Subarray found from Index 2 to 4
 Subarray found from Index 2 to 6
 Subarray found from Index 5 to 6
 Subarray found from Index 6 to 9
 Subarray found from Index 0 to 10
 Related posts: Find if there is a subarray with
 */
public class sumZero {
    public void findZeroSubarray(int a[],int n){
        for(int i=0;i<n-1;i++){int initial=i,sum=a[i];
            for(int j=i+1;j<n;j++){
                sum+=a[j];
                if(sum==0) System.out.println("Subarray found from Index "+initial+" to "+j);
            }
        }
    }
    public static void main(String ar[]){
        int arr[] = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7},n=11;
        sumZero s = new sumZero();
        s.findZeroSubarray(arr,n);
    }
}
