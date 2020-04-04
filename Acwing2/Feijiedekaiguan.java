import java.util.Arrays;
import java.util.Scanner;

public class Feijiedekaiguan {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] item=new int[7][7];
        while (n-->0){
            for (int i = 1; i <=5; i++){
                String[] str=sc.next().split("");
                System.out.println(Arrays.toString(str));
                for (int j =1; j <=5; j++)
                    item[i][j]=Integer.parseInt(str[j-1]);
            }
             int[][] temp=new int[7][7];
            for (int i = 1; i <6; i++) {
                System.arraycopy(item[i], 1, temp[i], 1, 5);
            }
            int res=7;
            for (int i = 0; i <1<<5; i++) {
                int res1=0;
                for (int j = 1; j <6; j++) {
                    System.arraycopy(item[j], 1, temp[j], 1, 5);
                }

                for (int j = 1; j <=5; j++) {
                    if ((i>>j-1&1)==1){
                        res1++;
                        temp[1][j]=temp[1][j]^1;
                        temp[1][j-1]=temp[1][j-1]^1;
                        temp[1][j+1]=temp[1][j+1]^1;
                        temp[2][j]=temp[2][j]^1;
                    }
                }
                for (int j = 1; j <5 ; j++) {
                    for (int k = 1; k <6 ; k++) {
                        if (temp[j][k]==0){
                            res1++;
                            temp[j+1][k]^=1;
                            temp[j+1][k-1]^=1;
                            temp[j+1][k+1]^=1;
                            temp[j][k]^=1;
                            temp[j+2][k]^=1;
                        }
                    }
                }
                for (int j = 1; j <6; j++) {
                    if (temp[5][j]==0)
                        res1=7;
                }
                res=Math.min(res,res1);
            }
            System.out.println(res>6?-1:res);
        }
    }



}
