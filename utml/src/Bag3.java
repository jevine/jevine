import java.util.Scanner;

public class Bag3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v, w, s;
        int[] f = new int[1002];
        int[] g = new int[1002];
        int[] q = new int[1002];
        for (int i = 0; i < n; i++) {

            v = sc.nextInt();
            w = sc.nextInt();
            s = sc.nextInt();
            if (s == -1)
                s = 1;
            if (s == 0)
                s = m;
            for (int j = 0; j < v; j++) {
                int head = 0;
                int tail = -1;
                for (int k = j; k <= m; k += v) {
                    if (head <= tail && (k - q[head]) / v > s)
                        head++;
                    if (head <= tail)
                        f[k] = Math.max(f[k], g[q[head]] + (k - q[head]) / v * w);
                    while (head <= tail && g[q[tail]] + (k - q[tail]) / v * w <= g[k])
                        tail--;
                    q[++tail] = k;
                }

            }
            for (int j = 0; j <=m; j++)
                g[j]=f[j];

        }
        System.out.println(f[m]);
    }
}
