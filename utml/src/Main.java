import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] n={2,2,3,4,0,0};
        int m=4;
        int[] x=new int[m];

        System.out.println(Arrays.toString(x));
        x[0]=1;
        System.out.println(x[0]);
       /*InputStreamReader inputStreamReader= new InputStreamReader(System.in);
        BufferedReader bf=new BufferedReader(inputStreamReader);
        int n=Integer.parseInt(bf.readLine());
        int[] in=new int[n];
        String[] str=bf.readLine().split(" ");
        for (int i = 0; i <n ; i++) {
            in[i]=Integer.parseInt(str[i]);
        }
        Arrays.sort(in);
        System.out.println(Math.max((long)in[0]*in[1]*in[n-1],(long)in[n-2]*in[n-3]*in[n-1]));*/

    }
}
