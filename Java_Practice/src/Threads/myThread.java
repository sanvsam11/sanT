package Threads;

/**
 * Created by SanthoshVarathan on 24/11/16.
 */
public class myThread extends Thread {
    StringBuffer s;
    public myThread(StringBuffer s){
        this.s = s;
    }
    public void run(){
        synchronized (s){
            for(int i=0;i<100;i++)System.out.println(Thread.currentThread().getName()+" #"+i+":"+s);
            char c = s.charAt(0);c++;
            String temp = Character.toString(c);
            s.replace(0,1,temp);
        }
    }
	/*
    public static void main(String ar[]){
        StringBuffer s = new StringBuffer();
        s.append("A");
        myThread t1 = new myThread(s);t1.setName("T1");
        myThread t2 = new myThread(s);t2.setName("T2");
        myThread t3 = new myThread(s);t3.setName("T3");
        t1.start();
        t2.start();
        t3.start();
        try{
            t1.join();t2.join();t3.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }

    }
	*/
}
