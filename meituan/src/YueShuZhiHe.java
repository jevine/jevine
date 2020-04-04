import java.util.Scanner;

//约数之和 快速求约数 快速幂
public class YueShuZhiHe {
    private static int mod=9901;
    static int qmi(int x,int y){
        int res=1;
        x%=mod;
        while (y!=0){
            if ((y&1)==1) res=res*x%mod;
            x=x*x%mod;
            y>>=1;
        }
        return res;
    }
    static int sum(int x,int y){
        if (y==0)
            return 1;
        if (y%2==0){
            return (x%mod*sum(x,y-1)+1)%mod;
        }
        return (1+qmi(x,y/2+1))*sum(x,y/2)%mod;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int res=1;
        for (int i = 2; i <=a; i++) {
            int s=0;
            while (a%i==0){
                a/=i;
                s++;
            }
            if (s!=0)
                res=res*sum(i,s*b)%mod;
        }
        if (a==0)
            res=0;
        System.out.println(res);
    }
}
