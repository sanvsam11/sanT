package Interview_questions.Logging;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by SanthoshVarathan on 13/01/17.
 */
public class loggingExample {
    public static void main(String ar[]){
        HelloWorld hw = new HelloWorld("Hello World!");
        hw.sayHello();
        hw.sayHello();
        //Handler[] handlers = hw.LOGGER.getHandlers();
        //for(Handler h:handlers){
        //    System.out.println(h.getFormatter());
        //}

    }
}
class HelloWorld{
    String message;
    public static final Logger LOGGER = Logger.getLogger(loggingExample.class.getName());
    public HelloWorld(String message){
        this.message = message;
    }
    public void sayHello(){
        LOGGER.log(Level.FINE,message);
    }
}