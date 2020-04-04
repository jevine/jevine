import java.util.Scanner;

public class IncDec {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long[] item=new long[n];
        for (int i = 0; i <n; i++) {
            item[i]=Long.parseLong(sc.next());
        }
        long p=0L,q=0L;
        for (int i = 1; i <n; i++) {
            long c=item[i]-item[i-1];
            if (c>0)
                q+=c;
            else p-=c;
        }
        System.out.println(Math.max(p,q));
        System.out.println(Math.abs(p-q)+1);
    }
}
