package Interview_questions;

/**
 * Created by SanthoshVarathan on 08/12/16.
 * Write a Java program to replace certain characters from String like
 public String replace(String str, char ch)
 This is a tricky Java coding interview question is asked in one of the written test my friend had appeared recently. This Java coding question can be solved in multiple way e.g. by using charAt() or subString() method,  but any approach throws couple of follow-up question e.g. you may be asked to write two version to solve this coding exercise, one by using recursion and other by using Iteration. They may also ask you to write JUnit test for this function which means handling null, empty string etc. By the way this programming question is quite common on technical interviews not just Java but also C, C++ or Scala, but knowing API definitely helps to produce better solution quickly.

 Read more: http://www.java67.com/2012/08/10-java-coding-interview-questions-and.html#ixzz4SGhPgUwl
 */
public class String_Character_replace {
    static String replacerMethod(String input,char old_character,char new_character){
        StringBuilder output = new StringBuilder();
        char[] input_char_array=input.toCharArray();
        for(char input_character:input_char_array) {
            if(input_character=='#') output.append(new_character);
            else output.append(input_character);
        }
        return output.toString();
    }
    public static void main(String ar[]){
        String s = "Sa#nth#osh #Varath#an";
        char old_character = '#',new_character = '_';
        String result = String_Character_replace.replacerMethod(s,old_character,new_character);
        System.out.println("Result:"+result);
    }
}
