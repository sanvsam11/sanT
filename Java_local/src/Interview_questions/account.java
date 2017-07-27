package Interview_questions;

/**
 * Created by SanthoshVarathan on 13/12/16.
 */
public class account {
    static int accountCount=0;
    int balance;
    int accountNumber;
    static account createAccount(){
        accountCount++;
        account a = new account();
        return a;
    }
    public account getAccount(Integer accountNumber) {
        return this;
    }
}
