import java.util.*;

public class Xiaoji {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int k=sc.nextInt();
        Integer[] item=new Integer[n];
        long res=0L;
        for (int i = 0; i <n; i++) {
            item[i]=sc.nextInt();
            res+=item[i];
        }
        res+=k*m*n;
        Arrays.sort(item, (o1, o2) -> o2-o1);
        LinkedList<save> list=new LinkedList<>();
        for (int i = 0; i <m ; i++) {
            if (list.isEmpty()||item[i]+k*i+k>list.get(0).x+(i-list.get(0).y)*k){
                res=res-(item[i]+i*k+k)/2;
                list.add(new save((item[i]+i*k+k)/2,i));
            }
            else if (item[i]+k*i+k<=list.get(0).x+(i-list.get(0).y)*k){
                int x=list.pollFirst().x/2+(i-list.get(0).y)*k;
                res-=x;
                list.add(new save(x,i));
            }
        }
        System.out.println(res);
    }

}
class save{
    int x;int y;
    public save(int x,int y){
        this.x=x;
        this.y=y;
    }
}
