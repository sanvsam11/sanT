package Design_Patterns.OOP;

/**
 * Created by SanthoshVarathan on 23/10/16.
 */
public class init_test_super2 {
    static {System.out.println("1. initsuper 2 static");}
    init_test_super2()
    {
        System.out.println("5. super 2 def con");
    }
    {System.out.println("4. init after defcon super 2");}
}
