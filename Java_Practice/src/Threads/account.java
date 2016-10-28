package Threads;

/**
 * Created by SanthoshVarathan on 25/10/16.
 */
public class account {
    private int balance=10000;

    public void deposit(int d){
        balance+=d;
    }
    public void withdrawl(int w){
        balance-=w;
    }
    public int getBalance(){
        return balance;
    }
    static public void transfer(account a1,account a2,int amount){
        a2.balance+=amount;
        a1.balance-=amount;
    }
}
