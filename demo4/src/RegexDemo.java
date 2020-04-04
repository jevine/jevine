import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {
    public static void main(String[] args) throws IOException {

        List<String> list=getMails();
        for (String s:list
             ) {
            System.out.println(s);
        }

    }

    public static List<String> getMails() throws IOException {
        //?????
        URL url=new URL("http://www.h123.com.cn/youxiang43.html");
        BufferedReader bufr =
                new BufferedReader(new InputStreamReader(url.openStream()));
        //?????????????????????????????
        String mail_regex = "\\w+@\\w+(\\.\\w+)";
        Pattern p=Pattern.compile(mail_regex);
        String line=null;
        List<String> list=new ArrayList<String>();
        while((line=bufr.readLine())!=null){
            Matcher m=p.matcher(line);
            while (m.find()){
                list.add(m.group());
            }

        }

        return list;


    }
}
