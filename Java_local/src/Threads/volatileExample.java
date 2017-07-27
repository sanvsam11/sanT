package Threads;

import java.util.Scanner;

/**
 * Created by SanthoshVarathan on 21/02/17.
 */
class processor extends Thread{
    volatile
    boolean runcontrol=true;
    public void run(){
        try{
            sleep(100);
        }
        catch(InterruptedException e){
            e.printStackTrace();

        }
        while(runcontrol) System.out.println("endless loop statment");
    }
    public void shutdown(){
        System.out.println("shutdown called");

        runcontrol=false;
    }
}
public class volatileExample {
  public static void main(String ar[]){
      processor p = new processor();
      p.start();
      Scanner in = new Scanner(System.in);
      System.out.println("press enter to stop");
      in.nextLine();
      p.shutdown();

  }
}
