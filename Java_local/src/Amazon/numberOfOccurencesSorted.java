package Amazon;

/**
 * Created by SanthoshVarathan on 05/07/17.
 */
public class numberOfOccurencesSorted {
    int binarySearch(int a[],int s,int e,int x){
        if(s==e)
            if(a[s]==x) return s;
            //else if(a[e]==x) return e;
        else
            return -1;
        int m = s+(e-s)/2;
        if(a[m]==x) return m;
        else {
            if(a[m]<x) return binarySearch(a,m+1,e,x);
            else return binarySearch(a,s,m-1,x);
        }
    }
    int getXCount(int a[],int x){
        int position = binarySearch(a,0,a.length-1,x);
        if(position==-1) return 0;
        int count = 1,i=position;
        while(--i>=0&&a[i]==x) count++;i=position;
        while(++i<a.length&&a[i]==x) count++;
        return count;
    }
//    public static void main(String ar[]){
//        int a[] = {1, 1, 2, 2, 2, 3, 3},x=3;
//        System.out.println(new numberOfOccurencesSorted().getXCount(a,x));
//    }
}
