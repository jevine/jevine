import java.util.Scanner;

public class five {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        long[][] sum=new long[k+1][n];
        for (int i = 0; i <n ; i++) {
            sum[0][i]=sc.nextInt();
        }
        for (int i = 1; i <=k; i++) {
            for (int j = 0; j <n; j++) {
                if (j==0)
                    sum[i][j]=sum[i-1][j]%(1000000009);
                else
                sum[i][j]=(sum[i][j - 1] + sum[i - 1][j])%(1000000009);
            }
        }
        System.out.println(sum[k][n-1]%(1000000009));
    }
}
