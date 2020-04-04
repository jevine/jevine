import java.util.Scanner;

public class Gailv {
    static double res=0.0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double n=Integer.parseInt(sc.next());
        double m=Integer.parseInt(sc.next());
        System.out.println(dfs(n, m, 0, -1,1.0));
    }
    private static double dfs(double n, double m,int count,int temp,double dummy) {
        if (n==-1||m==-1)
            return res;
        if (count==1&&temp==1){
            dummy = dummy * (n + 1) / (n+ m + 1);
            res+=dummy;
            System.out.println(res);
            return res;
        }
        else if (count==1||(count==2&&temp==0)||(count==0&&temp==0)){
            dummy = dummy * (m + 1) / (n + m + 1);
        }
        else if (count==0&&temp==1){
            dummy  = dummy * (n + 1) / (n + m + 1);
        }
        else if (count==2&&temp==1)
            return res;
        count++;
        dfs(n-1,m,count%3,1,dummy);
        dfs(n,m-1,count%3,0,dummy);
        return res;
    }
}
