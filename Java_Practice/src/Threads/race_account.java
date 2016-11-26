package Threads;

/**
 * Created by SanthoshVarathan on 25/11/16.
 */
public class race_account implements Runnable{
    account a = new account();
    public void draw(account a){
            if (a.getBalance() >= 10) {
                System.out.println(Thread.currentThread().getName()+" is going to draw cash.");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                a.withdraw(10);
                System.out.println(Thread.currentThread().getName() + " has withdrawn 10$"+" Remaining balance: "+a.getBalance()+"$");
            } else System.out.println(Thread.currentThread().getName()+" says Account Balance: " + a.getBalance());

    }
    public void run(){ int cash_fred=0,cash_lucy=0;
        int id=(Thread.currentThread().getName().equals("Fred"))?0:1;
        for(int i=0;i<5;i++) {
            synchronized (this) {
                draw(a);
                if (id == 0) cash_fred += 10;
                else cash_lucy += 10;
            }
            Thread.yield();
            if (a.getBalance() < 0) System.out.println(id+":Account overdrawn!!!");
        }
        System.out.println(id+":"+Thread.currentThread().getName()+" has "+((id==0)?cash_fred:cash_lucy));
    }
    public static void main(String ar[]){
        race_account r = new race_account();
        Thread fred = new Thread(r);
        fred.setName("Fred");
        Thread lucy = new Thread(r);
        lucy.setName("Lucy");
        fred.start();
        lucy.start();
        try{
            fred.join();lucy.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
