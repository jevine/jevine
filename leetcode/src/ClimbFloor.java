public class ClimbFloor {
    public static void main(String[] args) {
        System.out.println(new ClimbFloor().climbStairs(2));
    }
    //dp[n]=dp[n-1]+dp[n-2]
    //或者可以用斐波那契公式
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for (int i=2;i<=n;i++)
            dp[i]=dp[i-2]+dp[i-1];
        return dp[n];
    }
    public int climbStairs2(int n) {
        double sq=Math.sqrt(5);
        return (int)((Math.pow(((1+sq)/2),n+1)-Math.pow(((1-sq)/2),n+1))/sq);
    }
}
