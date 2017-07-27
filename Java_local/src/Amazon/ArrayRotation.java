package Amazon;

/**
 * Created by SanthoshVarathan on 05/07/17.
 */
public class ArrayRotation {
    int a[];
    public ArrayRotation(int a[]){
        this.a = a;
    }
    public ArrayRotation rotateArrayJuggle(int d){
        for(int i=0;i<a.length/d;i++){
            int t = a[i],x=i,y=x+d;
            while(y<a.length){
                a[x] = a[y];
                x = y;
                y+=d;
            }
            a[x] = t;
        }
        return this;
    }
    public ArrayRotation rotateArray(int d){
        while(d-->0){
            int t = a[0];
            for(int i=0;i<a.length;i++){
                if((i+1)==a.length)
                    a[i] = t;
                else
                    a[i] = a[i+1];
            }
        }
        return this;
    }
    public void printArray(){
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]+" ");
    }
    public static void main(String ar[]){
        int a[] = {1, 2, 3, 4, 5, 6, 7}, d=2;
        new ArrayRotation(a).rotateArrayJuggle(d).printArray();
    }
}
