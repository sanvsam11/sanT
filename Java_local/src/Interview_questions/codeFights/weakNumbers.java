package Interview_questions.codeFights;

/**
 * Created by SanthoshVarathan on 02/01/17.
 */
public class weakNumbers {
    int[] weakNumbers(int n) {
        int weaknessArray[]=new int[n+1],maxWeakness=0,maxWeaknessNumberCount=0;
        int factorsCount[]=new int[n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                if(i%j==0) factorsCount[i]++;
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                if(factorsCount[j]>factorsCount[i])weaknessArray[i]++;
            }
        }
        for(int i=1;i<=n;i++){
            if(weaknessArray[i]>maxWeakness)maxWeakness=weaknessArray[i];
        }
        for(int i=0;i<=n;i++) if(weaknessArray[i]==maxWeakness)maxWeaknessNumberCount++;
        int result[]={maxWeakness,maxWeaknessNumberCount};
        return result;
    }
    public static void main(String ar[]){int answer[]=new weakNumbers().weakNumbers(9);
        System.out.println("Max weakness: "+answer[0]+" Count: "+answer[1]);
    }
}
