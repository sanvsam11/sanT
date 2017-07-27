package Interview_questions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SanthoshVarathan on 13/12/16.
 */
public class bank {
    Map<Integer,account> accountList = new HashMap<Integer,account>();
    account current_account;
    void getAccount(account accountNumber){
       current_account=accountList.get(accountNumber);
    }
    boolean drawCash(int withdrawlAmount){
        if(current_account.balance>withdrawlAmount) {
            current_account.balance -= withdrawlAmount;
            return true;
        }
        return false;
    }
    void deposit(int depositAmount){
        current_account.balance+=depositAmount;
    }
    public static void main(String ar[]){

    }
}
