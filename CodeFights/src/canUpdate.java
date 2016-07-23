/**
 * Created by SanthoshVarathan on 12/03/2016 AD.
 */
public class canUpdate {
    boolean canUpdate(String newUsername, String curUsername, boolean isChanged, String[] users) {
        boolean exactmatchnew=false,partialmatchnew=false,partialmatchcur=false,exactmatchcur=false,canupdate=false;
        for(int i=0;i<users.length;i++){
            if(newUsername.compareToIgnoreCase(users[i])==0) partialmatchnew=true;
            else if(newUsername==users[i])exactmatchnew=true;
            else if(curUsername.compareToIgnoreCase(users[i])==0) partialmatchcur=true;
            else if(curUsername==users[i])exactmatchcur=true;                             }
        if((!partialmatchnew)&&(!isChanged)) canupdate=true;
        else if((partialmatchnew)&&isChanged&&exactmatchcur) canupdate=true;
        return exactmatchcur;}
    public static void main(String ar[]){
        canUpdate ob = new canUpdate();
        String newUsername ="Santhosh",curUsername="santhosh";
        String []users=new String[2];
        users[0]= "santhosh";
        users[1]="varathan";
        System.out.println(ob.canUpdate(newUsername,curUsername,true,users));
    }
}
