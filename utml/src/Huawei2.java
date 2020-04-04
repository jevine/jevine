import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Huawei2 {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(in);
        String s=bf.readLine();

        StringBuilder sb=new StringBuilder();
        for (int i = 0; i <s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c)){
                sb.append(Character.toLowerCase(c));
            }else if (Character.valueOf(c).equals(' ')){
                sb.append(0);
            }else {
                sb.append(c);
            }
        System.out.println(sb.reverse().toString());


       /* String str = bf.readLine();
        //String s=null;
        char[] cha = str.toCharArray();
        for (int i = 0; i < cha.length; i++) {
            if (cha[i] == ' ')
                cha[i] = '0';
            if (cha[i] >= 'A' && 'Z' >= cha[i]) {
                System.out.println(cha[i]);
                cha[i] = Character.toLowerCase(cha[i]);
                System.out.println(cha[i]);
            }
        }
        String s = String.valueOf(cha);
        System.out.println(new StringBuilder(s).reverse().toString());*/

    }
}}
