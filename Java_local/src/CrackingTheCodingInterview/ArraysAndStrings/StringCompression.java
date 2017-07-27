package CrackingTheCodingInterview.ArraysAndStrings;

/**
 * Created by SanthoshVarathan on 06/07/17.
 */
public class StringCompression {
    public static String stringCompressionMethod(String input){
        StringBuilder output = new StringBuilder();
        char previousCharacter=' ';
        int previousCharacterCount = 0;
        for(char c:input.toCharArray()){
           if(previousCharacter==' ') {
               previousCharacter = c;
               previousCharacterCount = 1;
           }
           else if(c==previousCharacter)
               previousCharacterCount++;
           else{
               if(previousCharacterCount!=0){
                   output.append(previousCharacter);
                   output.append(previousCharacterCount);
                   previousCharacter = c;
                   previousCharacterCount = 1;
               }
           }
        }
        output.append(previousCharacter);
        output.append(previousCharacterCount);
        return output.toString();
    }
    public static void main(String ar[]){
       String input = "aaabbccccccddddd";
       System.out.println(stringCompressionMethod(input));
    }
}
