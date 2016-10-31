package Threads;

//import com.sun.tools.internal.jxc.SchemaGenerator;

/**
 * Created by SanthoshVarathan on 17/10/16.
 */

public class AnonymousInner {
    public static void main(String ar[]){
        Thread t1 = new Thread(new Runnable(){
            public void run(){
                for(int i=0;i<10;i++) System.out.println("Hello:"+i);
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
            for(int i=20;i<30;i++)System.out.println("Hello:"+i);
            }
        });
        t1.start();
        t2.start();
    }
}
