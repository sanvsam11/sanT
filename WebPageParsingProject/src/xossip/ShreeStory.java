package xossip;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by SanthoshVarathan on 09/03/17.
 */
public class ShreeStory {
    public static void main(String ar[])throws IOException{
        String url = "http://www.xossip.com/showthread.php?t=630332&page=";
        Integer pageNumber = 2;
        Document page = Jsoup.connect(url+pageNumber.toString()).get();
        String pageString = page.body().text();
        Pattern p = Pattern.compile("");
        Matcher m = p.matcher(pageString);
        StringBuilder story = new StringBuilder();
        //m.find();
        //story.append(m.group(1));
        System.out.println(page.body().text());
    }
}
