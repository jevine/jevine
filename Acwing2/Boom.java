import java.io.*;
import java.util.Scanner;

public class Boom {
 static int[][] nn=new int[5002][5002];
    /*public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        String[] item=s.split(" ");
        //int n=Integer.parseInt(item[0]);
        int r=Integer.parseInt(item[1]);
        int res=0;
        int x=r; int y=r;
        while ((s=br.readLine())!=null){
                String[] temp=s.split(" ");
                x=Math.max(x,Integer.parseInt(temp[0]));
                y=Math.max(y,Integer.parseInt(temp[0]));
                nn[Integer.parseInt(temp[0])][Integer.parseInt(temp[1])]=Integer.parseInt(temp[2]);

        }
        for (int i = 0; i <=x ; i++) {
            for (int j = 0; j <=y; j++) {
                nn[i][j]=nn[i][y-1]+nn[i-1][y]-nn[i-1][y-1];
            }

        }
        for (int i = r; i <=x ; i++) {
            for (int j = r; j <=y ; j++) {
                res=Math.max(res,nn[x][y]-nn[x-i-1][y]-nn[x][y-i-1]+nn[x-i-1][y-i-1]);
            }

        }
        System.out.println(res);
    }*/


        void run(){
            int n = jin.nextInt();
            int r = jin.nextInt();
            int row = r;
            int col = r;
            int res=0;
            while (jin.hasNext()){
                int x = jin.nextInt();
                int y = jin.nextInt();
                int w = jin.nextInt();
                nn[x+1][y+1] += w;
                row = Math.max(row, x+1);
                col = Math.max(col, y+1);
            }
            for (int i = 1; i <=row ; i++) {
                for (int j = 1; j <=col; j++) {
                    nn[i][j]+=nn[i][j-1]+nn[i-1][j]-nn[i-1][j-1];
                }

            }
            for (int i = r; i <=row ; i++) {
                for (int j = r; j <=col ; j++) {
                    res=Math.max(res,nn[i][j]-nn[i-r][j]-nn[i][j-r]+nn[i-r][j-r]);
                }

            }
            System.out.println(res);

        }

        private Scanner jin = new Scanner(System.in);
        public static void main(String[] args) throws Exception
        {new Boom().run();}
    }

