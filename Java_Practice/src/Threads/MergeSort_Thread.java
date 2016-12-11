package Threads;

/**
 * Created by SanthoshVarathan on 05/12/16.
 */
public class MergeSort_Thread implements Runnable{
    Integer a[],s=0,e=0,l=0;
    MergeSort_Thread(Integer[] a,Integer s,Integer e){
        this.a = a;this.s=s;this.e=e;l=a.length;
    }
    boolean compare(int i,int j){
        return (a[i]>a[j])?true:false;
    }
    void swap(int i,int j){
        int x=a[i];
        a[i]=a[j];
        a[j]=x;
    }
    public void run(){
        if(l<2) return;
        else if(l==3) for(int i=s;i<e;i++)if(compare(i,i+1))swap(i,i+1);
        else{
            Integer m = (s+e)/2;
            Integer leftArray[]=new Integer[m-s+1],rightArray[]=new Integer[e-m];
            Thread leftThread = new Thread(new MergeSort_Thread(leftArray,s,m));
            Thread rightThread = new Thread(new MergeSort_Thread(rightArray,m+1,e));
            leftThread.start();
            rightThread.start();

            try {
                leftThread.join();rightThread.join();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            for(int x=s,left_index=0,right_index=0;x<a.length&&left_index<=m&&right_index<=e;){
                if(leftArray[left_index]<rightArray[right_index]){
                    a[x]=leftArray[left_index];a[x+1]=rightArray[right_index];
                }
                else{
                    a[x]=rightArray[right_index];a[x+1]=leftArray[left_index];
                }
                x++;left_index++;right_index++;
            }
        }
        for(int i:a)System.out.print(a[i]+" ");
    }
    public static void main(String ar[]){
<<<<<<< HEAD
        Integer a[]={10,9,8,7,6,5,4,3,2,1};
        MergeSort_Thread o = new MergeSort_Thread(a,0,(a.length)-1);
=======
        int a[]={10,9,8,7,6,5,4,3,2,1};
		MergeSort_Thread o=new MergeSort_Thread(a);
>>>>>>> 349ff7ed40be46ba2a76b6400493b2d047ab1326
        Thread t = new Thread(o);
        t.start();
        try {
            t.join();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
<<<<<<< HEAD
        //for(int i:o.a)System.out.print(i+" ");
=======
        for(int i:o.a)System.out.print(i+" ");
>>>>>>> 349ff7ed40be46ba2a76b6400493b2d047ab1326
    }
}
