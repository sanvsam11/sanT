package TechGig;

/**
 * Created by SanthoshVarathan on 11/06/17.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class job implements Comparable<job>{

    String id;
    String priority;
    String skill;
    String time;
    public job(String id,String priority,String skill,String time){
        this.id=id;
        this.priority=priority;
        this.skill=skill;
        this.time=time;
        }
        public int compareTo(job o){
            int p = Integer.parseInt(priority);
            int po = Integer.parseInt(o.priority);
            if(p<po) return 1;
            else if(p==po) return 0;
            else return -1;
        }
}
class worker implements Comparable<worker>{
    String workerBand;
    String skill;
    int time;
    List<job> jobs=new ArrayList<>();
    public worker(String workerBand,String skill){
        this.workerBand=workerBand;
        this.skill=skill;
        time=0;
    }
    public int compareTo(worker w){
        int band1 = Integer.parseInt(workerBand.substring(1)),band2 = Integer.parseInt(w.workerBand.substring(1));
        if(band1>band2) return 1;
        else if(band1==band2) return 0;
        else return -1;
    }
    public void addJobTime(int t){
        time = time + t;
    }
}
public class CandidateCode {
    public static String[] warehouseScalability(String[] input1,String[] input2)
    {
        String output[]=new String[input1.length];
        for(int i=0;i<output.length;i++) output[i]=input1[i].substring(0,2);
        worker workerList[]=new worker[input1.length];
        job jobList[]= new job[input2.length];
        for(int i=0;i<input1.length;i++){
            String a[]=input1[i].split("#");
            workerList[i]=new worker(a[0],a[1]);
        }
        for(int i=0;i<input2.length;i++){
            String a[]=input2[i].split("#");
            jobList[i]=new job(a[3],a[1],a[0],a[2]);
        }
        for(int i=1;i<jobList.length;i++)
            for(int j=0;j<i;j++){
                if(jobList[j].compareTo(jobList[i])>0){
                    job t = jobList[j];
                    jobList[j]=jobList[i];
                    jobList[i]=t;
                }
            }
        for(int i=1;i<jobList.length;i++){
            job job1=jobList[i-1],job2=jobList[i];
            if(job1.priority==job2.priority)
                if(Integer.parseInt(job1.time)>Integer.parseInt(job2.time)){
                    job t = jobList[i-1];
                    jobList[i-1]=jobList[i];
                    jobList[i]=t;
                }
        }
        for(int i=0;i<jobList.length;i++){
            int optimal=-1;
            for(int j=0;j<input1.length;j++){
                if(workerList[j].skill.compareTo(jobList[i].skill)==0)
                    if(optimal==-1)
                        optimal = j;
                    else{
                        if(workerList[j].time==workerList[optimal].time)
                        {
                            if(workerList[j].compareTo(workerList[optimal])<0)
                            optimal=j;
                        }
                        else{
                                if(workerList[j].time<workerList[optimal].time)
                                    optimal = j;
                            }
                    }
            }
            workerList[optimal].addJobTime(Integer.parseInt(jobList[i].time));
            for(int j=0;j<output.length;j++){
                if(output[j].substring(0,2).compareTo(workerList[optimal].workerBand)==0){
                    output[j]=output[j]+"#"+jobList[i].id;
                }
            }
        }
        return output;
    }
    public static void main(String[] args) throws IOException{
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
/*
4
W1#S1
W2#S2
W3#S3
W4#S1
10
S1#40#10#101
S2#10#5#102
S3#90#15#103
S3#91#20#104
S2#20#5#105
S1#20#10#106
S1#90#15#107
S2#30#20#108
S3#40#5#109
S1#50#5#110
*/