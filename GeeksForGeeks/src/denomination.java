/**
 * Created by SanthoshVarathan on 17/09/16.
 * GeeksforGeeks:MakeMyTrip
 * You have a certain amount of money X, which, if you invest in a bank, gets split into these denominations every year – X/2, X/3, X/4.
 * After every year, you are allowed to withdraw any denomination and any number of these three (including all of them.
 * If you withdraw all of it the total money you’ll have is x/2 + x/3 + x/4, where x is the money in the bank at the time of withdrawing).
 * Say you withdraw X/2, the money left in the bank x = X/3 + X/4. Now for the next year, this x gets split into x/2, x/3, x/4. And so on.
 * Find the maximum profit you can make.
 */
public class denomination {

    public double X2(double x){
        return x/2;
    }
    public double X3(double x){
        return x/3;
    }
    public double X4(double x){
        return x/4;
    }
    public double maxDenominationValue(double x,double v){
        if(x==0)return 0;
        else if(x==1) return 1;
        else{
            v=Math.max(
                    Math.max(v+x,v+maxDenominationValue(x-X2(x),v)),
                    Math.max(v+maxDenominationValue(x-X3(x),v),v+maxDenominationValue(x-X4(x),v)));
        }
        return v;
    }

    public static void main(String ar[]){
        denomination d = new denomination();
        System.out.println("Maximum value possible for value "+10+" is "+d.maxDenominationValue(10,0));
    }
}
