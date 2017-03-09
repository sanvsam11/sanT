package Interview_questions.HtmlParsing;

/**
 * Created by SanthoshVarathan on 08/01/17.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class URLReader {
    public static void main(String[] args) throws Exception {

        URL oracle = new URL("https://www.simpleweb.org/");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(oracle.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
    }
}

