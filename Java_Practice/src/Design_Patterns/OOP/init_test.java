package Design_Patterns.OOP;

/**
 * Created by SanthoshVarathan on 23/10/16.
 */
public class init_test extends init_test_super {
    {System.out.println("8. init before def con");}
    public init_test(){
        System.out.println("10. init_test def constructor");

    }
    {System.out.println("9. init after defcon");}
    static{System.out.println("Static init after def con");}
    /*
    public static void main(String ar[]){
        System.out.println("3. init_test main");
        init_test i=new init_test();
    }
*/
}
