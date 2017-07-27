package Interview_questions;

/**
 * Created by SanthoshVarathan on 25/12/16.
 */
public class Candles {
    int candles(int candlesNumber, int makeNew) {
        int result = 0, newCandles = 0, leftover = 0;boolean noLeftovers=false;
        while (!noLeftovers) {
            leftover += candlesNumber;//burn candles
            result += candlesNumber;
            candlesNumber = 0;//add burnt candles to result
            newCandles = leftover / makeNew; //make new candles from leftovers
            leftover -= (newCandles * makeNew);//remove leftovers made to candles
            candlesNumber = newCandles;
            newCandles=0;
            if(leftover<makeNew&&candlesNumber==0)noLeftovers=true;
        }
        return result;
    }
    public static void main(String ar[]){
        System.out.println("Result:"+new Candles().candles(11,3) );
    }
}