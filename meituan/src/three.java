import java.util.Scanner;

public class three {
    static int n;
    static int count=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        int[] item =new int[n];
        for (int i = 0; i <n ; i++) {
            item[i]=sc.nextInt();
        }
        System.out.println(dsf(0, 0, item));
    }

    private static int dsf(int u, int state, int[] item) {
        if (u==n){
            int i;
            for (i=0; i <n; i++) {
                if ((state>>i&1)==1){
                    if (i%item[i]!=0)
                        break;
                    if (i==n-1)
                        count++;
                }
            }
            return count;
        }
        dsf(u+1,state,item);
        dsf(u+1,state|1<<u,item);
        return count;
    }
}
