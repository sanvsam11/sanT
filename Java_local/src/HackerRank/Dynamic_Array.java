package HackerRank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by SanthoshVarathan on 19/04/17.
 */
public class Dynamic_Array {
    public static void main(String ar[]){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(),Q = in.nextInt(),lastAns=0;
        List<List<Integer>> a = new ArrayList<List<Integer>>();
        for(int i=0;i<N;i++){
            List<Integer> list = new ArrayList<Integer>();
            //for(int j=0;j<N;j++) list.add(j);
            a.add(list);
        }
        for(int i=0;i<Q;i++)
        {
            boolean queryType = (in.nextInt()==1)?true:false;
            int x = in.nextInt(),y=in.nextInt();
            System.out.println("x:"+x+" y:"+y+" QueryT:"+queryType);
            for(int k=0;k<a.size();k++)
                for(int j=0;j<a.get(k).size();j++)
                    System.out.println(a.get(k).get(j));

            List<Integer> sequence = a.get((x ^ lastAns)%N);
            if(queryType)
                sequence.add(y);
            else {

                lastAns = sequence.get(y % sequence.size());
                System.out.println("Last"+lastAns);
            }
        }
    }
}
