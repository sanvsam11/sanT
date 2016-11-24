package Inner_Classes;

/**
 * Created by SanthoshVarathan on 20/11/16.
 */
public class Regular {
    private int x = 7;
    public void createInnerInstance(){
        Inner i = new Inner();
        x=8;
        i.seeOuter();
    }
    public class Inner{
        public void seeOuter(){
            System.out.println("x value is: "+Regular.this.x);
            System.out.println("this:"+this+"\nouter.this:"+Regular.this);
        }
    }
    /*
    public static void main(String ar[]){
        Regular r = new Regular();
        Regular.Inner ri = r.new Inner();
        ri.seeOuter();
        r.createInnerInstance();
        ri.seeOuter();
    }
    */
}
