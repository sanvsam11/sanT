package Interview_questions.codeFights;

/**
 * Created by SanthoshVarathan on 01/01/17.
 */
public class comfortableNumbers {
    int comfortableNumbers(int L, int R) { int result=0;
        for(int i=L;i<=R;i++){int x = i;
            int d = 0; while(x>0){d+=x%10;x/=10;}
            for(int j=i-d;j<=(i+d);j++){
                if(j>=L&&j<=R&&j>i) result++;
            }
        }
        return result;
    }
    public static void main(String ar[]){
        System.out.println("Result: "+new comfortableNumbers().comfortableNumbers(10,12));
    }
}
