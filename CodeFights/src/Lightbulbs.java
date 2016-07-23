/**
 * Created by SanthoshVarathan on 09/03/2016 AD.
 */
public class Lightbulbs {
    int[] circularShift(int lights[],int n){int  count=0;int l=lights.length,i=0;
        while(n>0){
            System.out.println(i);
        i++;if(i==l)n--;}
    return lights;}

  public static void main(String ar[]){
      int a[]={0,1,1,0,1};
      int n=2;
      Lightbulbs ob = new Lightbulbs();
      System.out.println("Output after "+n+" turns is ");
      a = ob.circularShift(a,n);

  }
}
