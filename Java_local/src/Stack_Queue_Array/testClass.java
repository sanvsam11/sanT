package Stack_Queue_Array;

/**
 * Created by SanthoshVarathan on 04/05/17.
 */
public class testClass {
    public static void main(String ar[]){
        stack_dual s = new stack_dual(10);
        for(int i=10;i<=40;i+=10) s.push(true,i);
        for(int i=500;i>=100;i-=100) s.push(false,i);
        s.printStacks();
    }
}
