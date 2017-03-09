package Interview_questions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SanthoshVarathan on 13/12/16.
 */
public class ATM {
    int accountNumber;
    bank bank_instance;
    account current_account;
    Map<String,bank> bankList = new HashMap<String,bank>();
    public void displayBalance(int accountNumber){
        System.out.println("The balance for the account number: "+current_account.accountNumber+" is :" +current_account.balance );
    }
    public void getAccountNumber(int accNum){
       accountNumber=accNum;
        if(bank_instance!=null) current_account=bank_instance.accountList.get(accNum);
    }
    public void getBankName(String bank_name){
        bank_instance=bankList.get(bank_name);
    }
    public void withdrawAmount(int amount_to_withdraw){
        boolean withdrawl_complete = bank_instance.drawCash(amount_to_withdraw);
        if(withdrawl_complete) System.out.println("Please collect the money.");
        else System.out.println("Insufficient Funds.");
    }
}
