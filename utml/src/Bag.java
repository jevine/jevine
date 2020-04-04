import java.util.Scanner;
//way one
/*
public class Bag {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[] f=new int[101];
        for (int i = 0; i <n ; i++) {
            int v=sc.nextInt();
            int w=sc.nextInt();
            int s=sc.nextInt();
            for (int j = m; j >=0; j--) {
                for (int k = 1; k <= s&&j>=k*v; k++) {
                    f[j]=Math.max(f[j],f[j-k*v]+w*k);

                }
            }
        }
        System.out.println(f[m]);
    }
}
*/
//way two 二进制
public class Bag{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int x=0;
        //int y=0;
        int[] f=new int[27000];
        for (int i = 0; i <n; i++) {
            int v,w,s;
            v=sc.nextInt();
            w=sc.nextInt();
            s=sc.nextInt();
            for (int j = 1; j <=s ; j*=2) {
                s-=j;
                f[x]=j*v;
                x++;
                f[x]=j*w;
                x++;
            }
            f[x]=s*v;
            x++;
            f[x]=s*w;
            x++;

        }
        int[] q=new int[m+1];
        for (int i = 0; i <x; i+=2) {
            for (int j = m; j>=f[i]; j--) {
               q[j]=Math.max(q[j],q[j-f[i]]+f[i+1]);
            }
        }
        System.out.println(q[m]);
    }
}
