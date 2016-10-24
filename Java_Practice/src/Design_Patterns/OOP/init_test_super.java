package Design_Patterns.OOP;

/**
 * Created by SanthoshVarathan on 23/10/16.
 */
public class init_test_super extends init_test_super2{
    init_test_super(){
        System.out.println("7. init_test_super def constructor");
    }
    static {System.out.println("2. static init super");}
    {System.out.println("6. init super");}
}
