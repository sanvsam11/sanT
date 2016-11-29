package Threads;

/**
 * Created by SanthoshVarathan on 25/11/16.
 */
public class account {
    int balance=50;
    public int getBalance(){
        return balance;
    }
    public void withdraw(int x)
    {
        balance-=x;
    }
    public void deposit(int x){
        balance+=x;
    }
    public static void transfer(account a,account b,int x){
        a.withdraw(x);
        b.deposit(x);
    }
}
