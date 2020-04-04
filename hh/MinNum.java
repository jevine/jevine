
import java.util.*;

class way implements Comparator<Integer> {
    @Override
    public int compare(Integer x, Integer y) {

        return Integer.valueOf(x.toString()+y.toString())-Integer.valueOf(y.toString()+x.toString());
    }
}
public class MinNum {
    public static void main(String[] args) {
        System.out.println(new MinNum().longestSubstringWithoutDuplication("chbmmcg"));
    }

    public int getMaxValue(int[][] grid) {
       int x=grid.length;
       int y=grid[0].length;
       int[][] f=new int[x+1][y+1];
        for (int i = 1; i <x+1 ; i++) {
            for (int j = 1; j <y+1 ; j++) {
                f[i][j]=Math.max(f[i-1][j],f[i][j-1])+grid[i-1][j-1];
            }
        }
        return f[x][y];

    }
    public int longestSubstringWithoutDuplication(String s) {
        String[] item=s.split("");
        int max=0;
        Map<String,Integer> map=new HashMap<>();
        for (int i = 0,j=0; j <item.length; j++) {
            if (map.containsKey(item[j])){
                while (!item[i].equals(item[j])){
                    map.remove(item[i]);
                    i++;
                }
                map.remove(item[i]);
                i++;
                System.out.println(i);
            }
                map.put(item[j],j);
            //System.out.println(j-i+1);
            max=Math.max(max,j-i+1);
        }
            return max;

    }

    public int lastRemaining(int n, int m) {
        if (n==0||m==0)
            return 0;
        List<Integer> list=new LinkedList<>();
        for (int i = 0; i <n ; i++) {
            list.add(i);
        }
        int index=0;
        while(list.size()!=1){
            index=(index+m-1)%list.size();
            list.remove(index);

        }
        return list.get(0);

    }
    void mi(){
        Scanner sc=new Scanner(System.in);
        long a=Long.parseLong(sc.next());
        long b=Long.parseLong(sc.next());
        long p=Long.parseLong(sc.next());
        long res=0L;
        while(b!=0){
            if((b&1)==0)
                res=(res+a)%p;
            b=b>>1;
            a=(a*2)%p;
        }
        System.out.println(res);
    }

    public int getSum(int n) {
        int res=n;
        boolean flag=(n>0)&&(res+=res+getSum(n-1))>0;
        return res;



    }
}

