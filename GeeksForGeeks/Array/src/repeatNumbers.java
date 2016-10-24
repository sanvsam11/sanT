/*
* MakeMyTrip Interview Question:
* Given an array of sorted integers, with many of them repeating,
 * and an element x, find the number of occurrences of x.
 * Expected time complexity O(lgn)
 *
 * http://www.geeksforgeeks.org/makemytrip-interview-experience-set-12/
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import static java.lang.Integer.*;
import static java.util.Arrays.binarySearch;

public class repeatNumbers
{
    public int getRepeatingNumber(int a[],int n,int x){
        int rep=0,xl,xr;
        xl=binarySearch(a,0,9,x);
        xr=xl;
        while(a[xl--]==x&&xl>=0)rep++;
        while(a[++xr]==x&&xr<n)rep++;
        return rep;
    }
    public static void main(String ar[]) throws IOException {
        int n,x;
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        n= parseInt(br.readLine());
        int a[]=new int[n];
        Scanner ins = new Scanner(System.in);
        x=ins.nextInt();
        for(int i=0;i<n;i++) a[i]=ins.nextInt();
        repeatNumbers r = new repeatNumbers();
        System.out.println(r.getRepeatingNumber(a,n,x));
    }
}