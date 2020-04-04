import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Scanner;

public class BagProblem {
    public static void main(String[] args) throws IOException {
        InputStreamReader in=new InputStreamReader(System.in);
        BufferedReader bufr=new BufferedReader(in);
        String s=null;
        StringBuffer x=new StringBuffer();


        for (int i = 0; (s=bufr.readLine())!=null; i=i+2) {
           x.append(s).append(" ");
        }
        String[] str=x.toString().split(" ");
        /*for (String t:str
             ) {
            System.out.println(t);

        }*/
        int n=Integer.parseInt(str[0]);
        int v=Integer.parseInt(str[1]);
        int[] bag=new int[n+n];
        for (int i = 0; i <2*n; i++) {
            bag[i]=Integer.parseInt(str[i+2]);
        }


        /*Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int v=sc.nextInt();
        int[] bag=new int[n+n];
        for (int i = 0; i <n+n ; i++) {
            bag[i]=sc.nextInt();
        }*/
        //System.out.println(maxValue(n, v, bag));
        System.out.println(ComBag(n, v, bag));
        bufr.close();

    }
    public static int ComBag(int n,int v,int[] bag){
        int[] myBag=new int[v+1];
        myBag[0]=0;
        for (int i = 0; i <=v ; i++) {
            for (int j = 0; j <n ; j++) {
                if (bag[2*j]<=i)
                    myBag[i]=Math.max(myBag[i-bag[2*j]]+bag[2*j+1],myBag[i]);
            }
           /* for (int j = 1; j <i/2; j++)
                myBag[i]=Math.max(myBag[i-j]+myBag[j],myBag[i]);*/
            }
        return myBag[v];
        }


    public static int maxValue(int n,int v,int[] bag){
        int[] myBag=new int[v+1];
        if (v==0){
            myBag[0]=0;
            return 0;
        }
        for (int i = 0; i <n; i++) {
            for (int j = v; j >=bag[2*i]; j--) {
                myBag[j]=Math.max(myBag[j],myBag[j-bag[2*i]]+bag[2*i+1]);

            }
            
        }
        return myBag[v];
    }
}
