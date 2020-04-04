import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class test {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int s=sc.nextInt();
        InputStreamReader in=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(in);
        int x=Integer.parseInt(br.readLine());
        System.out.println(JumpFloor(s));
        //System.out.println(JumpFloor1(30));
    }
    public static int JumpFloor(int target) {
        int count = 1;
        for (int i = 1; i <= target / 2; i++) {

            int t = 1;
            for (int j = i; j < 2 * i; j++) {
                t = t * (target - j);
            }
            int f = 1;
            for (int j = i; j > 0; j--) {
                f = f * j;
            }
            count=count+t/f;

        }
        return count;
    }
    public static int JumpFloor1(int target){
        int[] x=new int[target];
        x[0]=1;
        x[1]=2;
        if (target==1)
            return 1;
        if (target==2)
            return 2;
        for (int i =2; i <target ; i++) {
            x[i]=x[i-1]+x[i-2];
        }

        return x[target-1];

    }
}







