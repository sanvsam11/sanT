package CrackingTheCodingInterview.LinkedList;

import java.util.*;

/**
 * Created by SanthoshVarathan on 06/07/17.
 */
public class checkListPalindrome {
    public static boolean listPalindromeCheckMethod(LinkedList<Character> list){
        node middleRunner = list.getHead(),endRunner = middleRunner, startRunner = middleRunner;
        //while(endRunner!=null||endRunner.next!=null){
           return false;
        //}
    }
    public static void main(String ar[]){
        LinkedList<Character> list = new SingleLinkedList<>();
        list.insert('A');
        list.insert('B');
        list.insert('C');
        list.insert('C');
        list.insert('B');
        list.insert('A');
        list.printList();
        System.out.println(listPalindromeCheckMethod(list));
    }
}
