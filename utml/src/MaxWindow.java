import java.util.Scanner;

public class MaxWindow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] f = new int[n];
        int[] g = new int[n];
        int head = 0;
        int tail = -1;
        for (int i = 0; i < n; i++) {
            f[i] = scanner.nextInt();
        }
        //min

        for (int i = 0; i < n; i++) {
            if (head <= tail && i - g[head] >= m)
                head++;
            while (head <= tail && f[g[tail]] < f[i])
                tail--;
            g[++tail] = i;
            if (i >= m - 1) {
                System.out.print(f[g[head]]);
                if (n - 1 > i)
                    System.out.print(" ");
            }
        }
        //max
        head=0;
        tail=-1;
        System.out.println();
        for (int i = 0; i < n; i++) {
            if (head <= tail && i - g[head] >= m)
                head++;
            while (head <= tail && f[g[tail]] > f[i])
                tail--;
            g[++tail] = i;
            if (i >= m - 1) {
                System.out.print(f[g[head]]);
                if (n - 1 > i)
                    System.out.print(" ");
            }









       /* q[head] = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            while (tail >= head && q[tail] > f[i]) {
                q[tail] = f[i];
                k[tail] = i;
                tail--;
            }
            if (tail < head)
                tail++;
            if (q[tail] < f[i])
                q[++tail] = f[i];
            k[tail] = i;
            if (k[tail] - k[head] >= m)
                head++;
            if (i >= m-1){
                System.out.print(q[head]);
            if (n-1>i)
                System.out.print(" ");}

        }
        g[head] = Integer.MIN_VALUE;
        System.out.println();
        for (int i = 0; i < n; i++) {
            while (tail >= head && g[tail] < f[i]) {
                g[tail] = f[i];
                k[tail] = i;
                tail--;
            }
            if (tail < head)
                tail++;
            if (g[tail] > f[i])
                g[++tail] = f[i];
            k[tail] = i;
            if (k[tail] - k[head] >= m)
                head++;
            if (i >= m-1){
                System.out.print(g[head]);
            if (n-1>i)
                System.out.print(" ");}

        }*/
        }
    }}