/**
 * Created by SanthoshVarathan on 12/10/16.
 */
import java.util.*;
public class ransomNote {
    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;

    public ransomNote(int m,int n,String magazine, String note) {magazineMap=new HashMap<String,Integer>();noteMap=new HashMap<>();
        String magazineArray[] = magazine.split("\\s");
        for(int i=0;i<m;i++) {
            magazineMap.put(magazineArray[i],magazineMap.containsKey(magazineArray[i])?magazineMap.get(magazineArray[i])+1:1);
        }
        String noteArray[] = note.split("\\s");
        for(int i=0;i<n;i++) {
            noteMap.put(noteArray[i],noteMap.containsKey(noteArray[i])?noteMap.get(noteArray[i])+1:1);
        }
    }

    public boolean solve() {
        boolean result=true;
        for(String word:noteMap.keySet()) {
            int nots = noteMap.get(word);
            for (int i = 0; i < nots; i++) {
                if (!magazineMap.containsKey(word)) {
                    result = false;
                    break;
                }
                magazineMap.put(word, magazineMap.get(word) - 1);
                if (magazineMap.get(word) == 0) magazineMap.remove(word);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        int m = 4;
        int n = 3;

        ransomNote s = new ransomNote(m,n,"s a n t","s a a");

        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");

    }
}
