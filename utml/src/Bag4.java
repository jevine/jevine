import java.util.Scanner;

public class Bag4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] f=new int[n+2][m+2];
        for (int i = 1; i <=n ; i++) {
            int num=sc.nextInt();
            for (int j = 0; j <num ; j++) {
                int v=sc.nextInt();
                int w=sc.nextInt();
                for (int k = m; k>=v; k--) {
                    f[i][k]=Math.max(f[i][k],f[i-1][k-v]+w);
                }/*f[i][k]还没有被遍历到，为0.k《v的时候f[i][k]都为0
                如果使用f[i][k]=Math.max(f[i-1][k],f[i-1][k-v]+w)，则会出现取值问题。
                例如(f[i-1][k]大于f[i-1][k-v]+w)时 f[i][k]=f[i-1][k]，但在前面num的循环中f[i][k]已经大于f[i-1][k]
                此时 f[i][k]应该等于之前的f[i-1][k-v]+w，而不是f[i-1][k]*/
            }
            for (int k = m; k>=0; k--)//需要遍历到0
            {
                f[i][k]=Math.max(f[i][k],f[i-1][k]);
            }//保证 f[i][k]最大值，应该可以优化，将j的循环放入到k中

        }
        System.out.println(f[n][m]);
    }
}

