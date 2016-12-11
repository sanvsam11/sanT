package Interview_questions;

/**
 * Created by SanthoshVarathan on 08/12/16.
 * Write a Java program to print Fibonacci series upto 100?
 This is one of the most popular coding interview question asked in Java programming language. Even though, Writing program for Fibonacci series is one of the basic Java program, not every Java developer get it right in interview. Again interview can ask to solve this programming interview question, by using recursion or Iteration. This Java programming question also test your problem solving skills and if you come up with an original solution, that may even help. See here for complete code example of Fibonacci series in Java

 Read more: http://www.java67.com/2012/08/10-java-coding-interview-questions-and.html#ixzz4SGjlTjIl
 */
public class fibonacci_100 {
    static long[] fibonacci_interative(){
        long a=-1,b=1,c[]=new long[100];
        for(int i=0;i<100;i++){
            c[i]=a+b;
            a=b;b=c[i];
        }
        return c;
    }
    static void fibonacci_recursive(int i,long c,long a,long b){
        if(i<100) {
            c=a+b;a=b;b=c;
            System.out.print(c+" ");
          fibonacci_recursive(i+1,c,a,b);

         }
    }
    public static void main(String ar[]){
        long result[]=fibonacci_100.fibonacci_interative();
        for(long i:result)System.out.print(i+" ");
        System.out.println();
        fibonacci_100.fibonacci_recursive(0,0,-1,1);
    }
}
