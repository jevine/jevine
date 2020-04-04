public class shulie {
    public static void main(String[] args) {
        System.out.println(fib2(11));
    }

    public static int math(int x) {
        int c = 0;
        int b = 1;
        int a = 1;
        if (x == 1 || x == 2)
            return 1;
        else {
            for (int i = 0; i < x / 3; i++) {
                c = a + b;
                a = c + b;
                b = c + a;
            }
            if (x % 3 == 1)
                return a;
            if (x % 3 == 2)
                return b;
            else
                return c;
        }
    }

    public static int fib(int x) {
        if (x == 1 || x == 2) {
            return 1;
        }
        return fib(x - 1) + fib(x - 2);
    }

    public static int fib2(int x) {
        int[] dp = new int[x];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < x; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[x-1];
    }
}

