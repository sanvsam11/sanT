package Inner_Classes;

/**
 * Created by SanthoshVarathan on 20/11/16.
 */
public class methodLocal {
    private int x = 7;
    public void doStuff(){
        class methodLocalInner{
            public void getOuter(){
                System.out.println("x value is: "+x);
            }
        }
    }
    public static void main(String ar[]){
        methodLocal m = new methodLocal();
        m.doStuff();
    }
}
