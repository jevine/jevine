import java.util.Scanner;

public class Hamilton {
    static long[][] f=new long[1<<20][20];
    static int[][] weight=new int[20][20];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for (int i = 0; i <(1<<n) ; i++)
            for (int j = 0; j <20 ; j++)
                f[i][j]=Integer.MAX_VALUE;
        for (int i = 0; i <n ; i++)
            for (int j = 0; j <n ; j++)
                weight[i][j]=sc.nextInt();
        f[1][0]=0;
        for (int i = 0; i <(1<<n+1) ; i++) {
            for (int j = 0; j <n; j++) {
                if ((i>>j&1)==1)
                    for (int k = 0; k <n; k++) {
                        if ((i-(1<<j)>>k&1)==1)
                            f[i][j]=Math.min(f[i][j],f[i-(1<<j)][k]+weight[k][j]);
                    }
            }

        }
        System.out.println(f[(1<<n)-1][n-1]);
    }
}
