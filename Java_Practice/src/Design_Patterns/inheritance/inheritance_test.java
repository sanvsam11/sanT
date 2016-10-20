package Design_Patterns.inheritance;

/**
 * Created by SanthoshVarathan on 20/10/16.
 */
public class inheritance_test {

    public static void main(String ar[]){
        animal a = new dog();
        dog d = new dog();
        try{a.eat();}catch(InterruptedException e){
            e.printStackTrace();
        }
        d.eat();
    }
}


