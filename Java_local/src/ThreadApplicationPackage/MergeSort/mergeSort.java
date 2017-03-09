package ThreadApplicationPackage.MergeSort;

/**
 * Created by SanthoshVarathan on 23/02/17.
 */
public class mergeSort {

    public static void main(String ar[]){
        mergeSort m = new mergeSort();
        int a[]= {10,9,8,7,6,5,4,3,2,1};
        m.getArray(a);
        m.doMergeSort();
        a=m.getSortedArray();
        for(int i:a)System.out.print(i+", ");
    }
    int a[],l=0,aSorted[];
    splitter splitterThread;
    public void getArray(int[] a){
        if(a.length!=0)
        this.a = a;l=a.length;
    }
    public void doMergeSort(){
        splitterThread = new splitter(a);
        Thread t = new Thread(splitterThread);
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        aSorted=splitterThread.getSortedArray();
    }
    public int[] getSortedArray(){
        return aSorted;
    }
}
class splitter implements Runnable{
    int a[],l,aSorted[];
    public splitter(int a[]){
        this.a=a;l=a.length;
    }
    public int[] merge(int[] leftArray,int[] rightArray){
return null;
    }
    public int[] mergeArrays(int[] leftArray, int[] rightArray){
        int [] aMergeArray=new int[l];
        if(leftArray[(l/2)-1]<rightArray[l-1]){

            for(int i=0;i<l;i++){
                if(i<(l/2)) aMergeArray[i]=leftArray[i];
                else aMergeArray[i]=rightArray[i-(l/2)];
            }

        }
        else if(leftArray[0]>rightArray[l-1]){
            for(int i=0;i<l;i++){
                if(i<(l/2)) aMergeArray[i]=rightArray[i];
                else aMergeArray[i]=leftArray[i-(l/2)];
            }
        }
        else{
            for(int i=0;i<l;i++){
                int a=0,b=0;
                if(leftArray[a]<rightArray[b])
                    aMergeArray[i]=leftArray[a++];
                else
                    aMergeArray[i]=rightArray[b++];
            }

        }
        return aMergeArray;
    }
    public void run(){
        if(l>2){
            int leftArray[]=new int[l/2];
            int rightArray[]=new int[l/2];
            for(int i:a){int lin=0,rin=0;
                if(i<(l/2)) leftArray[lin++]=i;
                else rightArray[rin++]=i;
            }
            splitter leftSplit = new splitter(leftArray);               //splitting array into two
            splitter rightSplit = new splitter(rightArray);
            Thread leftThread = new Thread(leftSplit);
            Thread rightThread = new Thread(rightSplit);
            leftThread.start();
            rightThread.start();
            try {
                leftThread.join();rightThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            leftArray=leftSplit.getSortedArray();
            rightArray=rightSplit.getSortedArray();
            aSorted = new int[l];
            aSorted=mergeArrays(leftArray,rightArray);
        }
        else{
            if(a[0]>a[1]){
                aSorted[1]=a[0];
                aSorted[0]=a[1];
            }
            else{
                aSorted[0]=a[0];
                aSorted[1]=a[1];
            }
        }
    }
    public int[] getSortedArray(){
        return aSorted;
    }

}
