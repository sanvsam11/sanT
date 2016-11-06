package Design_Patterns.Singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by SanthoshVarathan on 06/11/16.
 * code to test singleton design pattern
 * basicSingleton is responsible for providing tickets to a movie show
 */
public class basicSingleton { //show
    private basicSingleton(){
    this.addTickets();
    }
    static basicSingleton Instance;
    ArrayList<String> tickets = new ArrayList<String>();
    public void addTickets(){
        tickets.add("A1");
        tickets.add("A2");
        tickets.add("A3");
        tickets.add("B1");
    }
    public boolean book(String t){
        return tickets.remove(t);
    }
    public static basicSingleton getInstance(){
        if(Instance==null) Instance=new basicSingleton();
        return Instance;
    }
    public void bookingAgentMethod(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter required seat: ");
        String ticketRequest = in.next();
        System.out.println("Trying to book seat "+ticketRequest);
        System.out.println("Booking status: "+book(ticketRequest));
    }
}
