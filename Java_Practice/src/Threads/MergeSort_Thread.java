package Threads;

/**
 * Created by SanthoshVarathan on 05/12/16.
 */
public class MergeSort_Thread implements Runnable{
    Integer a[],s=0,e=0,l=0;
    MergeSort_Thread(Integer[] a,Integer s,Integer e){
        this.a = a;this.s=s;this.e=e;l=e-s;
    }
    boolean compare(int i,int j){
        return (a[i]>a[j])?true:false;
    }
    void swap(int i,int j){
        int x=a[i];
        a[i]=a[j];
        a[j]=x;
    }
    void merge(int m){
        for(int i=m;i>=0;i--){int j=i;
            while(compare(j,j+1))swap(j,j+1);
        }
    }
    void mergesortMethod(){
        if(l<2) return;
        else if(l==3){
            for(int i=0,j=i+1;i<l&&j<=l;j++,i++){
                if(compare(i,j))swap(i,j);
            }
        }
        else {
            int m = (s+e)/2;
            MergeSort_Thread left = new MergeSort_Thread(a,s,m);
            MergeSort_Thread right = new MergeSort_Thread(a,m+1,e);
            Thread left_thread = new Thread(left);
            Thread right_thread = new Thread(right);
             left_thread.start();
            right_thread.start();
            try {
                left_thread.join();right_thread.join();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            merge(m);
        }
    }
    public void run(){
        mergesortMethod();
        }
        //for(int i:a)System.out.print(a[i]+" ");

    public static void main(String ar[]){

        Integer a[]={10,9,8,7,6,5,4,3,2,1};
        MergeSort_Thread o = new MergeSort_Thread(a,0,(a.length)-1);

        //int a[]={10,9,8,7,6,5,4,3,2,1};
		//MergeSort_Thread o=new MergeSort_Thread(a);

        Thread t = new Thread(o);
        t.start();
        try {
            t.join();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        //for(int i:o.a)System.out.print(i+" ");

        for(int i:o.a)System.out.print(i+" ");

    }
}
