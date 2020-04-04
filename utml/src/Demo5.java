import java.util.Arrays;
import java.util.Scanner;

public class Demo5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int len=sc.nextInt();
        int[] in=new int[len];
        //int[] hh=new int[len];
        for (int i = 0; i <len ; i++) {
            in[i]=sc.nextInt();
        }
        int max1 = Integer.MIN_VALUE,
                max2 = Integer.MIN_VALUE,
                max3 = Integer.MIN_VALUE,
                min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        //Arrays.sort(in);
        for (int n:in
             ) {
                if (n > max1) {
                    max3 = max2;
                    max2 = max1;
                    max1 = n;
                } else if (n > max2) {
                    max3 = max2;
                    max2 = n;
                } else if (n > max3) {
                    max3 = n;
                }

                if (n < min1) {
                    min2 = min1;
                    min1 = n;
                } else if (n < min2) {
                    min2 = n;
                }
            }

            //System.out.println(x);
        System.out.println(Math.max((long)max1*max2*max3, (long)max1*min1*min2));
        }
        //long x=Math.max((long)in[0]*in[1]*in[len-1],(long)in[len-2]*in[len-3]*in[len-1]);
        //System.out.println(in[0]*in[1]*in[len-1]+"    "+in[len-2]*in[len-3]*in[len-1]);

    }

