import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Scanner;

public class two {
    public static void main(String[] args) {
        double PI=Math.PI;
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int temp;
        double res=0;
        double[] item=new double[num];
        for (int i = 0; i <num; i++) {
            temp=sc.nextInt();
            item[i]=temp*temp*PI;
        }
        Arrays.sort(item);
        if (num%2==0)
        for (int i = 0; i <num; i+=2) {
            res=res+item[i+1]-item[i];
        }
        if (num%2==1) {
           res=res+item[0];
            for (int i = 1; i <num ; i+=2) {
                res=res+item[i+1]-item[i];
            }
        }
        NumberFormat nf=NumberFormat.getInstance();
        nf.setMaximumFractionDigits(5);
        System.out.println(nf.format(res));
    }
}
