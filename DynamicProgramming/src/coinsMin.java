// Code for dynamic programming problem to find the minimum number of coins
//required to get an amount c
import java.util.Scanner;
public class coinsMin
{

    public int[] coinsCounterFunction(int TargetValue,int numberOfDenominations,int CoinValues[]){
            int coinCount[]=new int[numberOfDenominations];
        for(int i=0;i<numberOfDenominations;i++)coinCount[i]=0;
        int cposition=numberOfDenominations-1,cvalue=0,TV=TargetValue;
        while(true){if(TV==0||cposition<0) break; cvalue=CoinValues[cposition];
            if(TV<cvalue) cposition--;
            else{int i;
                for(i=1;(i+1)*cvalue<TV;i++);
                coinCount[cposition]=i;
                TV=TV-(i*cvalue);
                cposition--;
            }
        }

    return coinCount;}
    public static void main(String ar[]){
        Scanner in = new Scanner(System.in);
        int TargetValue=in.nextInt(),numberOfDenominations=in.nextInt(),CoinValues[]=new int[numberOfDenominations];
        for(int i=0;i<numberOfDenominations;i++)CoinValues[i]=in.nextInt();
        coinsMin ob = new coinsMin();
        int outputcoincountarray[]= ob.coinsCounterFunction(TargetValue,numberOfDenominations,CoinValues);
        for(int i=0;i<numberOfDenominations;i++)System.out.println(outputcoincountarray[i]);

    }
}