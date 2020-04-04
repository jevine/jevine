import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        StringBuffer sb=new StringBuffer(s);
        int[] item=new int[9];
        for (int i = 0; i <9; i++) {
            item[i]=sc.nextInt();
        }
        for (int i = 0; i <sb.length() ; i++) {
            if (sb.charAt(i)!='-') {
                int x=sb.charAt(i)-'0';
                sb.replace(i,i+1, String.valueOf(item[x-1]));
            }
        }
        System.out.println(sb.toString());
    }
}
