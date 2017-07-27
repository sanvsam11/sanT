package Stack_Queue_Array;

/**
 * Created by SanthoshVarathan on 04/05/17.
 */
public class stack_dual {
    int set[],l,t1=0,t2=0;
    stack_dual(int length){
        l=length;
        set = new int[l];t2 = l-1;
    }
    public void push(boolean leftinsert,int element){
        if(t1==t2) return;
        if(leftinsert) {
            set[t1++] = element;
        }
        else {
            set[t2--] = element;
        }
    }
    public int pop(boolean leftpop){
        if(leftpop){
            if(t1==-1) return -1000;
            t1--; return set[t1+1];
        }
        else{
            if(t2==l) return -1000;
            t2++; return set[t2-1];
        }
    }
    public void printStacks(){
        System.out.print("Stack1:");
        for(int i=0;i<t1;i++) System.out.print(set[i]+" ");
        System.out.println();
        System.out.print("Stack2:");
        for(int i=l-1;i>t2;i--) System.out.print(set[i]+" ");
    }
}
