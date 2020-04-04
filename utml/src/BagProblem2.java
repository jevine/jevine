import java.util.Scanner;

public class BagProblem2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] q=new int[20001];
        int[] f=new int[20001];
        int[] g=new int[20001];
        int n=sc.nextInt();
        int m=sc.nextInt();
        for (int i = 0; i <n; i++) {
            int v=sc.nextInt();
            int w=sc.nextInt();
            int s=sc.nextInt();
            if (s == -1)
                s = 1;
            if (s == 0)
                s = m;
            for (int j = 0; j <v; j++) {
                int head=0,tail=-1;
                for (int k = j; k <=m; k+=v) {

                    if (head<=tail&&(k-q[head])/v>s)
                        head++;
                    if (head<=tail)
                        f[k]=Math.max(f[k],g[q[head]]+(k-q[head])/v*w);
                    while(head<=tail&&g[q[tail]]+(k-q[tail])/v*w<=g[k])
                        tail--;
                    q[++tail]=k;
                }

                }
            for (int k = 0; k <=m ; k++)
                g[k]=f[k];
        }
        System.out.println(f[m]);
    }
}
