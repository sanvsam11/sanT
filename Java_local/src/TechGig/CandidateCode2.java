package TechGig;

import java.io.IOException;
import java.util.*;

/**
 * Created by SanthoshVarathan on 13/06/17.
 */
public class CandidateCode2 {

    static class work implements Comparator<work>{
        String id;
        int priority;
        int time;
        String skill;
        public work(String id,int priority,int time,String skill){
            this.id = id;
            this.priority = priority;
            this.time = time;
            this.skill = skill;
        }
        public int compare(work w1,work w2){
            if(w1.priority>w2.priority) return -1;
            else if(w1.priority<w2.priority) return 1;
            else{
                if(w1.time<w2.time) return 1;
                else if(w1.time>w2.time) return -1;
                else return 0;
            }
        }
    }
    public static String[] warehouseScalability(String input1[],String input2[]){
        String output[]=new String[input1.length];
        Queue<work> jobQueue = new PriorityQueue<work>(input2.length,new work(null,0,0,null));
        for(int i=0;i<input1.length;i++) output[i] = input1[i].substring(0,2);
        for(int i=0;i<input2.length;i++){
            String work[] = input2[i].split("#");
            jobQueue.add(new work(work[3],Integer.parseInt(work[1]),Integer.parseInt(work[2]),work[0]));
        }
        int workerHours[] = new int[input1.length];
        Map<Integer,String> workerMap = new HashMap<>(input2.length);
        for(int i=0;i<input1.length;i++){
            String skill = input1[i].substring(3,5);
            workerMap.put(i+1,skill);
        }
        while(!jobQueue.isEmpty()){
            work w = jobQueue.poll();
            int optimumWorker=-1;
            for(int i=0;i<input1.length;i++){
                if(workerMap.get(i+1).compareTo(w.skill)==0)
                {
                    if(optimumWorker==-1) optimumWorker=i;
                    else{
                        if(workerHours[i]<workerHours[optimumWorker]) optimumWorker = i;
                    }
                }
            }
            workerHours[optimumWorker] += w.time;
            output[optimumWorker]=output[optimumWorker].concat("#"+w.id);
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String[] output = null;
        int ip1_size = 0;
        ip1_size = Integer.parseInt(in.nextLine().trim());
        String[] ip1 = new String[ip1_size];
        String ip1_item;
        for(int ip1_i = 0; ip1_i < ip1_size; ip1_i++) {
            try {
                ip1_item = in.nextLine();
            } catch (Exception e) {
                ip1_item = null;
            }
            ip1[ip1_i] = ip1_item;
        }
        int ip2_size = 0;
        ip2_size = Integer.parseInt(in.nextLine().trim());
        String[] ip2 = new String[ip2_size];
        String ip2_item;
        for(int ip2_i = 0; ip2_i < ip2_size; ip2_i++) {
            try {
                ip2_item = in.nextLine();
            } catch (Exception e) {
                ip2_item = null;
            }
            ip2[ip2_i] = ip2_item;
        }
        output = warehouseScalability(ip1,ip2);
        for(int output_i=0; output_i < output.length; output_i++) {
            System.out.println(String.valueOf(output[output_i]));
        }
    }
}
