package Design_Patterns.Singleton;

/**
 * Created by SanthoshVarathan on 06/11/16.
 */
public class MainClass {
    public void bookerMethod(){
        //basicSingleton b = new basicSingleton();
        basicSingleton b = basicSingleton.getInstance();
        b.addTickets();
        b.bookingAgentMethod();
    }
    public static void main(String ar[]){
        for(int i=0;i<3;i++)
        new MainClass().bookerMethod();
    }
}
