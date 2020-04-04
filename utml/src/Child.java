import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Child {
    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader=new InputStreamReader(System.in);
        BufferedReader bf=new BufferedReader(inputStreamReader);
        int n=Integer.parseInt(bf.readLine());
        int[] h=new int[n];
        String[] str=bf.readLine().split(" ");
        for (int i = 0; i <n ; i++) {
            h[i]=Integer.parseInt(str[i]);
        }
        int j=Integer.parseInt(bf.readLine());
        int[] w=new int[j];
        str=bf.readLine().split(" ");
        int count=0;
        //int temp=0;
        Arrays.sort(h);

        for (int i = 0; i <j ; i++) {
            w[i]=Integer.parseInt(str[i]);
        }Arrays.sort(w);
        for (int i = 0; i <j ; i++) {
            if (count<n){
            if (w[i]>=h[count]){
                count++;
                //temp++;
            }}

        }
        System.out.println(count);
    }

}
