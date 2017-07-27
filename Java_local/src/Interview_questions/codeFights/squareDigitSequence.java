package Interview_questions.codeFights;

/**
 * Created by SanthoshVarathan on 29/12/16.
 */
public class squareDigitSequence {
    int squareDigitsSequence(int a0) {
        int a=0,an=0,checkArray[]=new int[100],chkAryIdx=1;checkArray[0]=a0;
        MainLoop:
        while(a!=a0){ if(a==0) a=a0;a0=a;an=0;
            while(a>0){int d = a % 10;
                an += (d * d); a/=10;
            }
            for(int i=0;i<chkAryIdx;i++)
                if(checkArray[i]==an)
                    break MainLoop;

            checkArray[chkAryIdx++]=an;
            a = an;
        }
        return chkAryIdx;
    }
    public static void main(String ar[]){
        squareDigitSequence s = new squareDigitSequence();
        System.out.println("Result:"+s.squareDigitsSequence(16));
    }
}
