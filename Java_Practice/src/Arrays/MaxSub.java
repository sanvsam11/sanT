package Arrays;

/**
 * Created by SanthoshVarathan on 27/09/16.
 
 */
public class MaxSub {
	public int maxSubarraySum(int a[],int n){
int sum[]=new int[n],curmax=0,currSum=sum[0]=a[0];
for(int i=0;i<n;i++){
	 currSum+=a[i];
	 if(currSum>curmax)curmax=currSum;
}

	return curmax;
	}
    public static void main(String ar[]){
int a[]={1,1,-1,1,1,-1,-1,-1};
MaxSub m = new MaxSub();
System.out.println(m.maxSubarraySum(a,a.length));
    }
}
