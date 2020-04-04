import java.util.Arrays;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class eggs {
    public static void main(String[] args) {

        System.out.println(superEggDrop(2,2));
    }
    public static  int superEggDrop(int K, int N) {
       int[][] dp=new int[K+1][N+1];
       int minNum=10000;
       if (K==1)
           return N;
       if (N==0)
           return 0;
       int j;
       for (int i=1;i<=N;i++){
           dp[1][i]=i;
           dp[0][i]=0;
       }
       for (int i=0;i<=K;i++)
           dp[i][0]=0;
       for (j = 1; j<=N&&K>0 ; j++) {

               minNum=min(minNum,max(dp[K-1][j-1],dp[K][N-j])+1);

       }
        System.out.println(j+"+"+K);
        System.out.println(Arrays.toString(dp[K]));
   return minNum;


    }
}
