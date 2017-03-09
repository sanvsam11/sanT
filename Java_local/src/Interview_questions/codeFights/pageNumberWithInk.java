package Interview_questions.codeFights;

/**
 * Created by SanthoshVarathan on 30/12/16.
 */
public class pageNumberWithInk {
    int pagesNumberingWithInk(int current, int numberOfDigits) {
        int digitCountCurrent=0,x=current;
        while(x>0){x/=10;digitCountCurrent++;}
        while(true){
            numberOfDigits-=digitCountCurrent;
            x=current++;digitCountCurrent=0;while(x>0){x/=10;digitCountCurrent++;}
            if(numberOfDigits<digitCountCurrent) break;
        }
        return current-1;
    }
    public static void main(String ar[]){
        pageNumberWithInk p = new pageNumberWithInk();
        System.out.println("result: "+p.pagesNumberingWithInk(76,250));
    }
}
