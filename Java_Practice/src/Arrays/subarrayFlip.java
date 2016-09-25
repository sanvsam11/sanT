package Arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SanthoshVarathan on 20/09/16.
 *Arrays:Maximize number of 0s by flipping a subarray
 * Given a binary array, find the maximum number zeros in an array with one flip of a subarray(contiguous) allowed.
 * A flip operation switches all 0s to 1s and 1s to 0s.
 *
 * Input :  arr[] = {0, 1, 0, 0, 1, 1, 0}
 Output : 6
 We can get 6 zeros by flipping the subarray {1, 1}

 Input :  arr[] = {0, 0, 0, 1, 0, 1}
 Output : 5
*/
public class subarrayFlip {
    public void findMaxZeroFlip(int a[],int n){
        //HashMap<Integer,Integer> flipFind = new HashMap<Integer, Integer>();
        int flipFind[]=new int[n],maxZero=0,nextZeroLeftofMax=0,maxLocation=0,finalLength=0,nextZeroRightofMax=0;for(int i=0;i<n;i++) flipFind[i]=0;
        boolean previous_is_zero=false;
        int zero_count=0,initial=0;
        for(int i=0;i<n;i++){
            if(a[i]==1){flipFind[initial]=zero_count;if(zero_count>maxZero){maxZero=zero_count;maxLocation=initial;}initial=0; zero_count=0;previous_is_zero=false;}
            else if(a[i]==0&&(!previous_is_zero)){zero_count=1;initial=i;previous_is_zero=true;}
            else if(a[i]==0&&previous_is_zero){zero_count++;}
        }
        //for (int i=0;i<n;i++)if(flipFind[i]>maxZero){maxZero=flipFind[i];maxLocation=i;}
        for(int i=maxLocation;i>0;i--) if(flipFind[i]>0) nextZeroLeftofMax=maxLocation-i+maxZero;
        for(int i=maxLocation;i<n;i++) if(flipFind[i]>0) nextZeroRightofMax=maxLocation+maxZero-1+i+maxZero;
        finalLength=nextZeroLeftofMax>nextZeroRightofMax?nextZeroLeftofMax:nextZeroRightofMax;
        System.out.println("Result:"+finalLength);
    }
    public static void main(String ar[]){
        int a[]={0,1,0,0,1,1,0},l=7;
        subarrayFlip s = new subarrayFlip();
        s.findMaxZeroFlip(a,l);

    }
}
